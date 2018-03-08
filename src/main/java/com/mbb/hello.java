package com.mbb;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Owner on 2018/3/7.
 */
//https://gitee.com/xiangze/demo
@RestController
public class hello {

    @RequestMapping(value="hello",method = RequestMethod.GET)
    public String hello(){
        return "hello SpringBoot!";
    }
}
