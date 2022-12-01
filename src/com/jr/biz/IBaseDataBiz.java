package com.jr.biz;

import com.jr.entry.BaseData;

/**
 * @Auther:唐一涵
 * @Date:2022/12/1
 * @Description: com.jr.biz
 * @version: 1.0
 */
public interface IBaseDataBiz {

    //当前企业发票抬头及地址信息
    public BaseData queryBDByEId(int enterpriseId);

    //信息管理
    //查询
    //使用queryBDByEId()

    //修改
    public boolean modify(int bid);

    //详情
    //使用queryBDByEId()
}
