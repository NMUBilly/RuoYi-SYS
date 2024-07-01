package com.ruoyi.college.mapper;

import java.util.List;

import com.ruoyi.college.domain.Department;
import com.ruoyi.college.domain.Major;
import org.springframework.stereotype.Repository;

/**
 * 专业管理Mapper接口
 * 
 * @author Billy
 * @date 2024-06-19
 */
@Repository
public interface MajorMapper 
{
    /**
     * 查询专业管理
     * 
     * @param id 专业管理主键
     * @return 专业管理
     */
    public Major selectMajorById(Long id);

    /**
     * 查询专业管理列表
     * 
     * @param major 专业管理
     * @return 专业管理集合
     */
    public List<Major> selectMajorList(Major major);

    /**
     * 新增专业管理
     *
     * @param major 专业管理
     * @return 结果
     */
    public int insertMajor(Major major);

    /**
     * 查询院系管理列表
     *
     * @return
     */
    List<Major> list();

    /**
     * 修改专业管理
     * 
     * @param major 专业管理
     * @return 结果
     */
    public int updateMajor(Major major);

    /**
     * 删除专业管理
     * 
     * @param id 专业管理主键
     * @return 结果
     */
    public int deleteMajorById(Long id);

    /**
     * 批量删除专业管理
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteMajorByIds(Long[] ids);
}
