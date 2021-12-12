<script setup>
  import { reactive } from 'vue'
  import { getMenu, deleteMenu, getMenuById } from '@/api/menu'
  import Pagination from '@/components/Pagination/index.vue'
  import { ElMessageBox, ElMessage } from 'element-plus'

  const state = reactive({
    lists: [],
    currentPage: 1,
    pageSize: 10,
    total: 0,
    loading: true
  })
  const emits = defineEmits(['update'])

  const initData = () => {
    state.currentPage = 1
    getData()
  }
  const getData = () => {
    getMenu({
      name: '',
      currentPage: state.currentPage,
      pageSize: state.pageSize
    }).then(res => {
      const { list, pagination: { total } } = res
      state.lists = list
      state.total = total
      state.loading = false
    })
  }
  initData()

  const handleUpdate = id => {
    getMenuById(id).then(res => {
      res.ingredients = res.ingredients.map(item => item.id)
      emits('update', res)
    })
  }

  const handleDel = ({ id, name }) => {
    ElMessageBox.confirm(
      `您确定要删除${name}吗？`,
      '警告',
      {
        confirmButtonText: '确认',
        cancelButtonText: '取消',
        type: '警告',
      }
    )
      .then(() => {
        deleteMenu(id).then(() => {
          ElMessage({
            message: '删除成功！',
            type: 'success',
          })
          initData()
        })
      })
  }

  defineExpose({
    initData
  })
</script>

<template>
  <el-table v-loading="state.loading" :data="state.lists" stripe style="width: 100%">
    <el-table-column prop="name" label="菜谱名称" width="180" align="center">
      <template #default="{row}">
        <a :href="row.link">
          {{ row.name }}
        </a>
      </template>
    </el-table-column>
    <el-table-column prop="remark" label="备注" align="center" />
    <el-table-column label="操作" align="center">
      <template #default="{row}">
        <el-button type="primary" size="mini" @click="handleUpdate(row.id)">编辑</el-button>
        <el-button type="danger" size="mini" @click="handleDel(row)">删除</el-button>
      </template>
    </el-table-column>
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
