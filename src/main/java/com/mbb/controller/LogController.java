package com.mbb.controller;

import com.mbb.common.JsonResult;
import com.mbb.common.ResultCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by 闵波波 on 2018/3/9.
 */
@RestController
public class LogController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @GetMapping(value="logTest")
    public JsonResult logTest(){
        logger.info("info");
        logger.error("error");
        logger.debug("debug");
        return new JsonResult(ResultCode.SUCCESS);
    }
}
