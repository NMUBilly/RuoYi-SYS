import request from '@/utils/request'

// 查询就业管理列表
export function listAnalysis(query) {
  return request({
    url: '/analysis/analysis/list',
    method: 'get',
    params: query
  })
}

// 查询就业管理详细
export function getAnalysis(id) {
  return request({
    url: '/analysis/analysis/' + id,
    method: 'get'
  })
}

// 新增就业管理
export function addAnalysis(data) {
  return request({
    url: '/analysis/analysis',
    method: 'post',
    data: data
  })
}

// 修改就业管理
export function updateAnalysis(data) {
  return request({
    url: '/analysis/analysis',
    method: 'put',
    data: data
  })
}

// 删除就业管理
export function delAnalysis(id) {
  return request({
    url: '/analysis/analysis/' + id,
    method: 'delete'
  })
}

export function countByProvince(){
return request({
  url: '/analysis/analysis/countByProvince' ,
  method: 'get'
})
}
export function countBySalary()
{
  return request({
    url: '/analysis/analysis/countBySalary',
    method: 'get'
  })
}

