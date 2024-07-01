package com.ruoyi.web.controller.college;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.college.domain.bo.EmployeeBo;
import org.aspectj.weaver.loadtime.Aj;
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
import com.ruoyi.college.domain.StudentEmploymentAnalysis;
import com.ruoyi.college.service.IStudentEmploymentAnalysisService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 就业管理Controller
 * 
 * @author Billy
 * @date 2024-06-22
 */
@RestController
@RequestMapping("/analysis/analysis")
public class StudentEmploymentAnalysisController extends BaseController
{
    @Autowired
    private IStudentEmploymentAnalysisService studentEmploymentAnalysisService;

    /**
     * 查询就业管理列表
     */
    @PreAuthorize("@ss.hasPermi('analysis:analysis:list')")
    @GetMapping("/list")
    public TableDataInfo list(StudentEmploymentAnalysis studentEmploymentAnalysis)
    {
        startPage();
        List<StudentEmploymentAnalysis> list = studentEmploymentAnalysisService.selectStudentEmploymentAnalysisList(studentEmploymentAnalysis);
        return getDataTable(list);
    }

    /**
     * 导出就业管理列表
     */
    @PreAuthorize("@ss.hasPermi('analysis:analysis:export')")
    @Log(title = "就业管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, StudentEmploymentAnalysis studentEmploymentAnalysis)
    {
        List<StudentEmploymentAnalysis> list = studentEmploymentAnalysisService.selectStudentEmploymentAnalysisList(studentEmploymentAnalysis);
        ExcelUtil<StudentEmploymentAnalysis> util = new ExcelUtil<StudentEmploymentAnalysis>(StudentEmploymentAnalysis.class);
        util.exportExcel(response, list, "就业管理数据");
    }

    /**
     * 获取就业管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('analysis:analysis:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(studentEmploymentAnalysisService.selectStudentEmploymentAnalysisById(id));
    }

    /**
     * 新增就业管理
     */
    @PreAuthorize("@ss.hasPermi('analysis:analysis:add')")
    @Log(title = "就业管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody StudentEmploymentAnalysis studentEmploymentAnalysis)
    {
        return toAjax(studentEmploymentAnalysisService.insertStudentEmploymentAnalysis(studentEmploymentAnalysis));
    }

    /**
     * 修改就业管理
     */
    @PreAuthorize("@ss.hasPermi('analysis:analysis:edit')")
    @Log(title = "就业管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody StudentEmploymentAnalysis studentEmploymentAnalysis)
    {
        return toAjax(studentEmploymentAnalysisService.updateStudentEmploymentAnalysis(studentEmploymentAnalysis));
    }

    /**
     * 删除就业管理
     */
    @PreAuthorize("@ss.hasPermi('analysis:analysis:remove')")
    @Log(title = "就业管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(studentEmploymentAnalysisService.deleteStudentEmploymentAnalysisByIds(ids));
    }

    @GetMapping("/countByProvince")
    public AjaxResult countByProvince(){
        return AjaxResult.success(studentEmploymentAnalysisService.countByProvince());
    }

    @GetMapping("/countBySalary")
    public AjaxResult countBySalary(){
        return AjaxResult.success(studentEmploymentAnalysisService.countBySalary());
    }
}
