package com.jr.dao;

import com.jr.entry.Address;

import java.util.List;

/**
 * @Auther:唐一涵
 * @Date:2022/12/1
 * @Description: com.jr.dao
 * @version: 1.0
 */
public interface IAddressDao {

    //根据企业id和是否默认查询邮寄地址
    //传入：int 企业ID / String 是否默认
    //返回：Address对象
    public Address selectDefaultAddByEId(int enterpriseId, String defaultStatus);

    //根据企业id查询全部
    //使用selectAddByEId()方法

    //根据主键修改
    //传入：Address 邮寄地址表
    //返回：int 受影响行数
    int updateAddress(Address address);

    //根据主键修改是否为默认邮寄地址（默认，并修改原默认为非默认）
    //传入：int 邮寄地址表主键
    //返回：int 受影响行数
    int updateDefaultAddByEId(int aid, int enterpriseId);

    //添加
    //传入：Address对象
    //返回：int 受影响行数
    public int insertAddress(Address address);

    //根据企业id查询 通过是否为默认排序（默认排在最前）
    //传入：int 企业ID
    //返回：List<Address> 与企业ID有关的邮箱的展示，加个默认的排序
    public List<Address> selectAddByEId(int enterpriseId);

    //根据主键（开票记录表）查询邮寄地址
    //传入：int 开票记录表主键
    //返回：Address对象
    public Address selectAddByIId(int iid);
}
