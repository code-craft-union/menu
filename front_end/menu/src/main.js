import { createApp } from 'vue'
import App from './App.vue'
import VueRouter from '@/router'
import 'normalize.css'
import './styles/index.css'

import ElementPlus from 'element-plus'
import 'element-plus/dist/index.css'

createApp(App)
  .use(VueRouter)
  .use(ElementPlus)
  .mount('#app')
