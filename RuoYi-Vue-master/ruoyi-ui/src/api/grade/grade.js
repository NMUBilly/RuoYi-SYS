import request from '@/utils/request'

// 查询班级管理列表
export function listGrade(query) {
  return request({
    url: '/grade/grade/list',
    method: 'get',
    params: query
  })
}

// 查询班级管理详细
export function getGrade(id) {
  return request({
    url: '/grade/grade/' + id,
    method: 'get'
  })
}

// 新增班级管理
export function addGrade(data) {
  return request({
    url: '/grade/grade',
    method: 'post',
    data: data
  })
}

// 修改班级管理
export function updateGrade(data) {
  return request({
    url: '/grade/grade',
    method: 'put',
    data: data
  })
}

// 删除班级管理
export function delGrade(id) {
  return request({
    url: '/grade/grade/' + id,
    method: 'delete'
  })
}
