package com.slin.authority.service.impl;

import com.slin.authority.dao.UserMapper;
import com.slin.authority.model.RoleBean;
import com.slin.authority.model.UserBean;
import com.slin.authority.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * user实现接口类
 *
 * @author yangsonglin
 * @create 2018-11-13 10:19
 **/
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;
    @Override
    public List<UserBean> findUserList() {
        return userMapper.findUserList();
    }

    @Override
    public UserBean getByUsername(String username) {
        return userMapper.getByUsername(username);
    }

    @Override
    public List<RoleBean> getRoleByUserId(long userId) {
        return userMapper.getRoleByUserId(userId);
    }
}
