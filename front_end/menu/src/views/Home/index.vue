<template>
  <div class="homepage">
    <el-row :gutter="20">
      <el-col :span="18">
        <el-card
          v-for="food in foodLists"
          :key="food.id"
          class="food-item"
          shadow="hover"
        >
          <el-row :gutter="20">
            <el-col :span="6">
              <el-image
                :src="food.image"
                fit="cover"
              />
            </el-col>
            <el-col :span="18">
              <h3>测试</h3>
            </el-col>
          </el-row>
        </el-card>
      </el-col>
      <el-col :span="6">
        <div class="control">
          <el-button type="primary">添加食谱</el-button>
        </div>
      </el-col>
    </el-row>
  </div>
</template>

<script>
import { defineComponent, reactive } from 'vue'
import { getIngredients } from '@/api/ingredients'
export default defineComponent({
  setup() {
    const foodLists = reactive([
      {
        id: 1,
        image: 'https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fv1.qzone.cc%2Fpic%2F201905%2F03%2F14%2F34%2F5ccbe10e40fe0994.jpg%21600x600.jpg&refer=http%3A%2F%2Fv1.qzone.cc&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1636949650&t=500418c7986e113f9654347fe4ec8dde',
        name: '青椒肉丝'
      },
      {
        id: 2,
        image: 'https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fv1.qzone.cc%2Fpic%2F201905%2F03%2F14%2F34%2F5ccbe10e40fe0994.jpg%21600x600.jpg&refer=http%3A%2F%2Fv1.qzone.cc&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1636949650&t=500418c7986e113f9654347fe4ec8dde',
        name: '青椒肉丝'
      }
    ])

    getIngredients().then(res => {
      console.log(res)
    })

    return {
      foodLists
    }
  }
})
</script>

<style>
.homepage {}

.homepage .el-card__body {
  padding: 0
}

.food-item {
  margin-bottom: 20px; 
}

.control {
  background: #FFFFFF;
  padding: 10px;
}
</style>