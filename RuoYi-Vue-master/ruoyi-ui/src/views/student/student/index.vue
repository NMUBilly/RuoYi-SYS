<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="学生姓名" prop="name">
        <el-input
          v-model="queryParams.name"
          placeholder="请输入学生姓名"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="学生班级" prop="grade">
        <el-input
          v-model="queryParams.gname"
          placeholder="请输入学生班级"
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
          v-hasPermi="['student:student:add']"
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
          v-hasPermi="['student:student:edit']"
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
          v-hasPermi="['student:student:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['student:student:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="studentList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="学生姓名" align="center" prop="name" />
      <el-table-column label="学号" align="center" prop="snum" />
      <el-table-column label="学生性别" align="center" prop="gender" />
      <el-table-column label="所属班级" align="center" prop="grade.name" />
      <el-table-column label="所属专业" align="center" prop="major.name" />
      <el-table-column label="所属学院" align="center" prop="department.name" />
      <el-table-column label="所属高校" align="center" prop="college.name" />
      <el-table-column label="学生电话" align="center" prop="phone" />
      <el-table-column label="学生邮箱" align="center" prop="email" />
      <el-table-column label="学生地址" align="center" prop="address" />
      <el-table-column label="学生简介" align="center" prop="instruction" />
      <el-table-column label="创建时间" align="center" prop="createTime" />
      <el-table-column label="更新时间" align="center" prop="updateTime" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['student:student:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['student:student:remove']"
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

    <!-- 添加或修改学生管理对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="学生姓名" prop="name">
          <el-input v-model="form.name" placeholder="请输入学生姓名"/>
        </el-form-item>
        <el-form-item label="学号" prop="gradeId">
          <el-input v-model="form.snum" placeholder="请输入学号" />
        </el-form-item>
        <el-form-item label="学生性别" prop="gender">
          <el-select v-model="form.gender" placeholder="请选择性别">
          <el-option label="男" value="男"></el-option>
          <el-option label="女" value="女"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="所属高校" prop="collegeId">
          <el-select v-model="form.collegeId" placeholder="请输入高校名称" @change="getCollegeId">
            <el-option
              v-for="item in collegeList"
              :key="item.id"
              :label="item.name"
              :value="item.id"/>
          </el-select>
        </el-form-item>
        <el-form-item label="所属学院" prop="departmentId">
          <el-select v-model="form.departmentId" placeholder="请输入学院名称" @change="getDepartmentId">
            <el-option
              v-for="item in departmentList"
              :key="item.id"
              :label="item.name"
              :value="item.id"/>
          </el-select>
        </el-form-item>
        <el-form-item label="所属班级" prop="gradeId">
          <el-select v-model="form.gradeId" placeholder="请输入班级名称">
            <el-option
              v-for="item in gradeList"
              :key="item.id"
              :label="item.name"
              :value="item.id"/>
          </el-select>
        </el-form-item>
        <el-form-item label="学生电话" prop="phone">
          <el-input v-model="form.phone" placeholder="请输入学生电话" />
        </el-form-item>
        <el-form-item label="学生邮箱" prop="email">
          <el-input v-model="form.email" placeholder="请输入学生邮箱" />
        </el-form-item>
        <el-form-item label="学生地址" prop="address">
          <el-input v-model="form.address" placeholder="请输入学生地址" />
        </el-form-item>
        <el-form-item label="学生简介" prop="instruction">
          <el-input v-model="form.instruction" placeholder="请输入学生简介" />
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
import {
  listStudent,
  getStudent,
  delStudent,
  addStudent,
  updateStudent,
  getDepartments,
  getGrades
} from "@/api/student/student";
import {getColleges} from "@/api/college/college";

export default {
  name: "Student",
  data() {
    return {
      gradeList:[],
      departmentList: [],
      collegeList: [],
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
      // 学生管理表格数据
      studentList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        name: null,
        gname: null,
      },
      // 表单参数
      form: {
        department: {
          id: null,
          name: null,
        },
        grade:{
          id: null,
          name: null,
        },
        collegeId: null,
        departmentId: null,
        gradeId: null,
      },
      selectedCollegeId: '',
      selectedDepartmentId: '',// 用于存储并可以在任何地方使用的变量
      // watch: {
      //   'form.collegeId': {
      //     handler(newVal) {
      //       setTimeout(() => {
      //         this.selectedCollegeId = newVal;
      //         this.getDepartments(newVal);
      //       }, 0);
      //     }
      //   }
      // },


      // 表单校验
      rules: {
        name: [
          { required: true, message: "学生姓名不能为空", trigger: "blur" }
        ],
        collegeId: [
          { required: true, message: "学生姓名不能为空", trigger: "blur" }
        ],
        departmentId: [
          { required: true, message: "学生姓名不能为空", trigger: "blur" }
        ],
        snum: [
          { required: true, message: "学号不能为空", trigger: "blur" }
        ],
        gender: [
          { required: true, message: "学生性别不能为空", trigger: "blur" }
        ],
        gradeId: [
          { required: true, message: "班级外键不能为空", trigger: "blur" }
        ],
        phone: [
          { required: true, message: "学生电话不能为空", trigger: "blur" }
        ],
        email: [
          { required: true, message: "学生邮箱不能为空", trigger: "blur" }
        ],
        address: [
          { required: true, message: "学生地址不能为空", trigger: "blur" }
        ],
        instruction: [
          { required: true, message: "学生简介不能为空", trigger: "blur" }
        ],
      }
    };
  },
  created() {
    this.getList();
    this.listColleges();
  },
  methods: {
    listColleges(){
      getColleges().then(response => {
        this.collegeList = response.data
      })
    },
    getCollegeId(selectedCollegeId) {
      getDepartments(selectedCollegeId).then(response => {
        this.departmentList = response.data;
      });
    },
    getDepartmentId(selectedDepartmentId){
      getGrades(selectedDepartmentId).then(response => {
        console.log(response.data)
        this.gradeList = response.data;
      })
    },
    /** 查询学生管理列表 */
    getList() {
      this.loading = true;
      listStudent(this.queryParams).then(response => {
        this.studentList = response.rows;
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
        snum:null,
        name: null,
        gender: null,
        gradeId: null,
        phone: null,
        email: null,
        address: null,
        collegeId: null,
        departmentId: null,
        password: null,
        instruction: null,
        deleted: null,
        dId:null,
        createTime: null,
        updateTime: null,
        department:{
          id: null,
          name: null,
        },
        grade: {
          id: null,
          name: null,
        }
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
      this.title = "添加学生管理";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getStudent(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改学生管理";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateStudent(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addStudent(this.form).then(response => {
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
      this.$modal.confirm('是否确认删除学生管理编号为"' + ids + '"的数据项？').then(function() {
        return delStudent(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('student/student/export', {
        ...this.queryParams
      }, `student_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
