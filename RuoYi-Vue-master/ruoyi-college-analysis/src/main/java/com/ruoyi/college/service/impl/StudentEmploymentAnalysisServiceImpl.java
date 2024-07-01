package com.ruoyi.college.service.impl;

import java.util.List;

import com.ruoyi.college.domain.bo.EmployeeBo;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.college.mapper.StudentEmploymentAnalysisMapper;
import com.ruoyi.college.domain.StudentEmploymentAnalysis;
import com.ruoyi.college.service.IStudentEmploymentAnalysisService;

/**
 * 就业管理Service业务层处理
 * 
 * @author Billy
 * @date 2024-06-22
 */
@Service
public class StudentEmploymentAnalysisServiceImpl implements IStudentEmploymentAnalysisService 
{
    @Autowired
    private StudentEmploymentAnalysisMapper studentEmploymentAnalysisMapper;

    /**
     * 查询就业管理
     * 
     * @param id 就业管理主键
     * @return 就业管理
     */
    @Override
    public StudentEmploymentAnalysis selectStudentEmploymentAnalysisById(Long id)
    {
        return studentEmploymentAnalysisMapper.selectStudentEmploymentAnalysisById(id);
    }

    /**
     * 查询就业管理列表
     * 
     * @param studentEmploymentAnalysis 就业管理
     * @return 就业管理
     */
    @Override
    public List<StudentEmploymentAnalysis> selectStudentEmploymentAnalysisList(StudentEmploymentAnalysis studentEmploymentAnalysis)
    {
        return studentEmploymentAnalysisMapper.selectStudentEmploymentAnalysisList(studentEmploymentAnalysis);
    }

    /**
     * 新增就业管理
     * 
     * @param studentEmploymentAnalysis 就业管理
     * @return 结果
     */
    @Override
    public int insertStudentEmploymentAnalysis(StudentEmploymentAnalysis studentEmploymentAnalysis)
    {
        return studentEmploymentAnalysisMapper.insertStudentEmploymentAnalysis(studentEmploymentAnalysis);
    }

    /**
     * 修改就业管理
     * 
     * @param studentEmploymentAnalysis 就业管理
     * @return 结果
     */
    @Override
    public int updateStudentEmploymentAnalysis(StudentEmploymentAnalysis studentEmploymentAnalysis)
    {
        return studentEmploymentAnalysisMapper.updateStudentEmploymentAnalysis(studentEmploymentAnalysis);
    }

    /**
     * 批量删除就业管理
     * 
     * @param ids 需要删除的就业管理主键
     * @return 结果
     */
    @Override
    public int deleteStudentEmploymentAnalysisByIds(Long[] ids)
    {
        return studentEmploymentAnalysisMapper.deleteStudentEmploymentAnalysisByIds(ids);
    }

    /**
     * 删除就业管理信息
     * 
     * @param id 就业管理主键
     * @return 结果
     */
    @Override
    public int deleteStudentEmploymentAnalysisById(Long id)
    {
        return studentEmploymentAnalysisMapper.deleteStudentEmploymentAnalysisById(id);
    }

    @Override
    public List<EmployeeBo> countByProvince() {
        return studentEmploymentAnalysisMapper.countByProvince();
    }

    @Override
    public List<EmployeeBo> countBySalary() {
        return studentEmploymentAnalysisMapper.countBySalary();
    }
}
