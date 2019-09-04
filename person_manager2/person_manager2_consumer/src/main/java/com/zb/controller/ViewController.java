package com.zb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ViewController {
    @RequestMapping(value = "/index")
    public String index(){
        return "index";
    }

    @RequestMapping(value = "/update")
    public String update(){
        return "update";
    }

    @RequestMapping(value = "/add")
    public String add(){
        return "add";
    }
}
