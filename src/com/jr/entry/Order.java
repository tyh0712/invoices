package com.jr.entry;

import java.util.Date;

/**
 * @Auther:唐一涵
 * @Date:2022/12/1
 * @Description: com.jr.entry
 * @version: 1.0
 */
public class Order {

    //属性
    private int oid;//订单表主键 订单ID
    private String no;//订单编号
    private double totalAmount;//订单总金额
    private int enterpriseId;//企业ID
    private String enterpriseName;//相关企业名称
    //开票状态  开票记录表主键
    //开票状态  A已开票  B未开票
    private InvoicingRecord invoicingRecord;
    private Date createTime;//创建时间

    //有参
    public Order(int oid, String no, Double totalAmount, int enterpriseId, String enterpriseName, InvoicingRecord invoicingRecord) {
        this.oid = oid;
        this.no = no;
        this.totalAmount = totalAmount;
        this.enterpriseId = enterpriseId;
        this.enterpriseName = enterpriseName;
        this.invoicingRecord = invoicingRecord;
    }

    //无参
    public Order() {
    }

    //toString
    @Override
    public String toString() {
        return "Order{" +
                "oid=" + oid +
                ", no='" + no + '\'' +
                ", totalAmount=" + totalAmount +
                ", enterpriseId=" + enterpriseId +
                ", enterpriseName='" + enterpriseName + '\'' +
                ", invoicingRecord=" + invoicingRecord +
                ", createTime=" + createTime +
                '}';
    }

    //get set
    public int getOid() {
        return oid;
    }

    public void setOid(int oid) {
        this.oid = oid;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public int getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(int enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    public String getEnterpriseName() {
        return enterpriseName;
    }

    public void setEnterpriseName(String enterpriseName) {
        this.enterpriseName = enterpriseName;
    }

    public InvoicingRecord getInvoicingRecord() {
        return invoicingRecord;
    }

    public void setInvoicingRecord(InvoicingRecord invoicingRecord) {
        this.invoicingRecord = invoicingRecord;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
