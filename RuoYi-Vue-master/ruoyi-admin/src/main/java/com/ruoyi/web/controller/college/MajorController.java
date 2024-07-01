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
import com.ruoyi.college.domain.Major;
import com.ruoyi.college.service.IMajorService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 专业管理Controller
 * 
 * @author Billy
 * @date 2024-06-19
 */
@RestController
@RequestMapping("/major/major")
public class MajorController extends BaseController
{
    @Autowired
    private IMajorService majorService;

    /**
     * 查询专业管理列表
     */
    @PreAuthorize("@ss.hasPermi('major:major:list')")
    @GetMapping("/list")
    public TableDataInfo list(Major major)
    {
        startPage();
        List<Major> list = majorService.selectMajorList(major);
        return getDataTable(list);
    }

    /**
     * 查询高校信息，完成下拉列表信息
     */
    @GetMapping("/getMajors")
    public AjaxResult getMajors(){
        return super.success(majorService.list());
    }
    /**
     * 导出专业管理列表
     */
    @PreAuthorize("@ss.hasPermi('major:major:export')")
    @Log(title = "专业管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Major major)
    {
        List<Major> list = majorService.selectMajorList(major);
        ExcelUtil<Major> util = new ExcelUtil<Major>(Major.class);
        util.exportExcel(response, list, "专业管理数据");
    }

    /**
     * 获取专业管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('major:major:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(majorService.selectMajorById(id));
    }

    /**
     * 新增专业管理
     */
    @PreAuthorize("@ss.hasPermi('major:major:add')")
    @Log(title = "专业管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Major major)
    {
        return toAjax(majorService.insertMajor(major));
    }

    /**
     * 修改专业管理
     */
    @PreAuthorize("@ss.hasPermi('major:major:edit')")
    @Log(title = "专业管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Major major)
    {
        return toAjax(majorService.updateMajor(major));
    }

    /**
     * 删除专业管理
     */
    @PreAuthorize("@ss.hasPermi('major:major:remove')")
    @Log(title = "专业管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(majorService.deleteMajorByIds(ids));
    }
}
