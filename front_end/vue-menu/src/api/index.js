import request from '@/utils/request'

export function getDay(data) {
  return request({
    url: '/api/daily/getDailyMenu',
    method: 'post',
    data
  })
}

export function getMenuType() {
  return request({
    url: '/api/dropDown/getDayMenuTypeList'
  })
}

export function setDay(data) {
  return request({
    url: '/api/daily/setDaily',
    method: 'post',
    data
  })
}