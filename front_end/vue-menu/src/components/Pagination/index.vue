<script setup>
  import { computed } from 'vue'

  const props = defineProps({
    page: { type: Number, default: 1 },
    size: { type: Number, default: 10 },
    pageSizes: { type: Array, default() {
        return [50, 100, 150, 200]
    }},
    layout: { type: String, default: 'total, sizes, prev, pager, next, jumper'},
    total: { type: Number, default: 0 }
  })
  const emits = defineEmits(['update:page', 'update:size', 'pagination'])

  const current = computed({
    get: () => props.page,
    set: val => emits('update:page', val)
  })

  const size = computed({
    get: () => props.size,
    set: val => emits('update:size', val)
  })

  const handleSizeChange = val => {
    current.value = 1
    emits('pagination', { page: current.value, size: val })
  }
  const handleCurrentChange = val => emits('pagination', { page: val, size: size.value })
</script>

<template>
  <el-pagination
    v-model:currentPage="current"
    :page-sizes="pageSizes"
    :page-size="size"
    layout="total, sizes, prev, pager, next, jumper"
    :total="total"
    @size-change="handleSizeChange"
    @current-change="handleCurrentChange"
  />
</template>

<style lang="scss" scoped>
</style>
