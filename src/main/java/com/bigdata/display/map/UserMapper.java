package com.bigdata.display.map;

import com.bigdata.display.entity.User;
import com.bigdata.display.pojo.LocalResult;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


/**
 * @author like
 * @version 1.0
 * @date 2020/5/12 21:02
 */
@Mapper
public interface  UserMapper extends BaseMapper<User> {

    List<LocalResult> getLocalResult();
}
