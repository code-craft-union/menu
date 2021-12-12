import request from '@/utils/request'

export function getIngredients(params) {
  return request({
    url: '/api/ingredients/getByPage',
    params
  })
}

export function createIngredients(data) {
  return request({
    url: '/api/ingredients/add',
    method: 'post',
    data
  })
}

export function updateIngredients(data) {
  return request({
    url: '/api/ingredients/edit',
    method: 'post',
    data
  })
}

export function deleteIngredient(id) {
  return request({
    url: `/api/ingredients/remove/${id}`,
    method: 'post',
  })
}