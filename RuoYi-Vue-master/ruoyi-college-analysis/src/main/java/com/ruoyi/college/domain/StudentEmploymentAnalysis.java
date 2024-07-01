package com.ruoyi.college.domain;

import java.io.Serializable;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 就业管理对象 student_employment_analysis
 * 
 * @author Billy
 * @date 2024-06-22
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentEmploymentAnalysis implements Serializable
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 学生外键 */
    @Excel(name = "学生外键")
    private Long studentId;

    /** 公司名称 */
    @Excel(name = "公司名称")
    private String company;

    /** 公司规模 */
    @Excel(name = "公司规模")
    private String scale;

    /** 公司类型 */
    @Excel(name = "公司类型")
    private String type;

    /** 职位 */
    @Excel(name = "职位")
    private String position;

    /** 薪资 */
    @Excel(name = "薪资")
    private String salary;

    /** 城市 */
    @Excel(name = "城市")
    private String address;

    /** 省会城市 */
    @Excel(name = "省会城市")
    private String province;

    /** 就业行业 */
    @Excel(name = "就业行业")
    private String industry;

    /** 入职时间 */
    private String startTime;

    /** 离职时间 */
    private String endTime;

    @Excel(name = "创建时间")
    private String createTime;

    @Excel(name = "修改时间")
    private String updateTime;

    /** 逻辑删除 */
    @Excel(name = "逻辑删除")
    private String deleted;

    private Grade grade;
    private Major major;
    private Student student;
    private Department department;
    private College college;
    private String snum;
}
