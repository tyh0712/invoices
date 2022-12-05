package com.jr.dao;

import com.jr.entry.Order;
import com.jr.util.PageHelper;

import java.util.List;
import java.util.Map;

/**
 * @Auther:唐一涵
 * @Date:2022/12/1
 * @Description: com.jr.dao
 * @version: 1.0
 */
public interface IOrderDao {

    //根据企业id查询订单总金额之和
    //传入：int 企业ID
    //返回：double 订单总金额之和
    public double selectTotalAmountByEId(int enterpriseId);

    //根据企业id根据开票状态（已开票）查询订单总金额之和
    //传入：int 企业ID  /  String 开票状态/-已开票
    //返回：double 历史已开票订单总金额之和
    public double selectTotalAmountByEIdAndStatus(int enterpriseId);

    //根据状态（未开票）查询全部
    //传入：String 开票状态
    //返回：List<Order> 没开票的订单集合
//    public List<Order> selectOrderByStatus(String invoicingStatus);
//    List<Order> selectOrderByStatus(String invoicingStatus, Object... objs);
//    List<Order> selectOrderByStatus(int judge, String invoicingStatus, Object... objs);
    List<Order> selectOrderByStatus(int judge, int limit, PageHelper pageHelper, String invoicingStatus, Object... objs);

    String getSql(int judge, Object... objs);

    Map<Integer, Object> getObj(int judge, Object... objs);

    //根据开票记录表主键修改开票状态为（未开票）--退票
    //传入：int 开票记录表主键
    //返回：int 受影响行数
    public int updateOrderStatus(int invoicingRecordId);

    //开票--传入选择的订单的oid--进行修改---订单状态 B-》A
    //并且添加相关开票表主键
    public int updateOrderOpen(int oid,int invoicingRecordId);

    //根据开票记录表主键查询全部
    //传入：int 开票记录表主键
    //返回：List<Order> 与此发票有关的订单显示
    public List<Order> selectOrderByIId(int invoicingRecordId);
}
