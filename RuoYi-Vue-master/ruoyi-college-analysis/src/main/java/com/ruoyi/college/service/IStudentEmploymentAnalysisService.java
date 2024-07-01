package com.ruoyi.college.service;

import java.util.List;
import com.ruoyi.college.domain.StudentEmploymentAnalysis;
import com.ruoyi.college.domain.bo.EmployeeBo;

/**
 * 就业管理Service接口
 * 
 * @author Billy
 * @date 2024-06-22
 */
public interface IStudentEmploymentAnalysisService 
{
    /**
     * 查询就业管理
     * 
     * @param id 就业管理主键
     * @return 就业管理
     */
    public StudentEmploymentAnalysis selectStudentEmploymentAnalysisById(Long id);

    /**
     * 查询就业管理列表
     * 
     * @param studentEmploymentAnalysis 就业管理
     * @return 就业管理集合
     */
    public List<StudentEmploymentAnalysis> selectStudentEmploymentAnalysisList(StudentEmploymentAnalysis studentEmploymentAnalysis);

    /**
     * 新增就业管理
     * 
     * @param studentEmploymentAnalysis 就业管理
     * @return 结果
     */
    public int insertStudentEmploymentAnalysis(StudentEmploymentAnalysis studentEmploymentAnalysis);

    /**
     * 修改就业管理
     * 
     * @param studentEmploymentAnalysis 就业管理
     * @return 结果
     */
    public int updateStudentEmploymentAnalysis(StudentEmploymentAnalysis studentEmploymentAnalysis);

    /**
     * 批量删除就业管理
     * 
     * @param ids 需要删除的就业管理主键集合
     * @return 结果
     */
    public int deleteStudentEmploymentAnalysisByIds(Long[] ids);

    /**
     * 删除就业管理信息
     * 
     * @param id 就业管理主键
     * @return 结果
     */
    public int deleteStudentEmploymentAnalysisById(Long id);

    //统计不同省份就业人数
    public List<EmployeeBo> countByProvince();

    //统计不同薪水就业人数
    public List<EmployeeBo> countBySalary();
}
