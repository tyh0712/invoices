package com.jr.dao.impl;

import com.jr.dao.IUserDao;
import com.jr.entry.User;
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
public class UserDaoImpl implements IUserDao {
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    @Override
    public User selectUser(User user) {
        User u = null;
        try {
            String sql = "select * from user where account=? and password=?";
            con = DBHelper.getcon();
            ps = con.prepareStatement(sql);
            ps.setObject(1,user.getAccount());
            ps.setObject(2,user.getPassword());
            rs = ps.executeQuery();
            while (rs.next()){
                u = new User(rs.getInt(1),rs.getString(2),
                        rs.getInt(3),rs.getString(4),
                        rs.getString(5),rs.getString(6),
                        rs.getString(7),rs.getString(8));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            DBHelper.close(rs,ps,con);
        }
        return u;
    }
}
