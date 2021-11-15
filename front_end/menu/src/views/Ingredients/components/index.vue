<template>
  <el-table v-loading="loading" :data="lists" stripe style="width: 100%">
    <el-table-column prop="name" label="食材名称" width="180" align="center" />
    <el-table-column prop="price" label="食材价格" width="180" align="center" />
    <el-table-column prop="remark" label="备注" align="center" />
  </el-table>
  <Pagination :current-page="currentPage" />
</template>

<script>
import { defineComponent, onMounted, reactive, toRefs } from 'vue'
import { getIngredients } from '@/api/ingredients'
import Pagination from '@/components/Pagination'
export default defineComponent({
  components: {
    Pagination
  },
  setup() {
    const state = reactive({
      lists: [],
      currentPage: 1,
      pageSize: 10,
      loading: true
    })

    onMounted(() => {
      initData()
    })

    const initData = () => {
      state.currentPage = 1
      getData()
    }
    const getData = () => {
      getIngredients({
        name: '',
        currentPage: state.currentPage,
        pageSize: state.pageSize
      }).then(res => {
        const { list } = res
        state.lists = list
        state.loading = false
      })
    }

    return {
      ...toRefs(state),
      initData
    }
  }
})
</script>

<style>

</style>