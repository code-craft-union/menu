<template>
  <el-pagination
    v-model:currentPage="current"
    :page-sizes="pageSizes"
    :page-size="pageSize"
    layout="total, sizes, prev, pager, next, jumper"
    :total="total"
    @size-change="handleSizeChange"
    @current-change="handleCurrentChange"
  />
</template>

<script>
import { computed, defineComponent, reactive, toRefs } from 'vue'
export default defineComponent({
  props: {
    currentPage: {
      type: Number,
      default: 1
    },
    pageSize: {
      type: Number,
      default: 10
    },
    pageSizes: {
      type: Array,
      default() {
        return [50, 100, 150, 200]
      }
    },
    layout: {
      type: String,
      default: 'total, sizes, prev, pager, next, jumper'
    },
    total: {
      type: Number,
      default: 0
    }
  },
  setup(props) {
    const state = reactive({
      current: computed(() => props.currentPage),
      pageSizes: props.pageSizes,
      pageSize: props.pageSize,
      layout: props.layout,
      total: props.total
    })

    const handleSizeChange = () => {}

    const handleCurrentChange = () => {}

    return {
      ...toRefs(state),
      handleSizeChange,
      handleCurrentChange
    }
  }
})
</script>

<style>

</style>