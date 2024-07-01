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
 * 高校管理对象 college
 * 
 * @author B1lly
 * @date 2024-06-12
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class College implements Serializable
{
    private static final long serialVersionUID = 1L;

    private Long id;

    /** 学校名称 */
    @Excel(name = "学校名称")
    private String name;

    /** 学校地址 */
    @Excel(name = "学校地址")
    private String address;

    /** 学校类型 */
    @Excel(name = "学校类型")
    private String type;

    /** 学校等级 */
    @Excel(name = "学校等级")
    private String level;

    /** 学校简介 */
    @Excel(name = "学校简介")
    private String introduction;

    /** 逻辑删除 */
    private Long deleted;

    private String createTime;
    private String updateTime;

}
