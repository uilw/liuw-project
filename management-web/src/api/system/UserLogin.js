import request from '@/utils/request'

const BASE_URL = '/login'

export function login(data) {
  return request({
    url: `${BASE_URL}/user`,
    method: 'post',
    responseType: 'json',
    headers: { 'content-Type': 'application/json' },
    data: data
  })
}

export function logout() {
  return request({
    url: '/vue-admin-template/user/logout',
    method: 'post'
  })
}

