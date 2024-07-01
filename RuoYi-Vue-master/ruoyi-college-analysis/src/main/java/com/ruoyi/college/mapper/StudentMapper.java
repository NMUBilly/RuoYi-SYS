package com.ruoyi.college.mapper;

import java.util.List;

import com.ruoyi.college.domain.Department;
import com.ruoyi.college.domain.Grade;
import com.ruoyi.college.domain.Major;
import com.ruoyi.college.domain.Student;
import org.springframework.stereotype.Repository;

/**
 * 学生管理Mapper接口
 * 
 * @author Billy
 * @date 2024-06-21
 */
@Repository
public interface StudentMapper 
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
     * 删除学生管理
     * 
     * @param id 学生管理主键
     * @return 结果
     */
    public int deleteStudentById(Long id);

    /**
     * 批量删除学生管理
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteStudentByIds(Long[] ids);

    List<Department> collegeToDepart(Long collegeId);
    List<Grade> departToGrade(Long department_id);
}
