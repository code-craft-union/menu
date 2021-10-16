import { createRouter, createWebHashHistory } from 'vue-router'
import Layout from '@/layout'

const routes = [
  {
    path: '/',
    name: 'Index',
    redirect: '/dashboard',
    component: Layout,
    children: [
      {
        path: 'dashboard',
        name: 'Dashboard',
        component: () => import('@/views/Home')
      },
      {
        path: 'ingredients',
        name: 'Ingredients',
        component: () => import('@/views/Ingredients')
      },
      {
        path: 'detail',
        name: 'Detail',
        component: () => import('@/views/Detail')
      }
    ]
  }
]

const router = createRouter({
  history: createWebHashHistory(),
  routes
})

export default router