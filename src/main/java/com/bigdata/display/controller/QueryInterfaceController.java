package com.bigdata.display.controller;

import com.bigdata.display.entity.Expert;
import com.bigdata.display.entity.Technology;
import com.bigdata.display.entity.User;
import com.bigdata.display.pojo.LocalResult;
import com.bigdata.display.pojo.PageResult;
import com.bigdata.display.service.DisplayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author like
 * @version 1.0
 * @date 2020/5/11 22:54
 */
@RestController
public class QueryInterfaceController {

    @Autowired
    DisplayService displayService;
    /**
     * 管理局分布
     * @return
     */
    @GetMapping("authority")
    public Map<String, Object> getAuthorityInformation(){
        List<LocalResult> authorityInformation = displayService.getAuthorityInformation();
        int size = authorityInformation.size();
        String[] location = new String[size];
        int[] nums = new int[size];
        for (int i = 0; i < authorityInformation.size(); i++) {
            location[i] = authorityInformation.get(i).getName();
            nums[i] = authorityInformation.get(i).getMycount();
        }
        Map<String,Object> res = new HashMap<>();
        res.put("location",location);
        res.put("nums",nums);
        return res;
    }


    /**
     * 各省份专家
     * @return
     */
    @GetMapping("provincial")
    public Map getProvincialInformation(){
        List<LocalResult> provincialInformation = displayService.getProvincialInformation();
        int size = provincialInformation.size();
        String[] location = new String[size];
        int[] nums = new int[size];
        for (int i = 0; i < provincialInformation.size(); i++) {
            location[i] = provincialInformation.get(i).getName();
            nums[i] = provincialInformation.get(i).getMycount();
        }
        Map<String,Object> res = new HashMap<>();
        res.put("provincial",location);
        res.put("nums",nums);
        return res;
    }

    //饼图开始

    /**
     * 专家年龄分布
     * @return
     */
    @GetMapping("age")
    public List<Map<String,Object>>  getageDstributionInformation(){

        return displayService.getageDstributionInformation();
    }

    /**
     * 专家学科分布
     * @return
     */
    @GetMapping("subject")
    public List<Map<String,Object>> getSubjectInformation(){
        return displayService.getSubjectInformation();
    }

    /**
     * 专家专业分布
     * @return
     */
    @GetMapping("leftProfessionalDistribution")
    public  List<Map<String,Object>> getProfessionInformation(){

        return displayService.getProfessionInformation();
    }


    //饼图结束

    //左部分结束

    //中间开始

    /**
     * 专家数&科技数
     * @return
     */
    @GetMapping("intermediateInformation")
    public Map getIntermediateInformationInformation(){
        return displayService.getIntermediateInformationInformation();
    }


    /**
     * 各省份专家数
     * @return
     */
    @GetMapping("bigMap")
    public List<Map<String, Object>> getBigMapInformationInformation(){
        return displayService.getBigMapInformationInformation();
    }


    //中间结束

    //右部分开始

    /**
     * 三年各月份科技数
     * @return
     */
    @GetMapping("technologyNum")
    public Map getTechnologyNumInformation(){
        return displayService.getTechnologyNumInformation();
    }

    /**
     * 技术点击数量前五
     * @return
     */
    @GetMapping("technologyTopN")
    public Map getTechnologyTopNInformation(){

        return displayService.getTechnologyTopNInformation();
    }

    //饼图开始

    /**
     * 学科分布
     * @return
     */
    @GetMapping("disciplineDistribution")
    public List<Map<String,Object>> getDisciplineDistributionInformation(){

        return displayService.getDisciplineDistributionInformation();
    }

    /**
     * 专业分布
     * @return
     */
    @GetMapping("professionalDistribution")
    public  List<Map<String,Object>> getProfessionalDistributionInformation(){

        return displayService.getProfessionalDistributionInformation();
    }

    /**
     * 专项分布
     * @return
     */
    @GetMapping("specialDistribution")
    public List<Map<String,Object>> getSpecialDistributionInformation(){

        return displayService.getSpecialDistributionInformation();
    }





    /**
     * 获取用户列表
     * @param page
     * @param row
     * @return
     */
    @GetMapping("getUser/{page}/{row}")
    public PageResult<User> getUser(@PathVariable("page") Integer page,
                                    @PathVariable("row") Integer row){

        return displayService.getUser(page,row);
    }

    @GetMapping("getExpert/{page}/{row}")
    public PageResult<Expert> getExpert(@PathVariable("page") Integer page,
                                      @PathVariable("row") Integer row){
        return displayService.getExpert(page, row);
    }


    @GetMapping("getTechnology/{page}/{row}")
    public PageResult<Technology> getTechnology(@PathVariable("page") Integer page,
                                          @PathVariable("row") Integer row){

        return displayService.getTechnology(page, row);
    }


}
