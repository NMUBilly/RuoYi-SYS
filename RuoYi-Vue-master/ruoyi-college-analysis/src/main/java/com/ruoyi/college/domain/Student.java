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
 * 学生管理对象 student
 * 
 * @author Billy
 * @date 2024-06-21
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student implements Serializable
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 学生姓名 */
    @Excel(name = "学生姓名")
    private String name;

    /** 学生性别 */
    @Excel(name = "学生性别")
    private String gender;

    /** 班级外键 */
    @Excel(name = "班级外键")
    private Long gradeId;

    /** 学生电话 */
    @Excel(name = "学生电话")
    private String phone;

    /** 学生邮箱 */
    @Excel(name = "学生邮箱")
    private String email;

    /** 学生地址 */
    @Excel(name = "学生地址")
    private String address;

    /** 学生密码 */
    @Excel(name = "学生密码")
    private String password;

    /** 学生简介 */
    @Excel(name = "学生简介")
    private String instruction;

    /** 逻辑删除 */
    private Long deleted;

    @Excel(name = "创建时间")
    private String createTime;

    @Excel(name = "修改时间")
    private String updateTime;

    private Grade grade;
    private Major major;
    private Department department;
    private College college;
    private String snum;
}
