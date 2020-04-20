<template>
<div class="el-div">
  <div class="top">

  </div>
    <el-carousel :interval="4000" arrow="always" height="500px">
    <el-carousel-item v-for="item in imgList" :key="item.id">
      <img :src="item.src" />
    </el-carousel-item>
  </el-carousel>
  <hr>
  <div class="demo-image">
  <div class="block">
    <img src="src/image/mony1.jpg"/>
  </div>
  <div class="block">
    <img src="src/image/mony2.jpg"/>

  </div>
  <div class="block">
    <img src="src/image/person.jpg"/>
  </div>
  <div class="block">
    <img src="src/image/person2.jpg"/>
  </div>
</div>
<el-row>
  <el-col :span="6"><h2>网上理财你也可以</h2></el-col>
  <el-col :span="6"><h2>基金产品让你收获满满</h2></el-col>
  <el-col :span="6"><h2>人多力量大</h2></el-col>
  <el-col :span="6"><h2>相互交流尤为重要</h2></el-col>
</el-row>
</div>
</template>
<script>

export default {
    data(){
        return{
            imgList:[
                {"id":0,"name":'finance',"src":"src/image/finance.jpg"},
                {"id":1,"name":'finance2',"src":"src/image/finace2.jpg"},
                {"id":2,"name":'bank2',"src":"src/image/bank2.jpg"},
                {"id":3,"name":'bank3',"src":"src/image/bank3.jpg"},
            ]
        }
    }
}
</script>
<style lang="scss" scoped>
@import "../font/font.css";
* /deep/ .el-col-6 {
    width: 25%;
    text-align: center;
}

.el-div{
    height: 850px;
    width: 100%;
    background-color: gray;
    .top{
      width:100%;
      height:50px;
      background-color: rgb(84, 92, 100);
    }
    .demo-image{

        display: flex;
        justify-content: inherit;
        .block{
            width: 300px;
            height: 200px;
            margin: 0 auto;
            display: flex;
            align-content: initial
        }
        
    }
    h2{
      color:white;
      font-size:18px;
      font-family:"微软雅黑";
    }
    
}
       img{
            width: 100%;
            height: 100%;
        }
.el-carousel{
    width:900px;
    margin: 0 auto;
    .el-carousel__item{
            width: 100%;
        }
}
        


</style>