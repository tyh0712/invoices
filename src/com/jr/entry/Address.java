package com.jr.entry;

import sun.dc.pr.PRError;

/**
 * @Auther:唐一涵
 * @Date:2022/12/1
 * @Description: com.jr.entry
 * @version: 1.0
 */
public class Address {

    //属性
    private int aid;//邮寄地址表主键 邮寄地址ID
    private int enterpriseId;//企业ID
    private String addressee;//收件人
    private String phone;//联系电话
    private String area;//省市区
    private String addressDetail;//详细地址
    private String defaultStatus;//是否默认  A默认 B普通

    //有参
    public Address(int aid, int enterpriseId, String addressee, String phone, String area, String addressDetail, String defaultStatus) {
        this.aid = aid;
        this.enterpriseId = enterpriseId;
        this.addressee = addressee;
        this.phone = phone;
        this.area = area;
        this.addressDetail = addressDetail;
        this.defaultStatus = defaultStatus;
    }

    //无参
    public Address() {
    }

    //toString
    @Override
    public String toString() {
        return "Address{" +
                "aid=" + aid +
                ", enterpriseId=" + enterpriseId +
                ", addressee='" + addressee + '\'' +
                ", phone='" + phone + '\'' +
                ", area='" + area + '\'' +
                ", addressDetail='" + addressDetail + '\'' +
                ", defaultStatus='" + defaultStatus + '\'' +
                '}';
    }

    //get set
    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public int getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(int enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    public String getAddressee() {
        return addressee;
    }

    public void setAddressee(String addressee) {
        this.addressee = addressee;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getAddressDetail() {
        return addressDetail;
    }

    public void setAddressDetail(String addressDetail) {
        this.addressDetail = addressDetail;
    }

    public String getDefaultStatus() {
        return defaultStatus;
    }

    public void setDefaultStatus(String defaultStatus) {
        this.defaultStatus = defaultStatus;
    }
}
