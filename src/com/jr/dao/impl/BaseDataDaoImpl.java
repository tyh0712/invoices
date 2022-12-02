package com.jr.dao.impl;

import com.jr.dao.IBaseDataDao;
import com.jr.entry.BaseData;
import com.jr.util.DBHelper;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @Auther:唐一涵
 * @Date:2022/12/1
 * @Description: com.jr.dao.impl
 * @version: 1.0
 */
public class BaseDataDaoImpl implements IBaseDataDao {
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    @Override
    public BaseData selectBDByEId(int enterpriseId) {
        BaseData baseData = null;
        try {
            con = DBHelper.getcon();
            String sql = "select * from base_data where enterprise_id=?";
            ps = con.prepareStatement(sql);
            ps.setObject(1,enterpriseId);
            rs = ps.executeQuery();
            while (rs.next()){
                baseData = new BaseData(rs.getInt(1),rs.getInt(2),
                        rs.getString(3),rs.getString(4),
                        rs.getString(5),rs.getString(6),
                        rs.getString(7),rs.getString(8));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return baseData;
    }

    @Override
    public int updateBD(BaseData baseData) {
        UniversalMethod um = new UniversalMethod();
        String sql = "update base_data set bank_name=?,bank_account=?,phone=?,address=? where id=?";
        int i = um.upd(sql,baseData.getBankName(),baseData.getBankAccount(),baseData.getPhone(),baseData.getAddress(),baseData.getBid());
        return i;
    }
}
