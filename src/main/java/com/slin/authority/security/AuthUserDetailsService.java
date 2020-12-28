package com.slin.authority.security;

import com.slin.authority.model.RoleBean;
import com.slin.authority.model.UserBean;
import com.slin.authority.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
/**
 * @author yangsonglin
 * @create 2018-11-14 15:14
 **/
@Component
public class AuthUserDetailsService implements UserDetailsService {

    @Autowired
    UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserBean userBean = userService.getByUsername(username);
        if (userBean == null){
            throw new UsernameNotFoundException("用户不存在！");
        }
        List<RoleBean> roleBeanList = userService.getRoleByUserId(userBean.getId());
        userBean.setRoles(roleBeanList);
        List<SimpleGrantedAuthority> simpleGrantedAuthorities = createAuthorities(roleBeanList);
        return new User(userBean.getName(), userBean.getPassword(), simpleGrantedAuthorities);
    }

    /**
     * 权限字符串转化
     *
     * 如 "USER,ADMIN" -> SimpleGrantedAuthority("USER") + SimpleGrantedAuthority("ADMIN")
     *
     * @param roles 权限字符串
     */
    private List<SimpleGrantedAuthority> createAuthorities(List<RoleBean> roles){

        List<SimpleGrantedAuthority> simpleGrantedAuthorities = new ArrayList<>();
        for (RoleBean role : roles) {
            simpleGrantedAuthorities.add(new SimpleGrantedAuthority(role.getRoleEnName()));
        }
        return simpleGrantedAuthorities;
    }

}