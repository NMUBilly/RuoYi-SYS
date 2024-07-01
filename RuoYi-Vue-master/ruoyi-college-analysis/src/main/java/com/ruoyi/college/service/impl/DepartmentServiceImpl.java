package com.ruoyi.college.service.impl;

import java.util.List;

import com.ruoyi.college.domain.bo.DepartmentBo;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.college.mapper.DepartmentMapper;
import com.ruoyi.college.domain.Department;
import com.ruoyi.college.service.IDepartmentService;

/**
 * 院系管理Service业务层处理
 * 
 * @author Billy
 * @date 2024-06-14
 */
@Service
public class DepartmentServiceImpl implements IDepartmentService 
{
    @Autowired
    private DepartmentMapper departmentMapper;

    /**
     * 查询院系管理
     * 
     * @param id 院系管理主键
     * @return 院系管理
     */
    @Override
    public Department selectDepartmentById(Long id)
    {
        return departmentMapper.selectDepartmentById(id);
    }

    /**
     * 查询院系管理列表
     * 
     * @param department 院系管理
     * @return 院系管理
     */
    @Override
    public List<DepartmentBo> selectDepartmentList(DepartmentBo department)
    {
        return departmentMapper.selectDepartmentList(department);
    }

    /**
     * 新增院系管理
     * 
     * @param department 院系管理
     * @return 结果
     */
    @Override
    public int insertDepartment(Department department)
    {
        return departmentMapper.insertDepartment(department);
    }

    @Override
    public List<Department> list() {
        return departmentMapper.list();
    }

    /**
     * 修改院系管理
     * 
     * @param department 院系管理
     * @return 结果
     */
    @Override
    public int updateDepartment(Department department)
    {
        return departmentMapper.updateDepartment(department);
    }

    /**
     * 批量删除院系管理
     * 
     * @param ids 需要删除的院系管理主键
     * @return 结果
     */
    @Override
    public int deleteDepartmentByIds(Long[] ids)
    {
        return departmentMapper.deleteDepartmentByIds(ids);
    }

    /**
     * 删除院系管理信息
     * 
     * @param id 院系管理主键
     * @return 结果
     */
    @Override
    public int deleteDepartmentById(Long id)
    {
        return departmentMapper.deleteDepartmentById(id);
    }
}
