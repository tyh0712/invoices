package com.jr.dao.impl;

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
public class UniversalMethod {
    Connection con;
    PreparedStatement ps;
    ResultSet rs;


    public int upd(String sql, Object... objs) {
        int num = 0;
        try {
            con = DBHelper.getcon();
            ps = con.prepareStatement(sql);
            for (int i=0;i<objs.length;i++){
                ps.setObject(i+1,objs[i]);
            }
            num = ps.executeUpdate();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBHelper.close(null,ps,con);
        }
        return num;
    }


}

