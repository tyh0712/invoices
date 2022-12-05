package com.jr.biz.impl;

import com.jr.biz.IAddressBiz;
import com.jr.dao.impl.AddressDaoImpl;
import com.jr.entry.Address;

import java.util.List;

/**
 * @Auther:唐一涵
 * @Date:2022/12/1
 * @Description: com.jr.biz.impl
 * @version: 1.0
 */
public class AddressBizImpl implements IAddressBiz {

    AddressDaoImpl adi=new AddressDaoImpl();

    @Override
    public Address queryDeAddByEId(int enterpriseId, String defaultStatus) {

        return adi.selectDefaultAddByEId(enterpriseId,defaultStatus);

    }

    @Override
    public boolean modifyAddress(Address address) {

        int i=adi.updateAddress(address);
        if (i!=0){
            return true;
        }else {
            return false;
        }

    }

    @Override
    public boolean modifyDeAddByEId(int aid, int enterpriseId) {

        int i = adi.updateDefaultAddByEId(aid,enterpriseId);
        if (i!=0){
            return true;
        }else {
            return false;
        }

    }

    @Override
    public boolean addAddress(Address address) {

        int i = adi.insertAddress(address);
        System.out.println(i);
        if (i!=0){
            return true;
        }else {
            return false;
        }

    }

    @Override
    public List<Address> queryAddByEId(int enterpriseId) {

        return adi.selectAddByEId(enterpriseId);

    }

    @Override
    public int queryAidByAdd(String address,int enterpriseId) {

        return adi.selectAidByAddress(address,enterpriseId);

    }

    @Override
    public Address queryAddByIId(int aid) {

        return adi.selectAddByIId(aid);

    }
}
