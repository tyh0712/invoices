package com.jr.biz.impl;

import com.jr.biz.IOrderBiz;
import com.jr.dao.impl.OrderDaoImpl;
import com.jr.entry.Order;
import com.jr.util.PageHelper;

import java.util.ArrayList;
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
    public List<Double> getAmount(int enterpriseId) {
        double allcount =  odi.selectTotalAmountByEId(enterpriseId);
        double usecount = odi.selectTotalAmountByEIdAndStatus(enterpriseId);
        List<Double> list = new ArrayList<>();
        double newcount = allcount-usecount;
        list.add(allcount);
        list.add(usecount);
        list.add(newcount);
        return list;
    }

    @Override
    public List<Order> invoicingOrder(int judge, int limit, PageHelper pageHelper, String invoicingStatus, Object...objs) {
        return odi.selectOrderByStatus(judge,limit,pageHelper,invoicingStatus,objs);
    }

    @Override
    public boolean refundOrder(int invoicingRecordId) {
        return odi.updateOrderStatus(invoicingRecordId)==0?false:true;
    }

    @Override
    public boolean openOrder(int oid, int invoicingRecordId) {
        return odi.updateOrderOpen(oid,invoicingRecordId)==0?false:true;
    }

    @Override
    public List<Order> detailOrder(int invoicingRecordId) {
        return odi.selectOrderByIId(invoicingRecordId);
    }
}
