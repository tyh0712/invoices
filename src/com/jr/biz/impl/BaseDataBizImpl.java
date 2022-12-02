package com.jr.biz.impl;

import com.jr.biz.IBaseDataBiz;
import com.jr.dao.impl.BaseDataDaoImpl;
import com.jr.entry.BaseData;

/**
 * @Auther:唐一涵
 * @Date:2022/12/1
 * @Description: com.jr.biz.impl
 * @version: 1.0
 */
public class BaseDataBizImpl implements IBaseDataBiz {
    BaseDataDaoImpl bdi = new BaseDataDaoImpl();

    @Override
    public BaseData queryBDByEId(int enterpriseId) {
        return bdi.selectBDByEId(enterpriseId);
    }

    @Override
    public boolean modify(BaseData baseData) {
        return bdi.updateBD(baseData)==1?true:false;
    }
}
