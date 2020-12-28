package com.slin.authority.service;

import com.slin.authority.model.RoleBean;
import com.slin.authority.model.UserBean;

import java.util.List;

public interface UserService {


    List<UserBean> findUserList();


    UserBean getByUsername(String username);

    List<RoleBean> getRoleByUserId(long userId);
}
