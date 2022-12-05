package com.jr.dao.impl;

import com.jr.dao.IAddressDao;
import com.jr.entry.Address;
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
public class AddressDaoImpl implements IAddressDao {

    UniversalMethod um=new UniversalMethod();

    @Override
    public Address selectDefaultAddByEId(int enterpriseId, String defaultStatus) {
        Connection con=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        Address address=null;
        try {
            con=DBHelper.getcon();
            String sql="SELECT area,address_detail FROM address WHERE enterprise_id=? AND default_status=?";
            ps=con.prepareStatement(sql);
            ps.setInt(1,enterpriseId);
            ps.setString(2,defaultStatus);
            rs=ps.executeQuery();
            if (rs.next()){
                address=new Address();
                address.setArea(rs.getString(1));
                address.setAddressDetail(rs.getString(2));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return address;
    }

    @Override
    public int updateAddress(Address address) {

        String sql="UPDATE address SET addressee=?,phone=?,area=?,address_detail=? WHERE id=?";
        int i=um.upd(sql,address.getAddressee(),address.getPhone(),address.getArea(),address.getAddressDetail(),address.getAid());
        return i;
    }

    @Override
    public int updateDefaultAddByEId(int aid, int enterpriseId) {

        List<Address> l=selectAddByEId(enterpriseId);
        String sql2="UPDATE address SET default_status='B' WHERE id=?";
        int i2=um.upd(sql2,l.get(0).getAid());
        String sql1="UPDATE address SET default_status='A' WHERE id=?";
        int i1=um.upd(sql1,aid);
        int i3=0;
        if (i1!=0 && i2!=0){
            i3=1;
        }
        return i3;
    }

    @Override
    public int insertAddress(Address address) {
        String sql="INSERT INTO address () VALUES (null,?,?,?,?,?,'B')";
        int i=um.upd(sql,address.getEnterpriseId(),address.getAddressee(),address.getPhone(),address.getArea(),address.getAddressDetail());
        System.out.println(i);
        return i;
    }

    @Override
    public List<Address> selectAddByEId(int enterpriseId) {
        Connection con=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        Address address=null;
        List<Address> list=new ArrayList<Address>();

        try {
            con=DBHelper.getcon();
            String sql="SELECT * FROM address WHERE enterprise_id=? ORDER BY default_status";
            ps=con.prepareStatement(sql);
            ps.setInt(1,enterpriseId);
            rs=ps.executeQuery();
            while (rs.next()){
                address=new Address();
                address.setAid(rs.getInt(1));
                address.setEnterpriseId(rs.getInt(2));
                address.setAddressee(rs.getString(3));
                address.setPhone(rs.getString(4));
                address.setArea(rs.getString(5));
                address.setAddressDetail(rs.getString(6));
                address.setDefaultStatus(rs.getString(7));
                list.add(address);
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
    public int selectAidByAddress(String address) {
        Connection con=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        int aid=0;
        try {
            con=DBHelper.getcon();
            String sql="SELECT id FROM address WHERE address_detail LIKE \"%\"?\"%\"";
            ps=con.prepareStatement(sql);
            address=address.substring(address.length()-5);
            ps.setString(1,address);
            rs=ps.executeQuery();
            while (rs.next()){
                aid=rs.getInt(1);
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
        return aid;
    }

    @Override
    public Address selectAddByIId(int aid) {
        Connection con=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        Address address=null;
        try {
            con=DBHelper.getcon();
            String sql="SELECT area,address_detail FROM address WHERE id=?";
            ps=con.prepareStatement(sql);
            ps.setInt(1,aid);
            rs=ps.executeQuery();
            if (rs.next()){
                address=new Address();
                address.setArea(rs.getString(1));
                address.setAddressDetail(rs.getString(2));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            DBHelper.close(rs,ps,con);
        }return address;
    }
}
