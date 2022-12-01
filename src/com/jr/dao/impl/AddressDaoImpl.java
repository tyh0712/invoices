package com.jr.dao.impl;

import com.jr.dao.IAddressDao;
import com.jr.entry.Address;

import java.util.List;

/**
 * @Auther:唐一涵
 * @Date:2022/12/1
 * @Description: com.jr.dao.impl
 * @version: 1.0
 */
public class AddressDaoImpl implements IAddressDao {

    @Override
    public Address selectDefaultAddByEId(int enterpriseId, String defaultStatus) {
        return null;
    }

    @Override
    public int updateAddress(int aid) {
        return 0;
    }

    @Override
    public int updateDefaultAddByEId(int aid) {
        return 0;
    }

    @Override
    public int insertAddress(Address address) {
        return 0;
    }

    @Override
    public List<Address> selectAddByEId(int enterpriseId) {
        return null;
    }

    @Override
    public Address selectAddByIId(int iid) {
        return null;
    }
}
