package com.bigdata.display.map;



import com.bigdata.display.entity.Expert;
import com.bigdata.display.pojo.LocalResult;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


@Mapper
public interface ExpertMapper extends BaseMapper<Expert> {

    List<LocalResult> getProvinceResult();
    List<LocalResult> getProfessionResult();
    List<LocalResult> getSubjectResult();
    List<Expert> getExpertByAge(@Param("start")String start,@Param("end") String end);

}
