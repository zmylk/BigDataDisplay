package com.bigdata.display.entity;

import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * @author like
 * @version 1.0
 * @date 2020/5/12 20:59
 */
@Data
@Table(name="expert")
public class Expert implements Serializable {
    @Id
    @KeySql(useGeneratedKeys = true)
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    private String name;
    private String sex;
    private Date birthday;

    private String province;
    private String subject;
    private String profession;

    private String title;
    private String resume;
    private String jobtitle;
}
