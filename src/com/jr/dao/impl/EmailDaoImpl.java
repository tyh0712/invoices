package com.jr.dao.impl;

import com.jr.dao.IEmailDao;
import com.jr.entry.Email;
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
public class EmailDaoImpl implements IEmailDao {

    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    @Override
    public Email selectDefaultEmailByEId(int enterpriseId, String defaultStatus) {
        Email email = null;
        try {
            con = DBHelper.getcon();
            String sql = "select email_detail from email where enterprise_id=? and default_status=?";
            ps = con.prepareStatement(sql);
            ps.setInt(1,enterpriseId);
            ps.setString(2,defaultStatus);
            rs = ps.executeQuery();
            if (rs.next()){
                email = new Email();
                email.setEmailDetail(rs.getString("email_detail"));
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            DBHelper.close(rs,ps,con);
        }
        return email;
    }

    @Override
    public int updateDefaultEmailByEId(Email email) {
        int num = 0;
        try {
            con = DBHelper.getcon();
            String sql = "update email set default_status=? where id=? ";
            ps = con.prepareStatement(sql);
            ps.setString(1,email.getDefaultStatus());
            ps.setInt(2,email.getEid());
            if (email.getDefaultStatus().equals("B")){
                email.setDefaultStatus("A");
            }
            num = ps.executeUpdate();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            DBHelper.close(rs,ps,con);
        }
        return num;
    }

    @Override
    public int insertEmail(Email email) {
        int num = 0;
        try {
            con = DBHelper.getcon();
            String sql = "insert into email values(null,?,?,'B') ";
            ps = con.prepareStatement(sql);
            ps.setInt(1,email.getEnterpriseId());
            ps.setString(2,email.getEmailDetail());
            num = ps.executeUpdate();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            DBHelper.close(rs,ps,con);
        }
        return num;
    }

    @Override
    public List<Email> selectEmailByEId(int enterpriseId) {
        List<Email> list = new ArrayList<>();
        try {
            con = DBHelper.getcon();
            String sql = "select * from email order by default_status='A'";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                Email email = new Email();
                email.setEid(rs.getInt(1));
                email.setEnterpriseId(rs.getInt(2));
                email.setEmailDetail(rs.getString(3));
                email.setDefaultStatus(rs.getString(4));
                list.add(email);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            DBHelper.close(rs,ps,con);
        }
        return list;
    }

    @Override
    public Email selectEmailByIId(int eid) {
        Email email = null;
        try {
            con = DBHelper.getcon();
            String sql = "select email_detail from email where id=?";
            ps = con.prepareStatement(sql);
            ps.setInt(1,eid);
            rs = ps.executeQuery();
            if (rs.next()){
                email = new Email();
                email.setEmailDetail(rs.getString("email_detail"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            DBHelper.close(rs,ps,con);
        }
        return email;
    }

    public static void main(String[] args) {
        EmailDaoImpl edi = new EmailDaoImpl();
        Email email = edi.selectEmailByIId(1);
        Email email1 = edi.selectDefaultEmailByEId(1,"A");
        List<Email> list = edi.selectEmailByEId(1);
        System.out.println(email);
        System.out.println(list);
        System.out.println(email1);
    }
}
