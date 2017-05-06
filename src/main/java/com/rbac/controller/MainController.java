package com.rbac.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by hahah on 2017/5/4.
 */
@Controller
public class MainController {

    @RequestMapping("/hello")
    public @ResponseBody
    String hello(Model model){
        String hello = "Hello RBAC!";
        System.out.println(hello);
        model.addAttribute("hello",hello);
        return "hello";
    }
}
