package com.ruoyi.college.domain.bo;

import com.ruoyi.common.annotation.Excel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 院系管理对象 department
 * 
 * @author Billy
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentBo implements Serializable
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
    @Excel(name = "高校名称")
    private String college_name;
    @Excel(name = "创建时间")
    private String createTime;
    @Excel(name = "修改时间")
    private String updateTime;
}
