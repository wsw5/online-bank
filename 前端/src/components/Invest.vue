<template>
<div>
 <el-menu :default-active="this.$route.path" router text-color="#fff"
            active-text-color="#ffd04b" background-color="#545c64" class="el-menu-demo" mode="horizontal">
  
    
    <el-menu-item index="/home/invest/fund">基金</el-menu-item>
    <el-menu-item index="/home/invest/gold">银行账户黄金</el-menu-item>
     <el-menu-item index="/home/invest/manageMoney">理财产品</el-menu-item>
        <el-menu-item index="/home/invest/log">交易记录</el-menu-item>
</el-menu>

<router-view></router-view>
</div>
   

</template>
<script>
export default {
    
}
</script>
<style lang="scss" scoped>
.el-menu-demo{
    .el-menu-item{
        font-size: 20px
    }
}
</style>