package com.jr.biz.impl;

import com.jr.biz.IEmailBiz;
import com.jr.dao.impl.EmailDaoImpl;
import com.jr.entry.Email;

import java.util.List;

/**
 * @Auther:唐一涵
 * @Date:2022/12/1
 * @Description: com.jr.biz.impl
 * @version: 1.0
 */
public class EmailBizImpl implements IEmailBiz {
    EmailDaoImpl edi = new EmailDaoImpl();

    @Override
    public Email queryDeEmailByEId(int enterpriseId, String defaultStatus) {
        return edi.selectDefaultEmailByEId(enterpriseId,defaultStatus);
    }

    @Override
    public boolean modifyEmail(Email email) {
        return edi.updateDefaultEmailByEId(email)==0?false:true;
    }


    @Override
    public boolean addEmail(Email email) {
        return edi.insertEmail(email)==0?false:true;
    }

    @Override
    public List<Email> queryEmailByEId(int enterpriseId) {
        return edi.selectEmailByEId(enterpriseId);
    }

    @Override
    public Email queryEmailByIId(int iid) {
        return edi.selectEmailByIId(iid);
    }
}
