package com.jr.biz;

import com.jr.dao.impl.UserDaoImpl;
import com.jr.entry.User;

/**
 * @Auther:唐一涵
 * @Date:2022/12/1
 * @Description: com.jr.biz
 * @version: 1.0
 */
public interface IUserBiz {

    //实现登录和关联功能所需企业id的获取
    public User login(User user);
}
