package com.slin.authority.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 登陆登出controller
 *
 * @author yangsonglin
 * @create 2018-11-13 10:21
 **/
@Controller
public class LoginOutController {

    @RequestMapping(value = {"/","/index","/login"})
    public String login(){

        return "login/login";
    }


    @RequestMapping("/main")
    public String auMain(Model model){

        model.addAttribute("title","标题");
        model.addAttribute("content","内容");
        model.addAttribute("extraInfo","你是admin");

        return "main/main";
    }




}
