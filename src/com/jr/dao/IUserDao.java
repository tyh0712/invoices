package com.jr.dao;

import com.jr.entry.User;

import java.util.List;

/**
 * @Auther:唐一涵
 * @Date:2022/12/1
 * @Description: com.jr.dao
 * @version: 1.0
 */
public interface IUserDao {

    //根据account 和 password查询
    //传入：User对象 有account 和 password
    //返回：User对象 全部信息
    public User selectUser(User user);
}
