package com.rbac.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by hahah on 2017/5/4.
 */
@Controller
public class MainController {

    @RequestMapping("/hello")
    public ModelAndView hello(ModelMap model){
        String hello = "Hello RBAC!";
        model.addAttribute("hello",hello);
        return new ModelAndView("hello", model);
    }

    @RequestMapping("/login")
    public ModelAndView login(ModelMap modelMap){
        return new ModelAndView("login",modelMap);
    }

}
