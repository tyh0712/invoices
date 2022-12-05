package com.jr.biz;

import com.jr.entry.Email;

import java.util.List;

/**
 * @Auther:唐一涵
 * @Date:2022/12/1
 * @Description: com.jr.biz
 * @version: 1.0
 */
public interface IEmailBiz {

    //当前企业发票抬头及地址信息
    public Email queryDeEmailByEId(int enterpriseId,String defaultStatus);

    //信息管理 实现邮箱列表的查询、修改和增加
    //查询
    //queryEmailByEId()

    //修改默认值
    public boolean modifyEmailStatus(int eid,int enterpriseId);

    //修改邮箱
    public boolean modifyEmailDetail(Email email);

    //添加
    public boolean addEmail(Email email);

    //开票
    public List<Email> queryEmailByEId(int enterpriseId);

    //根据邮箱查询主键
    //public int queryEidByDetail(String emailDetail);
    int queryEidByDetail(String emailDetail, int enterpriseId);

    //详情
    public Email queryEmailByIId(int eid);
}
