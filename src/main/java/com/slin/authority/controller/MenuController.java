package com.slin.authority.controller;

import com.slin.authority.model.MenuBean;
import com.slin.authority.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Description
 */
@RestController
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    private MenuService menuService;

    @RequestMapping("/getMenuTree")
    public List<MenuBean> getMenuTree(){
        return menuService.getMenuTree();
    }
}
