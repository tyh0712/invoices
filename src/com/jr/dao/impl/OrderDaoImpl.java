package com.jr.dao.impl;

import com.jr.dao.IOrderDao;
import com.jr.entry.Order;

import java.util.List;

/**
 * @Auther:唐一涵
 * @Date:2022/12/1
 * @Description: com.jr.dao.impl
 * @version: 1.0
 */
public class OrderDaoImpl implements IOrderDao {

    @Override
    public double selectTotalAmountByEId(int enterpriseId) {
        return 0;
    }

    @Override
    public double selectTotalAmountByEIdAndStatus(int enterpriseId, String invoicingStatus) {
        return 0;
    }

    @Override
    public List<Order> selectOrderByStatus(String invoicingStatus) {
        return null;
    }

    @Override
    public int updateOrderStatus(int invoicingRecordId) {
        return 0;
    }

    @Override
    public List<Order> selectOrderByIId(int invoicingRecordId) {
        return null;
    }
}
