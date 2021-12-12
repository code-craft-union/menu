import request from '@/utils/request'

export function getMenu(params) {
  return request({
    url: '/api/menu/getByPage',
    params
  })
}

export function createMenu(data) {
  return request({
    url: '/api/menu/add',
    method: 'post',
    data
  })
}

export function updateMenu(data) {
  return request({
    url: '/api/menu/edit',
    method: 'post',
    data
  })
}

export function deleteMenu(id) {
  return request({
    url: `/api/menu/remove/${id}`,
    method: 'post',
  })
}

export function getMenuById(id) {
  return request({
    url: `/api/menu/getById?id=${id}`
  })
}