package com.ruoyi.college.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.college.mapper.GradeMapper;
import com.ruoyi.college.domain.Grade;
import com.ruoyi.college.service.IGradeService;

/**
 * 班级管理Service业务层处理
 * 
 * @author Billy
 * @date 2024-06-21
 */
@Service
public class GradeServiceImpl implements IGradeService 
{
    @Autowired
    private GradeMapper gradeMapper;

    /**
     * 查询班级管理
     * 
     * @param id 班级管理主键
     * @return 班级管理
     */
    @Override
    public Grade selectGradeById(Long id)
    {
        return gradeMapper.selectGradeById(id);
    }

    /**
     * 查询班级管理列表
     * 
     * @param grade 班级管理
     * @return 班级管理
     */
    @Override
    public List<Grade> selectGradeList(Grade grade)
    {
        return gradeMapper.selectGradeList(grade);
    }

    /**
     * 新增班级管理
     * 
     * @param grade 班级管理
     * @return 结果
     */
    @Override
    public int insertGrade(Grade grade)
    {
        return gradeMapper.insertGrade(grade);
    }

    /**
     * 修改班级管理
     * 
     * @param grade 班级管理
     * @return 结果
     */
    @Override
    public int updateGrade(Grade grade)
    {
        return gradeMapper.updateGrade(grade);
    }

    /**
     * 批量删除班级管理
     * 
     * @param ids 需要删除的班级管理主键
     * @return 结果
     */
    @Override
    public int deleteGradeByIds(Long[] ids)
    {
        return gradeMapper.deleteGradeByIds(ids);
    }

    /**
     * 删除班级管理信息
     * 
     * @param id 班级管理主键
     * @return 结果
     */
    @Override
    public int deleteGradeById(Long id)
    {
        return gradeMapper.deleteGradeById(id);
    }
}
