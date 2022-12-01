package com.jr.entry;

import java.util.Date;

/**
 * @Auther:唐一涵
 * @Date:2022/12/1
 * @Description: com.jr.entry
 * @version: 1.0
 */
public class InvoicingRecord {

    //属性
    private int iid;//开票记录表主键 开票记录ID
    private double amount;//发票金额
    //开票企业ID  申请人ID
    private User user;
    private Date creatorId;//申请时间
    private String category;//发票种类  A普通增值税发票  B专用增值税发票
    private String type;//发票类型  A电子发票 B纸质发票
    private String status;//处理状态  A已开票 B已作废
    private BaseData baseData;//基本信息主键
    private Address address;//邮寄地址主键
    private Email email;//电子邮箱主键
    private String uplinkAddress;//上链地址

    //有参
    public InvoicingRecord(int iid, double amount, User user, Date creatorId, String category, String type, String status, BaseData baseData, Address address, Email email, String uplinkAddress) {
        this.iid = iid;
        this.amount = amount;
        this.user = user;
        this.creatorId = creatorId;
        this.category = category;
        this.type = type;
        this.status = status;
        this.baseData = baseData;
        this.address = address;
        this.email = email;
        this.uplinkAddress = uplinkAddress;
    }

    //无参
    public InvoicingRecord() {
    }

    //toString
    @Override
    public String toString() {
        return "InvoicingRecord{" +
                "iid=" + iid +
                ", amount=" + amount +
                ", user=" + user +
                ", creatorId=" + creatorId +
                ", category='" + category + '\'' +
                ", type='" + type + '\'' +
                ", status='" + status + '\'' +
                ", baseData=" + baseData +
                ", address=" + address +
                ", email=" + email +
                ", uplinkAddress='" + uplinkAddress + '\'' +
                '}';
    }

    //get set
    public int getIid() {
        return iid;
    }

    public void setIid(int iid) {
        this.iid = iid;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(Date creatorId) {
        this.creatorId = creatorId;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public BaseData getBaseData() {
        return baseData;
    }

    public void setBaseData(BaseData baseData) {
        this.baseData = baseData;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Email getEmail() {
        return email;
    }

    public void setEmail(Email email) {
        this.email = email;
    }

    public String getUplinkAddress() {
        return uplinkAddress;
    }

    public void setUplinkAddress(String uplinkAddress) {
        this.uplinkAddress = uplinkAddress;
    }
}
