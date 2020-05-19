package com.bigdata.display.controller;


import com.bigdata.display.entity.Expert;
import com.bigdata.display.entity.Technology;
import com.bigdata.display.entity.User;
import com.bigdata.display.pojo.PageResult;
import com.bigdata.display.service.QueryListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
/**
 * @author like
 * @version 1.0
 * @date 2020/5/11 22:54
 */
@RestController
public class QueryListController {

    @Autowired
    QueryListService queryListService;

    @GetMapping("getUserList/{page}/{row}/{authority}")
    public PageResult<User> getUserList(@PathVariable("page") Integer page,
                                        @PathVariable("row") Integer row,
                                        @PathVariable("authority") String authority){

        return queryListService.getUserList(page,row,authority);
    }

    //饼图结束

    /**
     * 获取一个省份的专家
     * @return
     */
    @GetMapping("provinceAndExpert/{page}/{row}/{province}")
    public PageResult<Expert> getProvinceExpertList(@PathVariable("province") String province,
                                                @PathVariable("page") Integer page,
                                                @PathVariable("row") Integer row){

        return queryListService.geExpertList(page,row,province,null,null);
    }

    /**
     * 左饼1
     * @return
     */
    @GetMapping("ageAndExpert/{page}/{row}/{start}/{end}")
    public PageResult<Expert> getAgeExpertList(@PathVariable("start") Integer start,
                                               @PathVariable("end") Integer end,
                                                @PathVariable("page") Integer page,
                                                @PathVariable("row") Integer row){

        return queryListService.getAgeExpertList(start,end, page, row);
    }

    /**
     * 左饼2
     * @return
     */
    @GetMapping("subjectAndExpert/{page}/{row}/{subject}")
    public PageResult<Expert> getSubjectExpert(@PathVariable("subject") String subject,
                                           @PathVariable("page") Integer page,
                                           @PathVariable("row") Integer row){

        return queryListService.geExpertList(page,row,null,subject,null);
    }


    /**
     * 左饼3
     * @param profession
     * @param page
     * @param row
     * @return
     */
    @GetMapping("professionAndExpert/{page}/{row}/{profession}")
    public PageResult<Expert> getProfessionExpert(@PathVariable("profession") String profession,
                                               @PathVariable("page") Integer page,
                                               @PathVariable("row") Integer row){

        return queryListService.geExpertList(page,row,null,null,profession);
    }


    /**
     * 右饼1
     * @return
     */
    @GetMapping("subjectAndTechnology/{page}/{row}/{subject}")
    public PageResult<Technology> getubjectTechnology(@PathVariable("subject") String subject,
                                                      @PathVariable("page") Integer page,
                                                      @PathVariable("row") Integer row){

        return queryListService.getTechnologyList(page,row,subject,null,null);
    }

    /**
     * 左饼2
     * @return
     */
    @GetMapping("professionAndTechnology/{page}/{row}/{profession}")
    public PageResult<Technology> getrofessionTechnology(@PathVariable("profession") String profession,
                                               @PathVariable("page") Integer page,
                                               @PathVariable("row") Integer row){

        return queryListService.getTechnologyList(page,row,null,profession,null);
    }


    /**
     * 左饼3
     */
    @GetMapping("specialAndTechnology/{page}/{row}/{special}")
    public PageResult<Technology> getSpecialTechnology(@PathVariable("special") String special,
                                                  @PathVariable("page") Integer page,
                                                  @PathVariable("row") Integer row){

        return queryListService.getTechnologyList(page,row,null,null,special);
    }



}
