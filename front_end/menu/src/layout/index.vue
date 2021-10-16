<template>
  <div>
    <Header />
    <div class="global-content">
      <div class="container">
        <router-view v-slot="{ Component }">
          <keep-alive>
            <component :is="Component" />
          </keep-alive>
        </router-view>
      </div>
    </div>
  </div>
</template>

<script>
import { defineComponent } from 'vue'
import Header from './Header'
export default defineComponent({
  components: {
    Header
  }
})
</script>

<style scoped>
.global-content {
  min-height: 100vh;
  background-color: #F5F5F5;
  padding-top: 20px;
  width: 100%
}
</style>