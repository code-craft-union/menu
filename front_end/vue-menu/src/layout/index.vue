<script setup>
  import LayoutHeader from './Header/index.vue'
</script>

<template>
  <layout-header />
  <div class="app-main">
    <router-view />
  </div>
</template>

<style lang="scss" scoped>
.app-main {
  width: 1200px;
  margin-left: auto;
  margin-right: auto;
}
</style>
