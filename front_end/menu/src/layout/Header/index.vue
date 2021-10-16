<template>
  <div class="global-header">
    <div class="header-content container">
      <el-menu
        :default-active="activeIndex"
        class="el-menu-demo"
        mode="horizontal"
        @select="handleSelect"
        router
      >
        <el-menu-item
          v-for="item in menuLists"
          :key="item.id"
          :index="item.id + ''"
          :path="item.path"
        >
          {{ item.name }}
        </el-menu-item>
      </el-menu>
    </div>
  </div>
</template>

<script>
import { defineComponent, reactive, ref } from 'vue'
import { useRouter } from 'vue-router'
export default defineComponent({
  setup() {
    const menuLists = reactive([
      { id: '/dashboard', name: '食谱' },
      { id: '/ingredients', name: '食材' }
    ])
    const { currentRoute } = useRouter()
    const activeIndex = ref(currentRoute.value.path)

    const handleSelect = () => {
      // console.log(a, b, c)
    }

    return {
      menuLists,
      activeIndex,
      handleSelect
    }
  }
})
</script>

<style scoped>
.global-header {
  background-color: #FFFFFF;
  box-shadow: 0 2px 10px 0 rgba(0, 0, 0, .2);
  position: relative;
}

.header-content {}
</style>