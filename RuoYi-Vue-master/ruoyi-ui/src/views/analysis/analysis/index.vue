<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="学生外键" prop="studentId">
        <el-input
          v-model="queryParams.studentId"
          placeholder="请输入学生外键"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['analysis:analysis:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['analysis:analysis:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['analysis:analysis:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['analysis:analysis:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="analysisList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="学生姓名" align="center" prop="student.name" />
      <el-table-column label="公司名称" align="center" prop="company" />
      <el-table-column label="公司规模" align="center" prop="scale" />
      <el-table-column label="公司类型" align="center" prop="type" />
      <el-table-column label="职位" align="center" prop="position" />
      <el-table-column label="薪资" align="center" prop="salary" />
      <el-table-column label="城市" align="center" prop="address" />
      <el-table-column label="省会城市" align="center" prop="province" />
      <el-table-column label="更新时间" align="center" prop="updateTime" />
      <el-table-column label="所属班级" align="center" prop="grade.name" />
      <el-table-column label="所属专业" align="center" prop="major.name" />
      <el-table-column label="所属学院" align="center" prop="department.name" />
      <el-table-column label="所属高校" align="center" prop="college.name" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['analysis:analysis:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['analysis:analysis:remove']"
          >删除</el-button>
        </template>
      </el-table-column>
    </el-table>

    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 添加或修改就业管理对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="学生外键" prop="studentId">
          <el-input v-model="form.studentId" placeholder="请输入学生外键" />
        </el-form-item>
        <el-form-item label="公司名称" prop="company">
          <el-input v-model="form.company" placeholder="请输入公司名称" />
        </el-form-item>
        <el-form-item label="公司规模" prop="scale">
          <el-input v-model="form.scale" placeholder="请输入公司规模" />
        </el-form-item>
        <el-form-item label="职位" prop="position">
          <el-input v-model="form.position" placeholder="请输入职位" />
        </el-form-item>
        <el-form-item label="薪资" prop="salary">
          <el-input v-model="form.salary" placeholder="请输入薪资" />
        </el-form-item>
        <el-form-item label="城市" prop="address">
          <el-input v-model="form.address" placeholder="请输入城市" />
        </el-form-item>
        <el-form-item label="省会城市" prop="province">
          <el-input v-model="form.province" placeholder="请输入省会城市" />
        </el-form-item>
        <el-form-item label="就业行业" prop="industry">
          <el-input v-model="form.industry" placeholder="请输入就业行业" />
        </el-form-item>
        <el-form-item label="入职时间" prop="startTime">
          <el-input v-model="form.startTime" placeholder="请输入入职时间" />
        </el-form-item>
        <el-form-item label="离职时间" prop="endTime">
          <el-input v-model="form.endTime" placeholder="请输入离职时间" />
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listAnalysis, getAnalysis, delAnalysis, addAnalysis, updateAnalysis } from "@/api/analysis/analysis";

export default {
  name: "Analysis",
  data() {
    return {
      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 就业管理表格数据
      analysisList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        studentId: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        studentId: [
          { required: true, message: "学生外键不能为空", trigger: "blur" }
        ],
        company: [
          { required: true, message: "公司名称不能为空", trigger: "blur" }
        ],
        scale: [
          { required: true, message: "公司规模不能为空", trigger: "blur" }
        ],
        type: [
          { required: true, message: "公司类型不能为空", trigger: "change" }
        ],
        position: [
          { required: true, message: "职位不能为空", trigger: "blur" }
        ],
        salary: [
          { required: true, message: "薪资不能为空", trigger: "blur" }
        ],
        address: [
          { required: true, message: "城市不能为空", trigger: "blur" }
        ],
        province: [
          { required: true, message: "省会城市不能为空", trigger: "blur" }
        ],
        industry: [
          { required: true, message: "就业行业不能为空", trigger: "blur" }
        ],
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询就业管理列表 */
    getList() {
      this.loading = true;
      listAnalysis(this.queryParams).then(response => {
        this.analysisList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.form = {
        id: null,
        studentId: null,
        company: null,
        scale: null,
        type: null,
        position: null,
        salary: null,
        address: null,
        province: null,
        industry: null,
        startTime: null,
        endTime: null,
        createTime: null,
        updateTime: null,
        deleted: null
      };
      this.resetForm("form");
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1;
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm("queryForm");
      this.handleQuery();
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.id)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加就业管理";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getAnalysis(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改就业管理";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateAnalysis(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addAnalysis(this.form).then(response => {
              this.$modal.msgSuccess("新增成功");
              this.open = false;
              this.getList();
            });
          }
        }
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const ids = row.id || this.ids;
      this.$modal.confirm('是否确认删除就业管理编号为"' + ids + '"的数据项？').then(function() {
        return delAnalysis(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('analysis/analysis/export', {
        ...this.queryParams
      }, `analysis_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
