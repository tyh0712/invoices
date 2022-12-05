package com.jr.dao.impl;

import com.jr.dao.IInvoicingRecordDao;
import com.jr.entry.*;
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
public class InvoicingRecordDaoImpl implements IInvoicingRecordDao {
    Connection con=null;
    PreparedStatement ps=null;
    ResultSet rs=null;
    UniversalMethod um=new UniversalMethod();
    @Override
    public List<InvoicingRecord> selectIRByEId(int enterpriseId) {
        ArrayList<InvoicingRecord> list=new ArrayList<>();
        try {
            con= DBHelper.getcon();
            String sql="SELECT ir.id,ir.create_time,bd.title,ir.amount,ir.uplink_address,ir.`status` FROM invoicing_record ir,base_data bd WHERE ir.base_data_id=bd.id AND ir.enterprise_id=?";
            ps=con.prepareStatement(sql);
            ps.setInt(1,enterpriseId);
            rs=ps.executeQuery();
            while (rs.next()){
                InvoicingRecord ir=new InvoicingRecord();
                ir.setIid(rs.getInt(1));
                ir.setCreatorTime(rs.getDate(2));
                BaseData baseData = new BaseData();
                baseData.setTitle(rs.getString(3));
                ir.setBaseData(baseData);
                ir.setAmount(rs.getDouble(4));
                ir.setUplinkAddress(rs.getString(5));
                ir.setStatus(rs.getString(6));
                list.add(ir);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            DBHelper.close(rs,ps,con);
        }
        return list;
    }

    @Override
    public int selectIdByUplinkAddress(String uplinkAddress) {
        int num=0;
        try {
            con=DBHelper.getcon();
            String sql="SELECT id FROM invoicing_record WHERE  uplink_address=?;";
            ps= con.prepareStatement(sql);
            ps.setString(1,uplinkAddress);
            rs=ps.executeQuery();
            while (rs.next()){
                num=rs.getInt(1);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            DBHelper.close(rs,ps,con);
        }
        return num;
    }

    @Override
    public List<InvoicingRecord> selectIRByStatus(int enterpriseId, String status) {
        ArrayList<InvoicingRecord> list=new ArrayList<>();
        try {
            con= DBHelper.getcon();
            String sql="SELECT ir.id,ir.create_time,bd.title,ir.amount,ir.uplink_address,ir.`status` FROM invoicing_record ir,base_data bd WHERE ir.base_data_id=bd.id AND ir.enterprise_id=? AND ir.`status`=?";
            ps=con.prepareStatement(sql);
            ps.setInt(1,enterpriseId);
            ps.setString(2,status);
            rs=ps.executeQuery();
            while (rs.next()){
                InvoicingRecord ir=new InvoicingRecord();
                ir.setIid(rs.getInt(1));
                ir.setCreatorTime(rs.getDate(2));
                BaseData baseData = new BaseData();
                baseData.setTitle(rs.getString(3));
                ir.setBaseData(baseData);
                ir.setAmount(rs.getDouble(4));
                ir.setUplinkAddress(rs.getString(5));
                ir.setStatus(rs.getString(6));
                list.add(ir);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            DBHelper.close(rs,ps,con);
        }
        return list;
    }

    @Override
    public List<InvoicingRecord> selectIRByTitle(int enterpriseId, String title) {
        ArrayList<InvoicingRecord> list=new ArrayList<>();
        try {
            con= DBHelper.getcon();
            String sql="SELECT ir.id,ir.create_time,bd.title,ir.amount,ir.uplink_address,ir.`status` FROM invoicing_record ir,base_data bd WHERE ir.base_data_id=bd.id AND ir.enterprise_id=? AND bd.title=?";
            ps=con.prepareStatement(sql);
            ps.setInt(1,enterpriseId);
            ps.setString(2,title);
            rs=ps.executeQuery();
            while (rs.next()){
                InvoicingRecord ir=new InvoicingRecord();
                ir.setIid(rs.getInt(1));
                ir.setCreatorTime(rs.getDate(2));
                BaseData baseData = new BaseData();
                baseData.setTitle(rs.getString(3));
                ir.setBaseData(baseData);
                ir.setAmount(rs.getDouble(4));
                ir.setUplinkAddress(rs.getString(5));
                ir.setStatus(rs.getString(6));
                list.add(ir);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            DBHelper.close(rs,ps,con);
        }
        return list;
    }

    @Override
    public List<InvoicingRecord> selectIRByEidAmountMin(int enterpriseId,int amount) {
        ArrayList<InvoicingRecord> list=new ArrayList<>();
        try {
            con= DBHelper.getcon();
            String sql="SELECT ir.id,ir.create_time,bd.title,ir.amount,ir.uplink_address,ir.`status` FROM invoicing_record ir,base_data bd WHERE ir.base_data_id=bd.id AND ir.enterprise_id=? AND ir.amount>=?";
            ps=con.prepareStatement(sql);
            ps.setInt(1,enterpriseId);
            ps.setInt(2,amount);
            rs=ps.executeQuery();
            while (rs.next()){
                InvoicingRecord ir=new InvoicingRecord();
                ir.setIid(rs.getInt(1));
                ir.setCreatorTime(rs.getDate(2));
                BaseData baseData = new BaseData();
                baseData.setTitle(rs.getString(3));
                ir.setBaseData(baseData);
                ir.setAmount(rs.getDouble(4));
                ir.setUplinkAddress(rs.getString(5));
                ir.setStatus(rs.getString(6));
                list.add(ir);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            DBHelper.close(rs,ps,con);
        }
        return list;
    }

    @Override
    public List<InvoicingRecord> selectIRByEidAmountMax(int enterpriseId,int amount) {
        ArrayList<InvoicingRecord> list=new ArrayList<>();
        try {
            con= DBHelper.getcon();
            String sql="SELECT ir.id,ir.create_time,bd.title,ir.amount,ir.uplink_address,ir.`status` FROM invoicing_record ir,base_data bd WHERE ir.base_data_id=bd.id AND ir.enterprise_id=? AND ir.amount<=?";
            ps=con.prepareStatement(sql);
            ps.setInt(1,enterpriseId);
            ps.setInt(2,amount);
            rs=ps.executeQuery();
            while (rs.next()){
                InvoicingRecord ir=new InvoicingRecord();
                ir.setIid(rs.getInt(1));
                ir.setCreatorTime(rs.getDate(2));
                BaseData baseData = new BaseData();
                baseData.setTitle(rs.getString(3));
                ir.setBaseData(baseData);
                ir.setAmount(rs.getDouble(4));
                ir.setUplinkAddress(rs.getString(5));
                ir.setStatus(rs.getString(6));
                list.add(ir);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            DBHelper.close(rs,ps,con);
        }
        return list;
    }

    @Override
    public int insertIR(InvoicingRecord invoicingRecord) {
        int i=0;
        try {
            con= DBHelper.getcon();
            String sql="INSERT INTO invoicing_record(amount,enterprise_id,creator_id,create_time,category,`type`,`status`,base_data_id,address_id,email_id,uplink_address)  VALUES(?,?,?,?,?,?,?,?,?,?,?)";
            ps=con.prepareStatement(sql);
            User user=new User();
            BaseData baseData=new BaseData();
            Address address=new Address();
            Email email=new Email();
            i=um.upd(sql, invoicingRecord.getAmount(),
                    invoicingRecord.getUser().getUid(),
                    invoicingRecord.getUser().getEnterpriseId(),
                    invoicingRecord.getCreatorTime(),
                    invoicingRecord.getCategory(),
                    invoicingRecord.getType(),
                    invoicingRecord.getStatus(),
                    invoicingRecord.getBaseData().getBid(),
                    invoicingRecord.getAddress().getAid(),
                    invoicingRecord.getEmail().getEid(),
                    invoicingRecord.getUplinkAddress());
            System.out.println(i);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            DBHelper.close(null,ps,con);
        }
        return i;
    }

    @Override
    public int updateIRStatus(int iid) {
        int i=0;
        try {
            con= DBHelper.getcon();
            String sql="UPDATE invoicing_record SET `status`=\"B\" WHERE `status`=\"A\" AND id=?";
            ps=con.prepareStatement(sql);
            i=um.upd(sql,iid);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            DBHelper.close(null,ps,con);
        }
        return i;
    }

    @Override
    public InvoicingRecord selectIRByIId(int iid) {
        InvoicingRecord ir=new InvoicingRecord();
        BaseData baseData=new BaseData();
        Address address=new Address();
        Email email=new Email();
//        ArrayList<InvoicingRecord> list=new ArrayList<>();
        try {
            con=DBHelper.getcon();
            String sql="SELECT id,category,`type` from invoicing_record WHERE id=?";
            ps=con.prepareStatement(sql);
            ps.setInt(1,iid);
            rs=ps.executeQuery();
            while (rs.next()){
                ir.setIid(rs.getInt(1));
                ir.setCategory(rs.getString(2));
                ir.setType(rs.getString(3));
//                list.add(ir);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            DBHelper.close(rs,ps,con);
        }
        return ir;
    }
}
