package com.jr.dao.impl;

import com.jr.biz.IEmailBiz;
import com.jr.dao.IEmailDao;
import com.jr.entry.Email;

import java.util.List;

/**
 * @Auther:唐一涵
 * @Date:2022/12/1
 * @Description: com.jr.dao.impl
 * @version: 1.0
 */
public class EmailDaoImpl implements IEmailDao {

    @Override
    public Email selectDefaultEmailByEId(int enterpriseId, String defaultStatus) {
        return null;
    }

    @Override
    public int updateDefaultEmailByEId(int eid) {
        return 0;
    }

    @Override
    public int insertEmail(Email email) {
        return 0;
    }

    @Override
    public List<Email> selectEmailByEId(int enterpriseId) {
        return null;
    }

    @Override
    public Email selectEmailByIId(int iid) {
        return null;
    }
}
