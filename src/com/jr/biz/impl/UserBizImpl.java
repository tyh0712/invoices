package com.jr.biz.impl;

import com.jr.biz.IUserBiz;
import com.jr.dao.impl.UserDaoImpl;
import com.jr.entry.User;

/**
 * @Auther:唐一涵
 * @Date:2022/12/1
 * @Description: com.jr.biz.impl
 * @version: 1.0
 */
public class UserBizImpl implements IUserBiz {
    UserDaoImpl udi = new UserDaoImpl();

    @Override
    public User login(User user) {
        return udi.selectUser(user);
    }
}
