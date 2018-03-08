package com.mbb.dao;

import com.mbb.entity.Area;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Owner on 2018/3/7.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class AreaDaoTest {
    @Autowired
    private AreaDao areaDao;

    @Test
    @Ignore
    public void queryArea() throws Exception {
        List<Area> areaList = areaDao.queryArea();
        assertEquals(2,areaList.size());
    }

    @Test
    @Ignore
    public void queryAreaById() throws Exception {
        Area area = areaDao.queryAreaById(1);
        assertEquals("东苑",area.getAreaName());
    }

    @Test
    @Ignore
    public void insertArea() throws Exception {
        Area area = new Area();
        area.setAreaName("东苑");
        area.setPriority(1);
        int query = areaDao.insertArea(area);
        assertEquals(1,query);
    }

    @Test
    @Ignore
    public void updateArea() throws Exception {
        Area area = new Area();
        area.setAreaName("南娜");
        area.setAreaId(3);
        int query = areaDao.updateArea(area);
        assertEquals(1,query);
    }

    @Test
    @Ignore
    public void deleteArea() throws Exception {
        int query = areaDao.deleteArea(3);
        assertEquals(1,query);
    }
}