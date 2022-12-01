package com.jr.util;

import com.mysql.cj.conf.ConnectionPropertiesTransform;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * @Auther:唐一涵
 * @Date:2022/12/1
 * @Description: com.jr.util
 * @version: 1.0
 */
public class DBHelper {

    public static Connection getcon() throws IOException, SQLException, ClassNotFoundException {
        InputStream input= ConnectionPropertiesTransform.class.getClassLoader().getResourceAsStream("jdbc.properties");
        Properties properties=new Properties();
        properties.load(input);
        String url=properties.getProperty("url");
        String user=properties.getProperty("user");
        String password=properties.getProperty("password");
        String driverClass=properties.getProperty("driverClass");
        Class c=Class.forName(driverClass);
        Connection con= DriverManager.getConnection(url,user,password);
        return con;

    }

    public static void close(ResultSet rs, PreparedStatement ps, Connection con){
        if (rs!=null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (ps!=null){
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (con!=null){
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
