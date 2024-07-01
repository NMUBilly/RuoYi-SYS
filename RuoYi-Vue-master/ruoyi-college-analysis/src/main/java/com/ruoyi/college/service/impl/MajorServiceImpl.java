package com.ruoyi.college.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.college.mapper.MajorMapper;
import com.ruoyi.college.domain.Major;
import com.ruoyi.college.service.IMajorService;

/**
 * 专业管理Service业务层处理
 * 
 * @author Billy
 * @date 2024-06-19
 */
@Service
public class MajorServiceImpl implements IMajorService 
{
    @Autowired
    private MajorMapper majorMapper;

    /**
     * 查询专业管理
     * 
     * @param id 专业管理主键
     * @return 专业管理
     */
    @Override
    public Major selectMajorById(Long id)
    {
        return majorMapper.selectMajorById(id);
    }

    /**
     * 查询专业管理列表
     * 
     * @param major 专业管理
     * @return 专业管理
     */
    @Override
    public List<Major> selectMajorList(Major major)
    {
        return majorMapper.selectMajorList(major);
    }

    /**
     * 新增专业管理
     * 
     * @param major 专业管理
     * @return 结果
     */
    @Override
    public int insertMajor(Major major)
    {
        return majorMapper.insertMajor(major);
    }

    @Override
    public List<Major> list() {
        return majorMapper.list();
    }

    /**
     * 修改专业管理
     * 
     * @param major 专业管理
     * @return 结果
     */
    @Override
    public int updateMajor(Major major)
    {
        return majorMapper.updateMajor(major);
    }

    /**
     * 批量删除专业管理
     * 
     * @param ids 需要删除的专业管理主键
     * @return 结果
     */
    @Override
    public int deleteMajorByIds(Long[] ids)
    {
        return majorMapper.deleteMajorByIds(ids);
    }

    /**
     * 删除专业管理信息
     * 
     * @param id 专业管理主键
     * @return 结果
     */
    @Override
    public int deleteMajorById(Long id)
    {
        return majorMapper.deleteMajorById(id);
    }
}
