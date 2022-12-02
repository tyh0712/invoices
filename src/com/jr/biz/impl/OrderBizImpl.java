package com.jr.biz.impl;

import com.jr.biz.IOrderBiz;
import com.jr.dao.impl.OrderDaoImpl;
import com.jr.entry.Order;

import java.util.List;

/**
 * @Auther:唐一涵
 * @Date:2022/12/1
 * @Description: com.jr.biz.impl
 * @version: 1.0
 */
public class OrderBizImpl implements IOrderBiz {
    OrderDaoImpl odi = new OrderDaoImpl();

    @Override
    public double getAmount(int enterpriseId, String invoicingStatus) {
        double allcount =  odi.selectTotalAmountByEId(enterpriseId);
        double usecount = odi.selectTotalAmountByEIdAndStatus(enterpriseId,invoicingStatus);
        return (allcount - usecount);
    }

    @Override
    public List<Order> invoicingOrder(String invoicingStatus,Object...objs) {
        return odi.selectOrderByStatus(invoicingStatus,objs);
    }

    @Override
    public boolean refundOrder(int invoicingRecordId) {
        return odi.updateOrderStatus(invoicingRecordId)==1?true:false;
    }

    @Override
    public List<Order> detailOrder(int invoicingRecordId) {
        return odi.selectOrderByIId(invoicingRecordId);
    }
}
