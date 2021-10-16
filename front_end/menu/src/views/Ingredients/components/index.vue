<template>
  <el-table :data="tableData" stripe style="width: 100%">
    <el-table-column prop="date" label="Date" width="180" align="center" />
    <el-table-column prop="name" label="Name" width="180" align="center" />
    <el-table-column prop="address" label="Address" align="center" />
  </el-table>
</template>

<script>
import { defineComponent, onMounted, reactive, ref } from 'vue'
import { getIngredients } from '@/api/ingredients'
export default defineComponent({
  setup() {
    const tableData = reactive([])
    const currentPage = ref(1)
    const pageSize = ref(10)

    onMounted(() => {
      initData()
    })

    const initData = () => {
      currentPage.value = 1
      getData()
    }
    const getData = () => {
      console.log(1)
      getIngredients({
        name: '',
        currentPage: currentPage.value,
        pageSize: pageSize.value
      }).then(res => {
        console.log(res)
      })
    }

    return {
      currentPage,
      pageSize,
      tableData
    }
  }
})
</script>

<style>

</style>