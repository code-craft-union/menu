<script setup>
  import { computed } from 'vue'
  import { useRoute } from 'vue-router'
  const route = useRoute()
  const activeIndex = computed(() => route.path)
</script>

<template>
  <el-menu
    :default-active="activeIndex"
    class="el-menu-demo"
    mode="horizontal"
    :router="true"
  >
    <el-menu-item index="/dashboard">首页</el-menu-item>
    <el-menu-item index="/menu">菜单</el-menu-item>
    <el-menu-item index="/ingredients">食材</el-menu-item>
  </el-menu>
</template>

<style lang="scss" scoped>
</style>
