package com.jr.biz;

import com.jr.entry.Address;

import java.util.List;

/**
 * @Auther:唐一涵
 * @Date:2022/12/1
 * @Description: com.jr.biz
 * @version: 1.0
 */
public interface IAddressBiz {

    //当前企业发票抬头及地址信息
    public Address queryDeAddByEId(int enterpriseId, String defaultStatus);

    //信息管理
    //查询
    //使用queryAddByEId()

    //修改
    boolean modifyAddress(Address address);

    //修改默认地址
    boolean modifyDeAddByEId(int aid, int enterpriseId);

    //添加
    public boolean addAddress(Address address);

    //开票 实现开票时默认地址默认显示 点击选择查看其它地址
    public List<Address> queryAddByEId(int enterpriseId);

    //详情 查看该发票使用的地址
    public Address queryAddByIId(int aid);

    //根据地址查询主键
    int queryAidByAdd(String address);
}
