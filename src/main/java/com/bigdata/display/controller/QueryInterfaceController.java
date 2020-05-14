package com.bigdata.display.controller;

import com.bigdata.display.pojo.LocalResult;
import com.bigdata.display.service.DisplayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
        List<Map<String,Object>> res = new ArrayList<>();
        Map<String,Object> tmp1 = new HashMap<>();
        tmp1.put("name","农业");
        tmp1.put("value",5);
        Map<String,Object> tmp2 = new HashMap<>();
        tmp2.put("name","畜牧");
        tmp2.put("value",5);
        Map<String,Object> tmp3 = new HashMap<>();
        tmp3.put("name","农机");
        tmp3.put("value",5);
        Map<String,Object> tmp4 = new HashMap<>();
        tmp4.put("name","农业信息化");
        tmp4.put("value",5);

        res.add(tmp1);
        res.add(tmp2);
        res.add(tmp3);
        res.add(tmp4);
        return res;
    }

    /**
     * 专业分布
     * @return
     */
    @GetMapping("professionalDistribution")
    public  List<Map<String,Object>> getProfessionalDistributionInformation(){
        List<Map<String,Object>> res = new ArrayList<>();
        Map<String,Object> tmp1 = new HashMap<>();
        tmp1.put("name","植保");
        tmp1.put("value",5);
        Map<String,Object> tmp2 = new HashMap<>();
        tmp2.put("name","土肥");
        tmp2.put("value",5);
        Map<String,Object> tmp3 = new HashMap<>();
        tmp3.put("name","栽培");
        tmp3.put("value",5);
        Map<String,Object> tmp4 = new HashMap<>();
        tmp4.put("name","育种");
        tmp4.put("value",5);
        Map<String,Object> tmp5 = new HashMap<>();
        tmp5.put("name","数字农业");
        tmp5.put("value",5);
        res.add(tmp1);
        res.add(tmp2);
        res.add(tmp3);
        res.add(tmp4);
        res.add(tmp5);
        return res;
    }

    /**
     * 专项分布
     * @return
     */
    @GetMapping("specialDistribution")
    public List<Map<String,Object>> getSpecialDistributionInformation(){
        List<Map<String,Object>> res = new ArrayList<>();
        Map<String,Object> tmp1 = new HashMap<>();
        tmp1.put("name","玉米植保");
        tmp1.put("value",5);
        Map<String,Object> tmp2 = new HashMap<>();
        tmp2.put("name","大豆植保");
        tmp2.put("value",5);
        Map<String,Object> tmp3 = new HashMap<>();
        tmp3.put("name","玉米土肥");
        tmp3.put("value",5);
        Map<String,Object> tmp4 = new HashMap<>();
        tmp4.put("name","大豆土肥");
        tmp4.put("value",5);
        Map<String,Object> tmp5 = new HashMap<>();
        tmp5.put("name","玉米栽培");
        tmp5.put("value",5);
        Map<String,Object> tmp6 = new HashMap<>();
        tmp6.put("name","玉米育种");
        tmp6.put("value",5);
        Map<String,Object> tmp7 = new HashMap<>();
        tmp7.put("name","人工智能");
        tmp7.put("value",5);
        res.add(tmp1);
        res.add(tmp2);
        res.add(tmp3);
        res.add(tmp4);
        res.add(tmp5);
        res.add(tmp6);
        res.add(tmp7);

        return res;
    }


    //饼图结束
}
