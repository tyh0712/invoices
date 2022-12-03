package com.jr.biz;

import com.jr.dao.impl.UserDaoImpl;
import com.jr.entry.Order;

import java.util.List;

/**
 * @Auther:唐一涵
 * @Date:2022/12/1
 * @Description: com.jr.biz
 * @version: 1.0
 */
public interface IOrderBiz {

    //统计信息  可开票金额 = 总计可开票金额 – 历史已开票金额
    public List<Double> getAmount(int enterpriseId);

    //开票  invoicing
//    public List<Order> invoicingOrder(String invoicingStatus);
    List<Order> invoicingOrder(String invoicingStatus, Object... objs);

    //退票 实现其中开票状态的修改  refund
    public boolean refundOrder(int invoicingRecordId);

    //详情 实现发票详情页中与此发票有关的订单显示  detail
    public List<Order> detailOrder(int invoicingRecordId);
}
