package com.mbb.service.impl;

import com.mbb.dao.AreaDao;
import com.mbb.entity.Area;
import com.mbb.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created by Owner on 2018/3/7.
 */
@Service
public class AreaServiceImpl implements AreaService {
    @Autowired
    private AreaDao areaDao;

    @Override
    public List<Area> getAreaList() {
        return areaDao.queryArea();
    }

    @Override
    public Area getAreaById(int areaId) {
        return areaDao.queryAreaById(areaId);
    }

    @Transactional
    @Override
    public boolean addArea(Area area) {
        if(area.getAreaName() != null && !area.getAreaName().equals("")){
            area.setCreateTime(new Date());
            area.setLastEditTime(new Date());
            try{
                int num = areaDao.insertArea(area);
                if(num > 0){
                    return true;
                }else{
                    throw new RuntimeException("失败");
                }
            }catch (Exception e){
                throw new RuntimeException("添加区域信息失败:" + e.toString());
            }
        }else{
            throw new RuntimeException("区域信息不能为空！");
        }
    }

    @Transactional
    @Override
    public boolean modifyArea(Area area) {
        if(area.getAreaId() != null){
            area.setLastEditTime(new Date());
            try{
                int num = areaDao.updateArea(area);
                if(num > 0){
                    return true;
                }else{
                    throw new RuntimeException("失败");
                }
            }catch (Exception e){
                throw new RuntimeException("修改区域信息失败:" + e.toString());
            }
        }else{
            throw new RuntimeException("id不能为空！");
        }
    }

    @Transactional
    @Override
    public boolean deleteArea(int areaId) {
        if(areaId > 0){
            try{
                int num = areaDao.deleteArea(areaId);
                if(num > 0){
                    return true;
                }else{
                    throw new RuntimeException("失败");
                }
            }catch (Exception e){
                throw new RuntimeException("删除区域信息失败:" + e.toString());
            }
        }else{
            throw new RuntimeException("id不能为空！");
        }
    }
}
