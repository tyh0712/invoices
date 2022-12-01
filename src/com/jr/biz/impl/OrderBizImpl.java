package com.jr.biz.impl;

import com.jr.biz.IOrderBiz;
import com.jr.entry.Order;

import java.util.List;

/**
 * @Auther:唐一涵
 * @Date:2022/12/1
 * @Description: com.jr.biz.impl
 * @version: 1.0
 */
public class OrderBizImpl implements IOrderBiz {

    @Override
    public double getAmount(int enterpriseId, String invoicingStatus) {
        return 0;
    }

    @Override
    public List<Order> invoicingOrder(String invoicingStatus) {
        return null;
    }

    @Override
    public boolean refundOrder(int invoicingRecordId) {
        return false;
    }

    @Override
    public List<Order> detailOrder(int invoicingRecordId) {
        return null;
    }
}
