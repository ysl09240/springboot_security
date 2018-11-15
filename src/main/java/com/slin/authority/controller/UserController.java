package com.slin.authority.controller;

import com.slin.authority.model.UserBean;
import com.slin.authority.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author yangsonglin
 * @create 2018-11-13 11:30
 **/
@Controller
@RequestMapping("/user")
public class UserController {


    @Autowired
    IUserService userService;
    @RequestMapping("/list")
    public String  listUser(Model model) {
        List<UserBean> userList =userService.findUserList();

        model.addAttribute("users", userList);
        return "user/user_list";
    }
}
