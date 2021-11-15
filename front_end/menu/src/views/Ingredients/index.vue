<template>
  <div class="content">
    <div class="control">
      <el-button type="primary" @click="handle">新增食材</el-button>
    </div>
    <Table ref="tableRef" />

    <el-dialog
      v-model="dialogVisible"
      :title="dialogName"
      width="500px"
      :before-close="handleClose"
    >
      <el-form
        ref="i"
        :model="formData"
        :rules="rules"
        label-width="120px"
      >
        <el-form-item label="食材名称" prop="name">
          <el-input v-model="formData.name" />
        </el-form-item>
        <el-form-item label="食材价格" prop="price">
          <el-input-number v-model="formData.price" :precision="2" :step="0.1" />
        </el-form-item>
        <el-form-item label="备注" prop="remark">
          <el-input v-model="formData.remark" type="textarea" />
        </el-form-item>
      </el-form>
      <template #footer>
        <span class="dialog-footer">
          <el-button @click="dialogVisible = false">取消</el-button>
          <el-button type="primary" @click="handleSubmit">确定</el-button>
        </span>
      </template>
    </el-dialog>
  </div>
</template>

<script>
import { computed, defineComponent, ref, reactive, unref } from 'vue'
import Table from './components'
import { ElMessageBox } from 'element-plus'
import { createIngredients } from '@/api/ingredients'
export default defineComponent({
  components: {
    Table
  },
  setup() {
    // dialog
    const i = ref(null)
    const dialogVisible = ref(false)
    const isEdit = ref(false)
    const dialogName = computed(() => isEdit.value ? '编辑食材' : '新增食材')

    const handleClose = (done) => {
      ElMessageBox.confirm('您确定要取消添加食材吗？', {
        confirmButtonText: '确定',
        cancelButtonText: '取消'
      })
        .then(() => {
          done()
        })
        .catch(() => {
          // catch error
        })
    }
    
    const handle = () => {
      dialogVisible.value = true
    }

    // form
    const tableRef = ref(null)
    const formData = ref({
      name: '',
      price: 0,
      remark: ''
    })
    const rules = reactive({
      name: [
        { required: true, message: '请输入食材名称', trigger: 'blur' }
      ],
      price: [
        { required: true, message: '请输入食材价格', trigger: 'blur' }
      ],
      remark: [
        { required: true, message: '请输入备注', trigger: 'blur' }
      ]
    })

    const handleSubmit = () => {
      createIngredients(unref(formData)).then(res => {
        if (res) {
          dialogVisible.value = false
          console.log(tableRef.value)
          tableRef.value.initData()
        }
      })
    }

    return {
      dialogVisible,
      dialogName,
      handleClose,
      handle,
      handleSubmit,
      tableRef,
      formData,
      rules,
      i
    }
  }
})
</script>

<style scoped>
.content .el-form {
  width: 90%
}

.control {
  background-color: #FFFFFF;
  margin-bottom: 20px;
  padding: 20px;
  display: flex;
  justify-content: flex-end;
}
</style>