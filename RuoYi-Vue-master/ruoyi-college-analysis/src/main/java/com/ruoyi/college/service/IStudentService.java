package com.ruoyi.college.service;

import java.util.List;

import com.ruoyi.college.domain.Department;
import com.ruoyi.college.domain.Grade;
import com.ruoyi.college.domain.Major;
import com.ruoyi.college.domain.Student;

/**
 * 学生管理Service接口
 * 
 * @author Billy
 * @date 2024-06-21
 */
public interface IStudentService 
{
    /**
     * 查询学生管理
     * 
     * @param id 学生管理主键
     * @return 学生管理
     */
    public Student selectStudentById(Long id);

    /**
     * 查询学生管理列表
     * 
     * @param student 学生管理
     * @return 学生管理集合
     */
    public List<Student> selectStudentList(Student student);

    /**
     * 新增学生管理
     * 
     * @param student 学生管理
     * @return 结果
     */
    public int insertStudent(Student student);

    /**
     * 修改学生管理
     * 
     * @param student 学生管理
     * @return 结果
     */
    public int updateStudent(Student student);

    /**
     * 批量删除学生管理
     * 
     * @param ids 需要删除的学生管理主键集合
     * @return 结果
     */
    public int deleteStudentByIds(Long[] ids);

    /**
     * 删除学生管理信息
     * 
     * @param id 学生管理主键
     * @return 结果
     */
    public int deleteStudentById(Long id);

    List<Department> CollegeToDepart(Long collegeId);

    List<Grade> departToGrade(Long department_id);
}
