package com.l_3177.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @RequestMapping({"","/","index"})
    public String index(){

        return "index";
    }

    @RequestMapping("upload")
    public String upload(){

        return "upload";
    }
}
