<template>
    <div>

  <el-container>
      <el-aside class="aside" width="200px">
        <el-col :span="12">
          <el-menu
            :default-active="this.$route.path"
            router
            class="el-menu-vertical-demo"
            background-color="#545c64"
            text-color="#fff"
            active-text-color="#ffd04b">
              <div>
                  <h1 class="log">网上银行</h1>
              </div>
                <el-menu-item index="/home/subHome">
                <i class="fa fa-home"></i>
                <span slot="title" class="font">首页</span>
                </el-menu-item>

                <el-menu-item index="/home/personal" >
                    <template slot="title">
                    <i class="fa fa-user-circle-o"></i>
                    <span class="font">个人信息管理</span>
                    </template>
                </el-menu-item>

                <el-menu-item index="/home/account">
                  <i class="fa fa-cny"></i>
                  <span slot="title" class="font">账户管理</span>
                </el-menu-item>

                <el-menu-item index="/home/invest">
                  <i class="fa fa-money"></i>
                  <span slot="title" class="font">投资业务</span>
                </el-menu-item>

                <el-menu-item index="/home/loan">
                  <i class="fa fa-gg"></i>
                  <span slot="title" class="font">贷款业务</span>
                </el-menu-item>

                <el-menu-item index="/home/communicate/contents">
                 <i class="fa fa-envelope-open-o"></i>
                  <span slot="title" class="font">交流平台</span>
                </el-menu-item>
        </el-menu>
      </el-col>
  </el-aside>
 <el-main>
    <router-view></router-view>
  </el-main>
</el-container>

    </div>
</template>
<script>
export default {
    
}
</script>
<style lang="scss" scoped>

.el-container{
  padding: 0;
    position:absolute;
    top:0;
    bottom:0;
    left:0;
    right: 0;


    .aside {
    height: 100%;
    text-align: center;
    line-height: 200px;
    .el-col-12{
      width: 100%;
      height: 100%;
      .el-menu{
      height: 100%;
      .font{
        font-size: 20px;
      }
      .log{
        font-size: 35px;
        font-family: '快乐体';
        color: #FFBB00;
      }


    }
    
    }

    
  }
  
  .el-main {
    overflow-x: hidden;
    overflow-y: scroll;
    width: 100%;
    background-color:#545c64;
    line-height: 50px;
    margin: 0;
    padding:0;
  }
}

</style>