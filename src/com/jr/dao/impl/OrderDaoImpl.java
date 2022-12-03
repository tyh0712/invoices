package com.jr.dao.impl;

import com.jr.dao.IOrderDao;
import com.jr.entry.InvoicingRecord;
import com.jr.entry.Order;
import com.jr.util.DBHelper;

import java.io.IOException;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @Auther:唐一涵
 * @Date:2022/12/1
 * @Description: com.jr.dao.impl
 * @version: 1.0
 */
public class OrderDaoImpl implements IOrderDao {
    UniversalMethod um = new UniversalMethod();
    Connection con ;
    PreparedStatement ps ;
    ResultSet rs;

    @Override
    public double selectTotalAmountByEId(int enterpriseId) {
        int count = 0;
        try {
            con = DBHelper.getcon();
            String sql = "select total_amount from `order` where enterprise_id=?";
            ps = con.prepareStatement(sql);
            ps.setInt(1,enterpriseId);
            rs = ps.executeQuery();
            while (rs.next()){
                count += rs.getDouble(1);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return count;
    }

    @Override
    public double selectTotalAmountByEIdAndStatus(int enterpriseId) {
        int count = 0;
        try {
            con = DBHelper.getcon();
            String sql = "select total_amount from `order` where enterprise_id=? and invoicing_status=?";
            ps = con.prepareStatement(sql);
            ps.setInt(1,enterpriseId);
            ps.setString(2,"A");
            rs = ps.executeQuery();
            while (rs.next()){
                count += rs.getDouble(1);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return count;
    }

    @Override
    public List<Order> selectOrderByStatus(int judge, String invoicingStatus, Object... objs) {
        Order order;
        List<Order> list = new ArrayList<>();
        try {
            con = DBHelper.getcon();
            Map<Integer,String> str=new TreeMap<>();
            Map<Integer,Object> objs1=new TreeMap<>();
            String str1=null;
            String str4="invoicing_status=?";
            int x=0;
            for (int i=0;i<objs.length;i++) {
                if (objs[i] instanceof String) {
                    str.put(i+1,"no=?");
                    objs1.put(i+1,objs[i]);
                }
                else if (objs[i] instanceof Date) {
                    str.put(i+1,"create_time=?");
                    objs1.put(i+1,objs[i]);
                }
                else if (objs[i] instanceof Double) {
                    if (judge==1){
                        str.put(i+1,"total_amount>?");
                        objs1.put(i+1,objs[i]);

                    }else if (judge==2){
                        str.put(i+1,"total_amount<?");
                        objs1.put(i+1,objs[i]);

                    }else{
                        if (x==0){
                            str.put(i+1,"total_amount>?");
                        }
                        objs1.put(i+1,objs[i]);
                        if (x!=0){
                            if ((double)objs1.get(i+1)<(double)objs1.get(x)){
                                objs1.put(i+1,objs[x-1]);
                                objs1.put(x,objs[i]);
                                str.put(i+1,"total_amount<?");
                            }else {
                                str.put(i+1,"total_amount<?");
                            }
                        }x=i+1;
                    }
                }
            }
            if (str.size()==0){
                str1=str4;
            }else {
                for (int i=1;i<=str.size();i++){
                    if (i==1){
                        str1=str4+" AND "+str.get(1);
                    }else {
                        str1=str1+" AND "+str.get(i);
                    }
                }
            }
            String sql="select * from `order` where "+str1+"";
            ps = con.prepareStatement(sql);
            ps.setString(1,invoicingStatus);
            for (int i=1;i<=objs1.size();i++){
                ps.setObject(i+1,objs1.get(i));
            }
            rs = ps.executeQuery();
            while (rs.next()){
                order = new Order();
                order.setOid(rs.getInt(1));
                order.setNo(rs.getString(2));
                order.setTotalAmount(rs.getDouble(3));
                order.setEnterpriseId(rs.getInt(4));
                order.setEnterpriseName(rs.getString(5));
                InvoicingRecord invoicingRecord = new InvoicingRecord();
                invoicingRecord.setStatus(rs.getString(6));
                invoicingRecord.setIid(rs.getInt(7));
                order.setInvoicingRecord(invoicingRecord);
                order.setCreateTime(rs.getTimestamp(8));
                list.add(order);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public int updateOrderStatus(int invoicingRecordId) {
        String sql = "update `order` set invoicing_status='B' where invoicing_record_id=?";
        return um.upd(sql,invoicingRecordId);
    }

    @Override
    public List<Order> selectOrderByIId(int invoicingRecordId) {
        Order order;
        List<Order> list = new ArrayList<>();
        try {
            con = DBHelper.getcon();
            String sql = "select * from `order` where invoicing_record_id=?";
            ps = con.prepareStatement(sql);
            ps.setInt(1,invoicingRecordId);
            rs = ps.executeQuery();
            while (rs.next()){
                order = new Order();
                order.setOid(rs.getInt(1));
                order.setNo(rs.getString(2));
                order.setTotalAmount(rs.getDouble(3));
                order.setEnterpriseId(rs.getInt(4));
                order.setEnterpriseName(rs.getString(5));
                InvoicingRecord invoicingRecord = new InvoicingRecord();
                invoicingRecord.setStatus(rs.getString(6));
                invoicingRecord.setIid(rs.getInt(7));
                order.setInvoicingRecord(invoicingRecord);
                order.setCreateTime(rs.getTimestamp(8));
                list.add(order);
                System.out.println(order);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return list;
    }
}
