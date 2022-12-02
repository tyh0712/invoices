package com.jr.dao;

import com.jr.entry.Email;

import java.util.List;

/**
 * @Auther:唐一涵
 * @Date:2022/12/1
 * @Description: com.jr.dao
 * @version: 1.0
 */
public interface IEmailDao {

    //根据企业id和是否默认查询电子邮件
    //传入：int 企业ID / String 是否默认
    //返回：Email对象
    public Email selectDefaultEmailByEId(int enterpriseId,String defaultStatus);

    //根据企业id查询全部
    //使用selectEmailByEId()方法

    //根据主键修改是否为默认电子邮件（默认，并修改原默认为非默认）
    //传入：int 电子邮件表主键
    //返回：int 受影响行数
    public int updateDefaultEmailByEId(int eid, int enterpriseId);

    //根据主键修改电子邮件
    //传入：int 电子邮件表主键
    //返回：int 受影响行数
    public int updateDefaultEmailDetailByEId(Email email);

    //添加
    //传入：Email对象
    //返回：int 受影响行数
    public int insertEmail(Email email);

    //根据企业id查询 通过是否为默认排序（默认排在最前）
    //传入：int 企业ID
    //返回：List<Email> 与企业ID有关的邮箱的展示，加个默认的排序
    public List<Email> selectEmailByEId(int enterpriseId);

    //根据主键查询电子邮箱
    //传入：int 电子邮件表主键
    //返回：Email对象
    public Email selectEmailByIId(int eid);
}
