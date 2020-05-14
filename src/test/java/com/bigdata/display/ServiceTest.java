package com.bigdata.display;

import com.bigdata.display.entity.Expert;
import com.bigdata.display.entity.Technology;
import com.bigdata.display.entity.User;
import com.bigdata.display.map.ExpertMapper;
import com.bigdata.display.map.TechnologyMapper;
import com.bigdata.display.map.UserMapper;
import com.bigdata.display.pojo.LocalResult;
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


}
