<script setup>
  import { ref, nextTick } from 'vue'
  import { getDay, getMenuType, setDay } from '@/api'
  import SelectTable from './components/menus.vue'
  const value = ref(new Date(Date.now() - (3600000 * 24)))
  const dialogVisible = ref(false)
  const menuLists = ref([])
  const menuType = ref([])
  const selectVisible = ref(false)
  const selectRef = ref(null)
  const formData = ref({
    day: '2021-12-11',
    dayMenuType: '',
    menus: []
  })
  const rules = {}

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

  const choiseDay = day => {
    console.log(day)
  }

  const handleMenu = () => {
    dialogVisible.value = true
  }

  const handleSubmit = () => {
    formData.value.menus = formData.value.menus.map(item => item.id)
    setDay(formData.value).then(res => {
      getData()
    })
  }

  const getData = () => {
    getDay({ day: '2021-12-11' }).then(res => {
      menuLists.value = res
      return getMenuType()
    }).then(res => {
      menuType.value = res
    })
  }
  getData()

  const showSelect = () => {
    selectVisible.value = true
    nextTick(() => {
      selectRef.value.initData()
    })
  }

  const getTitle = type => {
    switch(type) {
      case 'Breakfast':
        return '早餐'
      case 'Lunch':
        return '午餐'
      default:
        return '晚餐'
    }
  }
</script>

<template>
  <div class="home-container">
    <el-row :gutter="20">
      <el-col :span="12">
        <el-calendar v-model="value">
          <template #dateCell="{ data }">
            <div @click="choiseDay" style="height: 100%; width: 100%">
              <p>{{ data.date.getDate() }}</p>
            </div>
          </template>
        </el-calendar>
      </el-col>
      <el-col :span="12">
        <div class="menu-container">
          <div class="control clearfix">
            <el-button type="primary" @click="handleMenu">选择菜单</el-button>
          </div>
          <div v-if="menuLists.length > 0" class="menu-content">
            <div v-for="item in menuLists" :key="item.dayMenuType">
              <h3>{{ getTitle(item.dayMenuType) }}</h3>
              <div class="menu-item">
                <p v-for="i in item.menuList" :key="i.id">{{ i.name }}</p>
              </div>
            </div>
          </div>
          <el-empty v-else description="今日暂无食谱"></el-empty>
        </div>
      </el-col>
    </el-row>
  </div>
  <el-dialog
    v-model="dialogVisible"
    title="选择菜单"
    :before-close="handleClose"
  >
    <template #default>
      <el-form
        ref="formRef"
        :model="formData"
        :rules="rules"
        label-width="120px"
      >
        <el-form-item label="类型" prop="dayMenuType">
          <el-select v-model="formData.dayMenuType" placeholder="请选择类型">
            <el-option
              v-for="item in menuType"
              :key="item.id"
              :label="item.text"
              :value="item.id"
            />
          </el-select>
        </el-form-item>
        <el-form-item label="食谱" prop="menus">
          <el-badge :value="formData.menus.length">
            <el-button type="primary" @click="showSelect">点击选择</el-button>
          </el-badge>
        </el-form-item>
      </el-form>
      <el-dialog
        v-model="selectVisible"
        width="50%"
        title="选择食谱"
        append-to-body
      >
        <select-table ref="selectRef" v-model:select="formData.menus" />
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
.home-container {
  padding: 20px 0;
  box-sizing: border-box;
  .menu-container {
    position: relative;
    height: 100%;
    background-color: #FFFFFF;
    padding: 20px;
    box-sizing: border-box;
    .control {
      .el-button {
        float: right;
      }
    }
    .el-empty {
      position: absolute;
      top: 50%;
      left: 50%;
      transform: translate(-50%, -50%);
    }
  }
}

</style>
