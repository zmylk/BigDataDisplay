package com.bigdata.display;

import com.bigdata.display.entity.Expert;
import com.bigdata.display.entity.Technology;
import com.bigdata.display.entity.User;
import com.bigdata.display.map.ExpertMapper;
import com.bigdata.display.map.TechnologyMapper;
import com.bigdata.display.map.UserMapper;
import com.bigdata.display.pojo.LocalResult;
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

/**
 * @author like
 * @version 1.0
 * @date 2020/5/12 21:07
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = BigDataDisplayApplication.class)
public class MapperTest {

    @Autowired
    UserMapper userMapper;
    @Autowired
    ExpertMapper expertMapper;
    @Autowired
    TechnologyMapper technologyMapper;

    @Test
    public void  test(){


        User user = new User();
        user.setName("李我");
        user.setSex("男");
        user.setLocation("包头");
        Date date = new Date();
        user.setBirthday(date);
        userMapper.insert(user);
    }


    @Test
    public void  testUser(){
        try {
            BufferedReader reader = new BufferedReader(new FileReader(new File("D:\\mycode\\BigDataDisplay\\data\\数据样例(1).txt")));
            String s = null;
            while ((s=reader.readLine())!=null){
                String[] split = s.split("\t");
                User user = new User();
                user.setName(split[0]);
                user.setSex(split[1]);
                SimpleDateFormat df = new SimpleDateFormat("yyyy.MM");
                Date parse = df.parse(split[2]);
                user.setBirthday(parse);
                user.setLocation(split[3]);
                userMapper.insert(user);

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void  testechnology(){
        try {
            BufferedReader reader = new BufferedReader(new FileReader(new File("D:\\mycode\\BigDataDisplay\\data\\数据样例(2).txt")));
            String s = null;
            while ((s=reader.readLine())!=null){
                String[] split = s.split("\t");
                Technology technology = new Technology();
                technology.setName(split[0]);
                technology.setSubject(split[1]);
                technology.setProfession(split[2]);
                technology.setSpecial(split[3]);
                technology.setClick(Integer.valueOf(split[4]));

                technology.setMydate(new Date());
                technologyMapper.insert(technology);

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void  testExpert(){
        try {
            BufferedReader reader = new BufferedReader(new FileReader(new File("D:\\mycode\\BigDataDisplay\\data\\数据样例(4).txt")));
            String s = null;
            while ((s=reader.readLine())!=null){
                String[] split = s.split("\t");
                Expert expert = new Expert();
                expert.setName(split[0]);
                expert.setSex(split[1]);
                SimpleDateFormat df = new SimpleDateFormat("yyyy.MM");
                Date parse = df.parse(split[2]);
                expert.setBirthday(parse);
                expert.setSubject(split[3]);
                expert.setProfession(split[4]);
                expert.setProvince(split[5]);
                expert.setTitle(split[6]);
                expert.setJobtitle(split[7]);
                if (split.length>8){
                    expert.setResume(split[8]);
                }

                expertMapper.insert(expert);

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void  test03(){
        List<LocalResult> localResult = userMapper.getLocalResult();
        for (LocalResult result : localResult) {
            System.out.println(result.getName());
        }
    }

    @Test
    public void  test04(){
        List<LocalResult> topNResult = technologyMapper.getProfessionResult();
        for (LocalResult localResult : topNResult) {
            System.out.println(localResult.getName());
            System.out.println(localResult.getMycount());
        }

    }

    @Test
    public void  test05(){
        List<Expert> experts = expertMapper.selectAll();
        for (Expert expert : experts) {
            System.out.println(expert.getBirthday());
        }

    }


}
