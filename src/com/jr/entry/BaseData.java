package com.jr.entry;

/**
 * @Auther:唐一涵
 * @Date:2022/12/1
 * @Description: com.jr.entry
 * @version: 1.0
 */
public class BaseData {

    //属性
    private int bid;//发票基础信息表主键 发票记录ID
    private int enterpriseId;//企业ID
    private String title;//抬头
    private String taxNo;//税号
    private String bankName;//开户银行
    private String bankAccount;//开户账号
    private String phone;//注册固定电话
    private String address;//注册场所地址

    //有参
    public BaseData(int bid, int enterpriseId, String title, String taxNo, String bankName, String bankAccount, String phone, String address) {
        this.bid = bid;
        this.enterpriseId = enterpriseId;
        this.title = title;
        this.taxNo = taxNo;
        this.bankName = bankName;
        this.bankAccount = bankAccount;
        this.phone = phone;
        this.address = address;
    }

    //无参
    public BaseData() {
    }

    //toString
    @Override
    public String toString() {
        return "BaseData{" +
                "bid=" + bid +
                ", enterpriseId=" + enterpriseId +
                ", title='" + title + '\'' +
                ", taxNo='" + taxNo + '\'' +
                ", bankName='" + bankName + '\'' +
                ", bankAccount='" + bankAccount + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    //get set
    public int getBid() {
        return bid;
    }

    public void setBid(int bid) {
        this.bid = bid;
    }

    public int getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(int enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTaxNo() {
        return taxNo;
    }

    public void setTaxNo(String taxNo) {
        this.taxNo = taxNo;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
