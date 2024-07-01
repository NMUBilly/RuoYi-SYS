package com.ruoyi.college.service;

import java.util.List;

import com.ruoyi.college.domain.College;
import com.ruoyi.college.domain.Department;
import com.ruoyi.college.domain.bo.DepartmentBo;

/**
 * 院系管理Service接口
 * 
 * @author Billy
 * @date 2024-06-14
 */
public interface IDepartmentService 
{
    /**
     * 查询院系管理
     * 
     * @param id 院系管理主键
     * @return 院系管理
     */
    public Department selectDepartmentById(Long id);

    /**
     * 查询院系管理列表
     * 
     * @param department 院系管理
     * @return 院系管理集合
     */
    public List<DepartmentBo> selectDepartmentList(DepartmentBo department);

    /**
     * 新增院系管理
     * 
     * @param department 院系管理
     * @return 结果
     */
    public int insertDepartment(Department department);

    /**
     * 查询院系管理列表
     *
     * @return
     */
    List<Department> list();

    /**
     * 修改院系管理
     * 
     * @param department 院系管理
     * @return 结果
     */
    public int updateDepartment(Department department);

    /**
     * 批量删除院系管理
     * 
     * @param ids 需要删除的院系管理主键集合
     * @return 结果
     */
    public int deleteDepartmentByIds(Long[] ids);

    /**
     * 删除院系管理信息
     * 
     * @param id 院系管理主键
     * @return 结果
     */
    public int deleteDepartmentById(Long id);
}
