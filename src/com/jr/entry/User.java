package com.jr.entry;

import sun.applet.AppletResourceLoader;

/**
 * @Auther:唐一涵
 * @Date:2022/12/1
 * @Description: com.jr.entry
 * @version: 1.0
 */
public class User {

    //属性
    private int uid;//用户表主键 用户ID
    private String name;//用户名
    private int enterpriseId;//企业ID
    private String phone;//手机号
    private String account;//账号
    private String password;//密码
    private String idcardName;//身份证姓名
    private String idcardNo;//身份证号码

    //有参
    public User(int uid, String name, int enterpriseId, String phone, String account, String password, String idcardName, String idcardNo) {
        this.uid = uid;
        this.name = name;
        this.enterpriseId = enterpriseId;
        this.phone = phone;
        this.account = account;
        this.password = password;
        this.idcardName = idcardName;
        this.idcardNo = idcardNo;
    }

    //无参
    public User() {
    }

    //toString
    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", name='" + name + '\'' +
                ", enterpriseId='" + enterpriseId + '\'' +
                ", phone='" + phone + '\'' +
                ", account='" + account + '\'' +
                ", password='" + password + '\'' +
                ", idcardName='" + idcardName + '\'' +
                ", idcardNo='" + idcardNo + '\'' +
                '}';
    }

    //get set
    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(int enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIdcardName() {
        return idcardName;
    }

    public void setIdcardName(String idcardName) {
        this.idcardName = idcardName;
    }

    public String getIdcardNo() {
        return idcardNo;
    }

    public void setIdcardNo(String idcardNo) {
        this.idcardNo = idcardNo;
    }
}
