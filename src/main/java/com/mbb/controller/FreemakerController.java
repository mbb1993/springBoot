package com.mbb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by 闵波波 on 2018/3/9.
 */
@Controller
@RequestMapping(value="freemaker")
public class FreemakerController {

    @GetMapping(value="/index")
    public String index(){
        return "index";
    }
}
