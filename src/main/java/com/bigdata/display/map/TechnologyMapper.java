package com.bigdata.display.map;


import com.bigdata.display.entity.Technology;
import com.bigdata.display.pojo.LocalResult;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author like
 * @version 1.0
 * @date 2020/5/12 21:42
 */

@Mapper
public interface TechnologyMapper extends BaseMapper<Technology> {
    List<LocalResult> getTopNResult();
    List<LocalResult> getSubjectResult();
    List<LocalResult> getProfessionResult();
    List<LocalResult> getSpecialResult();

}
