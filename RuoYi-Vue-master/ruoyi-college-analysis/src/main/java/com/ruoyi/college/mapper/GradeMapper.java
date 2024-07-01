package com.ruoyi.college.mapper;

import java.util.List;
import com.ruoyi.college.domain.Grade;
import com.ruoyi.college.domain.Major;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/**
 * 班级管理Mapper接口
 * 
 * @author Billy
 * @date 2024-06-21
 */
@Repository
public interface GradeMapper 
{
    /**
     * 查询班级管理
     * 
     * @param id 班级管理主键
     * @return 班级管理
     */
    public Grade selectGradeById(Long id);

    /**
     * 查询班级管理列表
     * 
     * @param grade 班级管理
     * @return 班级管理集合
     */
    public List<Grade> selectGradeList(Grade grade);

    /**
     * 查询班级管理列表
     *
     * @return
     */
    List<Grade> list();
    /**
     * 新增班级管理
     * 
     * @param grade 班级管理
     * @return 结果
     */
    public int insertGrade(Grade grade);

    /**
     * 修改班级管理
     * 
     * @param grade 班级管理
     * @return 结果
     */
    public int updateGrade(Grade grade);

    /**
     * 删除班级管理
     * 
     * @param id 班级管理主键
     * @return 结果
     */
    public int deleteGradeById(Long id);

    /**
     * 批量删除班级管理
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteGradeByIds(Long[] ids);
}
