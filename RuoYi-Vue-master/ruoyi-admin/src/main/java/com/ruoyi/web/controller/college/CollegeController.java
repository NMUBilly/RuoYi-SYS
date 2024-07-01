package com.ruoyi.web.controller.college;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.college.domain.College;
import com.ruoyi.college.service.ICollegeService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 高校管理Controller
 * 
 * @author B1lly
 * @date 2024-06-12
 */
@RestController
@RequestMapping("/college/college")
public class CollegeController extends BaseController
{
    @Autowired
    private ICollegeService collegeService;

    /**
     * 查询高校管理列表
     */
    @PreAuthorize("@ss.hasPermi('college:college:list')")
    @GetMapping("/list")
    public TableDataInfo list(College college)
    {
        startPage();
        List<College> list = collegeService.selectCollegeList(college);
        return getDataTable(list);
    }
    /**
     * 查询高校信息，完成下拉列表信息
     */
    @GetMapping("/getColleges")
    public AjaxResult getColleges(){
        return super.success(collegeService.list());
    }
    /**
     * 导出高校管理列表
     */
    @PreAuthorize("@ss.hasPermi('college:college:export')")
    @Log(title = "高校管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, College college)
    {
        List<College> list = collegeService.selectCollegeList(college);
        ExcelUtil<College> util = new ExcelUtil<College>(College.class);
        util.exportExcel(response, list, "高校管理数据");
    }

    /**
     * 获取高校管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('college:college:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(collegeService.selectCollegeById(id));
    }

    /**
     * 新增高校管理
     */
    @PreAuthorize("@ss.hasPermi('college:college:add')")
    @Log(title = "高校管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody College college)
    {
        return toAjax(collegeService.insertCollege(college));
    }

    /**
     * 修改高校管理
     */
    @PreAuthorize("@ss.hasPermi('college:college:edit')")
    @Log(title = "高校管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody College college)
    {
        return toAjax(collegeService.updateCollege(college));
    }

    /**
     * 删除高校管理
     */
    @PreAuthorize("@ss.hasPermi('college:college:remove')")
    @Log(title = "高校管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(collegeService.deleteCollegeByIds(ids));
    }
}
