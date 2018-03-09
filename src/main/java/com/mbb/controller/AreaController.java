package com.mbb.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mbb.common.JsonResult;
import com.mbb.common.ResultCode;
import com.mbb.entity.Area;
import com.mbb.service.AreaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Owner on 2018/3/7.
 */
@RestController
@RequestMapping(value="/superAdmin")
public class AreaController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private AreaService areaService;

    @GetMapping(value="/listArea")
    public JsonResult listArea(){
        logger.info("查询所有区域");
        PageHelper.startPage(1,2);
        List<Area> areaList = areaService.getAreaList();
        PageInfo pageInfo = new PageInfo(areaList);
        return new JsonResult(ResultCode.SUCCESS,"成功",pageInfo);
    }

    @GetMapping(value="/getAreaById")
    public JsonResult getAreaById(Integer areaId){
        Map<String,Object> modelMap = new HashMap<String,Object>();
        Area area = areaService.getAreaById(areaId);
        modelMap.put("area",area);
        return new JsonResult(ResultCode.SUCCESS,"成功",modelMap);
    }

    @PostMapping(value="/addArea")
    public Map<String,Object> addArea(@RequestBody Area area){
        Map<String,Object> modelMap = new HashMap<String,Object>();
        modelMap.put("success",areaService.addArea(area));
        return modelMap;
    }

    @PostMapping(value="/updateArea")
    public Map<String,Object> updateArea(@RequestBody Area area){
        Map<String,Object> modelMap = new HashMap<String,Object>();
        modelMap.put("success",areaService.modifyArea(area));
        return modelMap;
    }

    @GetMapping(value="/deleteArea")
    public Map<String,Object> deleteArea(Integer areaId){
        Map<String,Object> modelMap = new HashMap<String,Object>();
        modelMap.put("success",areaService.deleteArea(areaId));
        return modelMap;
    }
}
