package com.bigdata.display;

import com.bigdata.display.entity.Expert;
import com.bigdata.display.entity.Technology;
import com.bigdata.display.entity.User;
import com.bigdata.display.map.ExpertMapper;
import com.bigdata.display.map.TechnologyMapper;
import com.bigdata.display.map.UserMapper;
import com.bigdata.display.pojo.LocalResult;
import com.bigdata.display.pojo.PageResult;
import com.bigdata.display.service.DisplayService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author like
 * @version 1.0
 * @date 2020/5/12 21:07
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = BigDataDisplayApplication.class)
public class ServiceTest {

    @Autowired
    DisplayService displayService;

    @Test
    public void  test03(){
        List<Map<String, Object>> maps = displayService.getageDstributionInformation();
        for (Map<String, Object> map : maps) {
            System.out.println(map.get("name"));
            System.out.println(map.get("value"));
        }
    }

//    @Test
//    public void  getProvinceExpert(){
//        PageResult<Expert> e = displayService.getProvinceExpert("黑龙江", 2, 5);
//        List<Expert> items = e.getItems();
//        System.out.println(e.getTotal());
//        System.out.println(e.getTotalPage());
//        for (Expert expert1 : items) {
//            System.out.println(expert1);
//        }
//
//    }

    @Test
    public void  getUser(){
        PageResult<User> user = displayService.getUser(1, 5);
        List<User> items = user.getItems();
        for (User item : items) {
            System.out.println(item);
        }

    }


    @Test
    public void  getExc(){
        PageResult<Expert> user = displayService.getExpert(1, 5);
        List<Expert> items = user.getItems();
        for (Expert item : items) {
            System.out.println(item);
        }

    }

    @Test
    public void  getTec(){
        PageResult<Technology> user = displayService.getTechnology(1, 5);
        List<Technology> items = user.getItems();
        for (Technology item : items) {
            System.out.println(item);
        }

    }

}
