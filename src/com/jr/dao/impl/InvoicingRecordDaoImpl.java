package com.jr.dao.impl;

import com.jr.dao.IInvoicingRecordDao;
import com.jr.entry.InvoicingRecord;
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
    @Override
    public List<InvoicingRecord> selectIRByEId(int enterpriseId) {
        ArrayList<InvoicingRecord> list=new ArrayList<>();
        try {
            con= DBHelper.getcon();
            String sql="SELECT ir.create_time,bd.title,ir.amount,ir.uplink_address,ir.`status` FROM invoicing_record ir,base_data bd WHERE ir.base_data_id=bd.id;";
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            if (rs.next()){
                InvoicingRecord ir=new InvoicingRecord();

                rs.getString(2);
                rs.getInt(3);
                rs.getString(4);
                rs.getString(5);
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


        return null;
    }

    @Override
    public int insertIR(InvoicingRecord invoicingRecord) {
        return 0;
    }

    @Override
    public int updateIRStatus(int iid) {
        return 0;
    }

    @Override
    public InvoicingRecord selectIRByIId(int iid) {
        return null;
    }
}
