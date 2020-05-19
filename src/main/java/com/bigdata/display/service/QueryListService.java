package com.bigdata.display.service;

import com.bigdata.display.entity.Expert;
import com.bigdata.display.entity.Technology;
import com.bigdata.display.entity.User;
import com.bigdata.display.pojo.PageResult;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author like
 * @version 1.0
 * @date 2020/5/17 13:27
 */
public interface QueryListService {
    PageResult<User> getUserList(Integer page, Integer row,String authority);
    PageResult<Expert> geExpertList(Integer page, Integer row, String province,String subject, String profession);
    PageResult<Expert> getAgeExpertList(Integer start, Integer end, Integer page, Integer row);
    PageResult<Technology> getTechnologyList(Integer page, Integer row,String subject,String profession,String special);

}
