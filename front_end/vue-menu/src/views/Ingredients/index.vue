<script setup>
  import { ref, computed, unref } from 'vue' 
  import TableComponent from './components/index.vue'
  import { createIngredients, updateIngredients } from '@/api/ingredients'
  import { ElMessageBox } from 'element-plus'

  const formRef = ref(null)
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

  // form
  const tableRef = ref(null)
  const formData = ref({
    name: '',
    price: 0,
    remark: ''
  })
  const rules = {
    name: [
      { required: true, message: '请输入食材名称', trigger: 'blur' }
    ],
    price: [
      { required: true, message: '请输入食材价格', trigger: 'blur' }
    ],
    remark: [
      { required: true, message: '请输入备注', trigger: 'blur' }
    ]
  }

  const resetForm = () => {
    formData.value = {
      name: '',
      price: 0,
      remark: ''
    }
  }
  
  const handle = () => {
    resetForm()
    isEdit.value = false
    dialogVisible.value = true
  }

  const handleUpdate = data => {
    isEdit.value = true
    formData.value = data
    dialogVisible.value = true
  }

  const handleSubmit = () => {
    formRef.value.validate(valid => {
      if (valid) {
        const request = isEdit.value ? updateIngredients : createIngredients
        request(unref(formData)).then(res => {
          dialogVisible.value = false
          tableRef.value.initData()
        })
      }
    })
  }
</script>

<template>
  <div class="control">
    <el-button type="primary" @click="handle">新增食材</el-button>
  </div>
  <table-component ref="tableRef" @update="handleUpdate" />

  <el-dialog
    v-model="dialogVisible"
    :title="dialogName"
    width="500px"
    :before-close="handleClose"
  >
    <el-form
      ref="formRef"
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
</template>

<style lang="scss" scoped>
</style>
