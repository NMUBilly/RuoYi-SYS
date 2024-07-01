package com.ruoyi.web.controller.college;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.college.domain.bo.DepartmentBo;
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
import com.ruoyi.college.domain.Department;
import com.ruoyi.college.service.IDepartmentService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 院系管理Controller
 * 
 * @author Billy
 * @date 2024-06-14
 */
@RestController
@RequestMapping("/department/department")
public class DepartmentController extends BaseController
{
    @Autowired
    private IDepartmentService departmentService;

    /**
     * 查询院系管理列表
     */
    @PreAuthorize("@ss.hasPermi('department:department:list')")
    @GetMapping("/list")
    public TableDataInfo list(DepartmentBo department)
    {
        startPage();
        List<DepartmentBo> list = departmentService.selectDepartmentList(department);
        return getDataTable(list);
    }

    /**
     * 查询院系信息，完成下拉列表信息
     */
    @GetMapping("/getDepartments")
    public AjaxResult getDepartments(){
        return super.success(departmentService.list());
    }

    /**
     * 导出院系管理列表
     */
    @PreAuthorize("@ss.hasPermi('department:department:export')")
    @Log(title = "院系管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, DepartmentBo department)
    {
        List<DepartmentBo> list = departmentService.selectDepartmentList(department);
        ExcelUtil<DepartmentBo> util = new ExcelUtil<DepartmentBo>(DepartmentBo.class);
        util.exportExcel(response, list, "院系管理数据");
    }

    /**
     * 获取院系管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('department:department:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(departmentService.selectDepartmentById(id));
    }

    /**
     * 新增院系管理
     */
    @PreAuthorize("@ss.hasPermi('department:department:add')")
    @Log(title = "院系管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Department department)
    {
        return toAjax(departmentService.insertDepartment(department));
    }

    /**
     * 修改院系管理
     */
    @PreAuthorize("@ss.hasPermi('department:department:edit')")
    @Log(title = "院系管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Department department)
    {
        return toAjax(departmentService.updateDepartment(department));
    }

    /**
     * 删除院系管理
     */
    @PreAuthorize("@ss.hasPermi('department:department:remove')")
    @Log(title = "院系管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(departmentService.deleteDepartmentByIds(ids));
    }
}
