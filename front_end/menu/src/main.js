import { createApp } from 'vue'
import App from './App.vue'
import VueRouter from '@/router'

import ElementPlus from 'element-plus'
import 'element-plus/dist/index.css'

createApp(App)
  .use(VueRouter)
  .use(ElementPlus)
  .mount('#app')
