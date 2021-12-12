<script setup>
  import { reactive, ref, computed, nextTick } from 'vue'
  import { getIngredients } from '@/api/ingredients'
  import Pagination from '@/components/Pagination/index.vue'

  const state = reactive({
    lists: [],
    currentPage: 1,
    pageSize: 10,
    total: 0,
    loading: true,
    isInit: false
  })
  const props = defineProps({
    select: {
      type: Array,
      required: true,
      default() {
        return []
      }
    }
  })
  const emits = defineEmits(['update:select'])
  const selectLists = computed({
    get: () => props.select,
    set: val => emits('update:select', val)
  })

  const initData = () => {
    state.currentPage = 1
    state.isInit = true
    nextTick(() => {
      table.value.clearSelection()
      state.isInit = false
    })
    getData()
  }
  const getData = () => {
    getIngredients({
      name: '',
      currentPage: state.currentPage,
      pageSize: state.pageSize
    }).then(res => {
      const { list, pagination: { total } } = res
      state.lists = list
      state.total = total
      nextTick(() => initSelect())
      state.loading = false
    })
  }

  const table = ref(null)
  const initSelect = () => {
    const temp = selectLists.value.map(item => typeof item === 'number' ? item : item.id)
    state.lists.map(item => {
      if (temp.indexOf(item.id) !== -1) {
        state.isInit = true
        table.value.toggleRowSelection(item, true)
      }
    })
  }

  const handleSelectionChange = val => {
    if (state.isInit) {
      state.isInit = false
      return false
    }
    selectLists.value = val
  }

  const getRowKey = row => row.id
  
  initData()
  defineExpose({
    initData
  })
</script>

<template>
  <el-table
    ref="table"
    v-loading="state.loading"
    :data="state.lists"
    stripe
    style="width: 100%"
    :row-key="getRowKey"
    @selection-change="handleSelectionChange"
  >
    <el-table-column type="selection" width="55" :reserve-selection="true" />
    <el-table-column prop="name" label="食材名称" width="180" align="center" />
    <el-table-column prop="price" label="食材价格" width="180" align="center" />
    <el-table-column prop="remark" label="备注" align="center" />
  </el-table>
  <Pagination
    v-model:page="state.currentPage"
    v-model:size="state.pageSize"
    :total="state.total"
    @pagination="getData"
  />
</template>

<style lang="scss" scoped>
</style>
