package com.ruoyi.college.mapper;

import java.util.List;
import com.ruoyi.college.domain.StudentEmploymentAnalysis;
import com.ruoyi.college.domain.bo.EmployeeBo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * 就业管理Mapper接口
 * 
 * @author Billy
 * @date 2024-06-22
 */
@Repository
public interface StudentEmploymentAnalysisMapper 
{
    //统计不同省份就业人数
    public List<EmployeeBo> countByProvince();

    //统计不同薪资的人数
    public List<EmployeeBo> countBySalary();
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
     * 删除就业管理
     * 
     * @param id 就业管理主键
     * @return 结果
     */
    public int deleteStudentEmploymentAnalysisById(Long id);

    /**
     * 批量删除就业管理
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteStudentEmploymentAnalysisByIds(Long[] ids);
}
