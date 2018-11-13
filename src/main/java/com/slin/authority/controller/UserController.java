package com.slin.authority.controller;

import com.slin.authority.model.UserBean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yangsonglin
 * @create 2018-11-13 11:30
 **/
@Controller
@RequestMapping("/user")
public class UserController {


    @RequestMapping("/list")
    public String  listUser(Model model) {
        List<UserBean> userList = new ArrayList<UserBean>();
        for (int i = 0; i <10; i++) {
            userList.add(new UserBean("zhangsan"+i,i));
        }
        model.addAttribute("users", userList);
        return "user/user_list";
    }
}
