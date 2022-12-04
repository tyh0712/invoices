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
            String sql = "select email_detail from email where enterprise_id=? and default_status=? ";
            ps = con.prepareStatement(sql);
            ps.setInt(1,enterpriseId);
            ps.setString(2,defaultStatus);
            System.out.println(enterpriseId+"=======");
            System.out.println(defaultStatus+"------");
            rs = ps.executeQuery();

            if (rs.next()){
                email = new Email();
                email.setEmailDetail(rs.getString(1));
                System.out.println(rs.getString(1)+"77777=-=-=-=");
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
    public int updateDefaultEmailByEId(int eid, int enterpriseId) {
        UniversalMethod um=new UniversalMethod();

        List<Email> list=selectEmailByEId(enterpriseId);
        String sql2="UPDATE email SET default_status='B' WHERE id=?";
        int i2=um.upd(sql2,list.get(0).getEid());
        String sql1="UPDATE email SET default_status='A' WHERE id=?";
        int i1=um.upd(sql1,eid);
        int i3=0;
        if (i1!=0 && i2!=0){
            i3=1;
        }
        return i3;
    }

    public int updateDefaultEmailDetailByEId(Email email) {
        int num = 0;
        try {
            con = DBHelper.getcon();
            String sql = "update email set  email_detail=? where id=? ";
            ps = con.prepareStatement(sql);
            ps.setString(1,email.getEmailDetail());
            ps.setInt(2,email.getEid());
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
        Email email;
        try {
            con = DBHelper.getcon();
            String sql = "select * from email where enterprise_id=? order by default_status";
            ps = con.prepareStatement(sql);
            ps.setInt(1,enterpriseId);
            rs = ps.executeQuery();
            while (rs.next()){
                email=new Email();
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
}
