package com.bigdata.display.service;

import com.bigdata.display.pojo.LocalResult;

import java.util.List;
import java.util.Map;

/**
 * @author like
 * @version 1.0
 * @date 2020/5/12 21:16
 */
public interface DisplayService {
    List<LocalResult> getAuthorityInformation();
    List<LocalResult> getProvincialInformation();
    List<Map<String,Object>>  getageDstributionInformation();
    List<Map<String,Object>> getProfessionInformation();
    List<Map<String,Object>> getSubjectInformation();
    Map getIntermediateInformationInformation();
    List<Map<String, Object>> getBigMapInformationInformation();
    Map getTechnologyNumInformation();
    Map getTechnologyTopNInformation();
    List<Map<String,Object>> getDisciplineDistributionInformation();
    List<Map<String,Object>> getProfessionalDistributionInformation();
    List<Map<String,Object>> getSpecialDistributionInformation();
}
