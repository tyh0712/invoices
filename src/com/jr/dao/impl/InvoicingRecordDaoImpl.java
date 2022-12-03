package com.jr.dao.impl;

import com.jr.dao.IInvoicingRecordDao;
import com.jr.entry.*;
import com.jr.util.DBHelper;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
            String sql="SELECT ir.create_time,bd.title,ir.amount,ir.uplink_address,ir.`status` FROM invoicing_record ir,base_data bd WHERE ir.base_data_id=bd.id AND ir.enterprise_id=?";
            ps=con.prepareStatement(sql);
            ps.setInt(1,enterpriseId);
            rs=ps.executeQuery();
            while (rs.next()){
                InvoicingRecord ir=new InvoicingRecord();
                ir.setCreatorTime(rs.getDate(1));
                BaseData baseData = new BaseData();
                baseData.setTitle(rs.getString(2));
                ir.setBaseData(baseData);
                ir.setAmount(rs.getDouble(3));
                ir.setUplinkAddress(rs.getString(4));
                ir.setStatus(rs.getString(5));
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
            String sql="INSERT INTO invoicing_record VALUES(null,?,?,?,?,?,?,?,?,?,?,?)";
            ps=con.prepareStatement(sql);
            User user=new User();
            BaseData baseData=new BaseData();
            Address address=new Address();
            Email email=new Email();
            i=um.upd(sql,invoicingRecord.getIid(),invoicingRecord.getAmount(),
                    user.getUid(),user.getEnterpriseId(),
                    invoicingRecord.getCreatorTime(),invoicingRecord.getCategory(),invoicingRecord.getType(),
                    invoicingRecord.getStatus(),baseData.getBid(),address.getAid(),
                    email.getEid(),invoicingRecord.getUplinkAddress());
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
    public List<InvoicingRecord> selectIRByIId(int iid) {
        InvoicingRecord ir=new InvoicingRecord();
        User user=new User();
        BaseData baseData=new BaseData();
        Address address=new Address();
        Email email=new Email();
        ArrayList<InvoicingRecord> list=new ArrayList<>();
        try {
            con=DBHelper.getcon();
            String sql="SELECT * from invoicing_record WHERE id=?";
            ps=con.prepareStatement(sql);
            ps.setInt(1,iid);
            rs=ps.executeQuery();
            while (rs.next()){
                ir.setIid(rs.getInt(1));
                ir.setAmount(rs.getDouble(2));
                user.setUid(rs.getInt(3));
                user.setEnterpriseId(rs.getInt(4));
                ir.setUser(user);
                ir.setCreatorTime(rs.getDate(5));
                ir.setCategory(rs.getString(6));
                ir.setType(rs.getString(7));
                ir.setStatus(rs.getString(8));
                baseData.setBid(rs.getInt(9));
                ir.setBaseData(baseData);
                address.setAid(rs.getInt(10));
                ir.setAddress(address);
                email.setEid(rs.getInt(11));
                ir.setEmail(email);
                ir.setUplinkAddress(rs.getString(12));
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
}
