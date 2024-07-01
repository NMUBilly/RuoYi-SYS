package com.ruoyi.college.mapper;

import java.util.List;
import com.ruoyi.college.domain.College;
import org.springframework.stereotype.Repository;

/**
 * 高校管理Mapper接口
 * 
 * @author B1lly
 * @date 2024-06-12
 */
@Repository
public interface CollegeMapper 
{
    /**
     * 查询高校管理
     * 
     * @param id 高校管理主键
     * @return 高校管理
     */
    public College selectCollegeById(Long id);

    /**
     * 查询高校管理列表
     * 
     * @param college 高校管理
     * @return 高校管理集合
     */
    public List<College> selectCollegeList(College college);

    /**
     * 查询高校管理列表
     *
     * @return
     */
    List<College> list();
    /**
     * 新增高校管理
     * 
     * @param college 高校管理
     * @return 结果
     */
    public int insertCollege(College college);

    /**
     * 修改高校管理
     * 
     * @param college 高校管理
     * @return 结果
     */
    public int updateCollege(College college);

    /**
     * 删除高校管理
     * 
     * @param id 高校管理主键
     * @return 结果
     */
    public int deleteCollegeById(Long id);

    /**
     * 批量删除高校管理
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteCollegeByIds(Long[] ids);
}
