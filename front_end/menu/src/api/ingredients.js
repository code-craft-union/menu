import request from '@/utils/request'

export function getIngredients(params) {
  return request({
    url: '/ingredients/getByPage',
    params
  })
}

export function createIngredients(data) {
  return request({
    url: '/ingredients/add',
    method: 'post',
    data
  })
}