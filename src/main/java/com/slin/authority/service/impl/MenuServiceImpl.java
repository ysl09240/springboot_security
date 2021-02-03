package com.slin.authority.service.impl;

import com.slin.authority.dao.MenuMapper;
import com.slin.authority.dao.RoleMapper;
import com.slin.authority.model.MenuBean;
import com.slin.authority.model.RoleBean;
import com.slin.authority.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
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

    @Override
    public List<MenuBean> getMenuTree() {
        List<MenuBean> allMenus = menuMapper.getAllMenu();
        List<MenuBean> rootMenus = new ArrayList<>();
        for(MenuBean menuBean : allMenus){
            String pid = String.valueOf(menuBean.getPid());
            if(pid.equals("0")){
                rootMenus.add(menuBean);
            }
        }
        for (MenuBean rootMenu:rootMenus){
            String id = String.valueOf(rootMenu.getMenuId());
            List<MenuBean> childMenus = getChildMenus(id,allMenus);
            rootMenu.setChildList(childMenus);
        }
        return rootMenus;
    }

    private List<MenuBean> getChildMenus(String id, List<MenuBean> allMenus) {
        List<MenuBean> childMenus = new ArrayList<>();
        for(MenuBean menuBean:allMenus){
            String pid = String.valueOf(menuBean.getPid());
            if(id.equals(pid)){
                childMenus.add(menuBean);
            }
        }
        if(!CollectionUtils.isEmpty(childMenus)){
            for(MenuBean childBean: childMenus){
                String childId = String.valueOf(childBean.getMenuId());
                childBean.setChildList(getChildMenus(childId,allMenus));
            }
        }
        return childMenus;
    }
}
