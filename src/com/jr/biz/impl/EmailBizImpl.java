package com.jr.biz.impl;

import com.jr.biz.IEmailBiz;
import com.jr.entry.Email;

import java.util.List;

/**
 * @Auther:唐一涵
 * @Date:2022/12/1
 * @Description: com.jr.biz.impl
 * @version: 1.0
 */
public class EmailBizImpl implements IEmailBiz {


    @Override
    public Email queryDeEmailByEId(int enterpriseId, String defaultStatus) {
        return null;
    }

    @Override
    public boolean modifyEmail(int eid) {
        return false;
    }

    @Override
    public boolean addEmail(Email email) {
        return false;
    }

    @Override
    public List<Email> queryEmailByEId(int enterpriseId) {
        return null;
    }

    @Override
    public Email queryEmailByIId(int iid) {
        return null;
    }
}
