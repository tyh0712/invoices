package com.jr.biz.impl;

import com.jr.biz.IAddressBiz;
import com.jr.entry.Address;

import java.util.List;

/**
 * @Auther:唐一涵
 * @Date:2022/12/1
 * @Description: com.jr.biz.impl
 * @version: 1.0
 */
public class AddressBizImpl implements IAddressBiz {

    @Override
    public Address queryDeAddByEId(int enterpriseId, String defaultStatus) {
        return null;
    }

    @Override
    public boolean modifyAddress(int aid) {
        return false;
    }

    @Override
    public boolean modifyDeAddByEId(int aid) {
        return false;
    }

    @Override
    public boolean addAddress(Address address) {
        return false;
    }

    @Override
    public List<Address> queryAddByEId(int enterpriseId) {
        return null;
    }

    @Override
    public Address queryAddByIId(int iid) {
        return null;
    }
}
