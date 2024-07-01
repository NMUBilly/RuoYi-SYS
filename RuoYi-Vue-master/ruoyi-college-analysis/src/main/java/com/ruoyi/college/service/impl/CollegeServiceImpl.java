package com.ruoyi.college.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.college.mapper.CollegeMapper;
import com.ruoyi.college.domain.College;
import com.ruoyi.college.service.ICollegeService;

/**
 * 高校管理Service业务层处理
 * 
 * @author B1lly
 * @date 2024-06-12
 */
@Service
public class CollegeServiceImpl implements ICollegeService 
{
    @Autowired
    private CollegeMapper collegeMapper;

    /**
     * 查询高校管理
     * 
     * @param id 高校管理主键
     * @return 高校管理
     */
    @Override
    public College selectCollegeById(Long id)
    {
        return collegeMapper.selectCollegeById(id);
    }

    /**
     * 查询高校管理列表
     * 
     * @param college 高校管理
     * @return 高校管理
     */
    @Override
    public List<College> selectCollegeList(College college)
    {
        return collegeMapper.selectCollegeList(college);
    }

    @Override
    public List<College> list() {
        return collegeMapper.list();
    }

    /**
     * 新增高校管理
     * 
     * @param college 高校管理
     * @return 结果
     */
    @Override
    public int insertCollege(College college)
    {
        return collegeMapper.insertCollege(college);
    }

    /**
     * 修改高校管理
     * 
     * @param college 高校管理
     * @return 结果
     */
    @Override
    public int updateCollege(College college)
    {
        return collegeMapper.updateCollege(college);
    }

    /**
     * 批量删除高校管理
     * 
     * @param ids 需要删除的高校管理主键
     * @return 结果
     */
    @Override
    public int deleteCollegeByIds(Long[] ids)
    {
        return collegeMapper.deleteCollegeByIds(ids);
    }

    /**
     * 删除高校管理信息
     * 
     * @param id 高校管理主键
     * @return 结果
     */
    @Override
    public int deleteCollegeById(Long id)
    {
        return collegeMapper.deleteCollegeById(id);
    }
}
