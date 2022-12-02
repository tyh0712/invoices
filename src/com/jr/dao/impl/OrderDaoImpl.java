package com.jr.dao.impl;

import com.jr.dao.IOrderDao;
import com.jr.entry.InvoicingRecord;
import com.jr.entry.Order;
import com.jr.util.DBHelper;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
    public double selectTotalAmountByEIdAndStatus(int enterpriseId, String invoicingStatus) {
        int count = 0;
        try {
            con = DBHelper.getcon();
            String sql = "select total_amount from `order` where enterprise_id=? and invoicing_status=?";
            ps = con.prepareStatement(sql);
            ps.setInt(1,enterpriseId);
            ps.setString(2,invoicingStatus);
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
    public List<Order> selectOrderByStatus(String invoicingStatus) {
        Order order;
        List<Order> list = new ArrayList<>();
        try {
            con = DBHelper.getcon();
            String sql = "select * from `order` where invoicing_status=?";
            ps = con.prepareStatement(sql);
            ps.setString(1,invoicingStatus);
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
