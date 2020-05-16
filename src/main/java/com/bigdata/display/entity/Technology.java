package com.bigdata.display.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name="technology")
public class Technology implements Serializable {
    @Id
    @JsonIgnore
    private Integer id;

    private String name;
    private String subject;
    private String profession;
    private String special;
    private Integer click;
    @JsonFormat(pattern = "yyyy年MM月dd日")
    private Date mydate;



}
