import request from '@/utils/request'

// 查询学生管理列表
export function listStudent(query) {
  return request({
    url: '/student/student/list',
    method: 'get',
    params: query
  })
}

// 查询学生管理详细
export function getStudent(id) {
  return request({
    url: '/student/student/' + id,
    method: 'get'
  })
}

// 新增学生管理
export function addStudent(data) {
  return request({
    url: '/student/student',
    method: 'post',
    data: data
  })
}

// 修改学生管理
export function updateStudent(data) {
  return request({
    url: '/student/student',
    method: 'put',
    data: data
  })
}

// 删除学生管理
export function delStudent(id) {
  return request({
    url: '/student/student/' + id,
    method: 'delete'
  })
}
export function getColleges() {
  return request({
    url: '/college/college/getColleges',
    method: 'get',
  })
}
export function getDepartments(college_id) {
  return request({
    url: '/student/student/collegeToDepart',
    method: 'get',
    params: {
      college_id: college_id
    }
  })
}
export function getGrades(department_id) {
  return request({
    url: '/student/student/departToGrade',
    method: 'get',
    params: {
      department_id: department_id
    }
  })
}


