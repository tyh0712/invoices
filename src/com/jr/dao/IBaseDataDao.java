package com.jr.dao;

import com.jr.entry.BaseData;

/**
 * @Auther:唐一涵
 * @Date:2022/12/1
 * @Description: com.jr.dao
 * @version: 1.0
 */
public interface IBaseDataDao {

    //当前企业发票抬头及地址信息  根据企业id查询全部
    //传入：int 企业ID
    //返回：BaseData对象
    public BaseData selectBDByEId(int enterpriseId);

    //信息管理  根据企业id查询全部
    //使用方法selectBDByEId()

    //根据主键修改（除去抬头和税号）
    //传入：int 发票基础信息表主键
    //返回：int 受影响行数
    public int updateBD(int bid);

    //根据主键（来自开表记录表）查询全部
    //使用方法selectBDByEId()
}
