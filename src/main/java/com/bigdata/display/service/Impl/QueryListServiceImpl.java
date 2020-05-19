package com.bigdata.display.service.Impl;

import com.bigdata.display.entity.Expert;
import com.bigdata.display.entity.Technology;
import com.bigdata.display.entity.User;
import com.bigdata.display.map.ExpertMapper;
import com.bigdata.display.map.TechnologyMapper;
import com.bigdata.display.map.UserMapper;
import com.bigdata.display.pojo.PageResult;
import com.bigdata.display.service.QueryListService;
import com.bigdata.display.util.TimeUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author like
 * @version 1.0
 * @date 2020/5/17 13:27
 */
@Service
public class QueryListServiceImpl implements QueryListService {

    @Autowired
    UserMapper userMapper;
    @Autowired
    ExpertMapper expertMapper;
    @Autowired
    TechnologyMapper technologyMapper;

    static int[][] ageList ={{0,19},{20,29},{30,39},{40,49},{50,120}};

    @Override
    public PageResult<User> getUserList(Integer page, Integer row, String authority) {
        PageHelper.startPage(page,row);
        User user = new User();
        if (authority!=null){
            user.setLocation(authority);
        }

        List<User> select = userMapper.select(user);
        PageInfo<User> info = new PageInfo<>(select);
        return  new PageResult<>(info.getTotal(),(long)info.getPages(), select);
    }

    @Override
    public PageResult<Expert> geExpertList(Integer page, Integer row, String province,String subject, String profession) {
        PageHelper.startPage(page,row);
        Expert expert = new Expert();
        if (province!=null){
            expert.setProvince(province);
        }
        if (subject!=null){
            expert.setSubject(subject);
        }
        if (profession!=null){
            expert.setProfession(profession);
        }
        List<Expert> select = expertMapper.select(expert);
        PageInfo<Expert> info = new PageInfo<>(select);
        return new PageResult<>(info.getTotal(),(long)info.getPages(), select);
    }

    /**
     * 0 -> 0-19
     * 1 ->20-29
     *2 -> 30-39
     *3 -> 40 -50
     *4 -> 50- +
     * @param page
     * @param row
     * @return
     */



    @Override
    public PageResult<Expert> getAgeExpertList(Integer start,Integer end, Integer page, Integer row) {
        PageHelper.startPage(page,row);
        Date date = new Date();
        int year = TimeUtil.getYear(date);
        int a = year-end;
        int b = year-start;
        List<Expert> expertByAge = expertMapper.getExpertByAge(String.valueOf(a), String.valueOf(b));
        PageInfo<Expert> info = new PageInfo<>(expertByAge);
        return new PageResult<>(info.getTotal(),(long)info.getPages(), expertByAge);

    }





    @Override
    public PageResult<Technology> getTechnologyList(Integer page, Integer row, String subject, String profession, String special) {
        PageHelper.startPage(page,row);
        Technology technology = new Technology();
        if (subject!=null){
            technology.setSubject(subject);
        }
        if (profession!=null){
            technology.setProfession(profession);
        }
        if (special!=null){
            technology.setSpecial(special);
        }
        List<Technology> select = technologyMapper.select(technology);
        PageInfo<Technology> info = new PageInfo<>(select);
        return new PageResult<>(info.getTotal(),(long)info.getPages(), select);
    }


}
