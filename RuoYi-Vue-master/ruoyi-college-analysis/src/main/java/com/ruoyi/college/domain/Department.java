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
 * 院系管理对象 department
 * 
 * @author Billy
 * @date 2024-06-14
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Department implements Serializable
{
    private static final long serialVersionUID = 1L;

    private Long id;

    /** 院系名称 */
    @Excel(name = "院系名称")
    private String name;

    /** 院系简介 */
    @Excel(name = "院系简介")
    private String introduction;

    /** 高校外键 */
    @Excel(name = "高校外键")
    private Long collegeId;

    /** 逻辑删除 */
    private Long deleted;

    @Excel(name = "创建时间")
    private String createTime;

    @Excel(name = "修改时间")
    private String updateTime;
}
