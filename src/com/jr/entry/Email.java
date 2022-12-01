package com.jr.entry;

/**
 * @Auther:唐一涵
 * @Date:2022/12/1
 * @Description: com.jr.entry
 * @version: 1.0
 */
public class Email {

    //属性
    private int eid;//电子邮箱表主键
    private int enterpriseId;//企业ID
    private String emailDetail;//电子邮箱
    private String defaultStatus;//是否默认  A默认 B普通

    //有参
    public Email(int eid, int enterpriseId, String emailDetail, String defaultStatus) {
        this.eid = eid;
        this.enterpriseId = enterpriseId;
        this.emailDetail = emailDetail;
        this.defaultStatus = defaultStatus;
    }

    //无参
    public Email() {
    }

    //toString
    @Override
    public String toString() {
        return "Email{" +
                "eid=" + eid +
                ", enterpriseId=" + enterpriseId +
                ", emailDetail='" + emailDetail + '\'' +
                ", defaultStatus='" + defaultStatus + '\'' +
                '}';
    }

    //get set
    public int getEid() {
        return eid;
    }

    public void setEid(int eid) {
        this.eid = eid;
    }

    public int getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(int enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    public String getEmailDetail() {
        return emailDetail;
    }

    public void setEmailDetail(String emailDetail) {
        this.emailDetail = emailDetail;
    }

    public String getDefaultStatus() {
        return defaultStatus;
    }

    public void setDefaultStatus(String defaultStatus) {
        this.defaultStatus = defaultStatus;
    }
}
