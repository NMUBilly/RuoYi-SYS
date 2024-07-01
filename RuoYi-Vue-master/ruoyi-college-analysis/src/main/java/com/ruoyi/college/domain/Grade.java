package com.ruoyi.college.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

import java.io.Serializable;

/**
 * 班级管理对象 grade
 * 
 * @author Billy
 * @date 2024-06-21
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Grade implements Serializable
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 班级名称 */
    @Excel(name = "班级名称")
    private String name;

    /** 专业外键 */
    @Excel(name = "专业外键")
    private Long majorId;

    /** 专业简介 */
    @Excel(name = "专业简介")
    private String instruction;

    /** 逻辑删除 */
    private Long deleted;

    @Excel(name = "创建时间")
    private String createTime;

    @Excel(name = "修改时间")
    private String updateTime;

    //mybatis多对一映射
    private Major major;
}
