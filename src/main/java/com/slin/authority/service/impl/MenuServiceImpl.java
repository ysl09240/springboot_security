package com.slin.authority.service.impl;

import com.slin.authority.dao.MenuMapper;
import com.slin.authority.dao.RoleMapper;
import com.slin.authority.model.MenuBean;
import com.slin.authority.model.RoleBean;
import com.slin.authority.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.management.relation.Role;
import java.util.List;

/**
 * Description
 */
@Service("menuService")
public class MenuServiceImpl implements MenuService {

    @Autowired
    MenuMapper menuMapper;

    @Autowired
    RoleMapper roleMapper;
    @Override
    public List<MenuBean> getAllMenu() {
        List<MenuBean> menuBeans = menuMapper.getAllMenu();
        for(MenuBean menuBean : menuBeans){
            List<RoleBean> roleBeans = roleMapper.getRoleByMenuId(menuBean.getMenuId());
            if(!CollectionUtils.isEmpty(roleBeans)){
                menuBean.setRoles(roleBeans);
            }
        }
        return menuBeans;
    }
}
