package com.slin.authority.service;

import com.slin.authority.model.MenuBean;

import java.util.List;

/**
 * Description
 */
public interface MenuService {
    List<MenuBean> getAllMenu();

    /**
     * 获取树状结构的菜单
     * @return
     */
    List<MenuBean> getMenuTree();
}
