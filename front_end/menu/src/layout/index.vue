<template>
  <div>
    <Header />
    <div class="global-content">
      <router-view />
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
}
</style>