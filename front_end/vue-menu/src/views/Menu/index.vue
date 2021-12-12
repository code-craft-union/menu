<script setup>
  import { ref, computed, unref, nextTick } from 'vue' 
  import TableComponent from './components/index.vue'
  import SelectTable from './components/ingredients.vue'
  import { createMenu, updateMenu } from '@/api/menu'
  import { ElMessageBox } from 'element-plus'

  const formRef = ref(null)
  const dialogVisible = ref(false)
  const selectVisible = ref(false)
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
  const selectRef = ref(null)
  const formData = ref({
    name: '',
    link: '',
    remark: '',
    ingredients: []
  })
  const rules = {
    name: [
      { required: true, message: '请输入食谱名称', trigger: 'blur' }
    ],
    link: [
      { required: true, message: '请输入食谱链接', trigger: 'blur' }
    ],
    remark: [
      { required: true, message: '请输入备注', trigger: 'blur' }
    ],
    ingredients: [
      { required: true, message: '请选择食材', trigger: 'blur' }
    ]
  }

  const resetForm = () => {
    formData.value = {
      name: '',
      link: '',
      remark: '',
      ingredients: []
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
        const request = isEdit.value ? updateMenu : createMenu
        formData.value.ingredients = formData.value.ingredients.map( item => item.id ? item.id : item )
        request(unref(formData)).then(res => {
          dialogVisible.value = false
          tableRef.value.initData()
        })
      }
    })
  }

  const showSelect = () => {
    selectVisible.value = true
    console.log(formData.value.ingredients)
    nextTick(() => {
      selectRef.value.initData()
    })
  }
</script>

<template>
  <div class="control">
    <el-button type="primary" @click="handle">新增菜单</el-button>
  </div>
  <table-component ref="tableRef" @update="handleUpdate" />

  <el-dialog
    v-model="dialogVisible"
    :title="dialogName"
    width="500px"
    :before-close="handleClose"
  >
    <template #default>
      <el-form
        ref="formRef"
        :model="formData"
        :rules="rules"
        label-width="120px"
      >
        <el-form-item label="菜谱名称" prop="name">
          <el-input v-model="formData.name" />
        </el-form-item>
        <el-form-item label="菜谱链接" prop="link">
          <el-input v-model="formData.link" />
        </el-form-item>
        <el-form-item label="备注" prop="remark">
          <el-input v-model="formData.remark" type="textarea" />
        </el-form-item>
        <el-form-item label="食材" prop="remark">
          <el-badge :value="formData.ingredients.length">
            <el-button type="primary" @click="showSelect">点击选择</el-button>
          </el-badge>
        </el-form-item>
      </el-form>
      <el-dialog
        v-model="selectVisible"
        width="50%"
        title="选择食材"
        append-to-body
      >
        <select-table ref="selectRef" v-model:select="formData.ingredients" />
      </el-dialog>
    </template>
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
