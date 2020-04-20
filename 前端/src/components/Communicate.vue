<template>
    <div class="container">
        <div class="header">
            <el-tooltip placement="bottom" effect="dark">
             <div slot="content">属于{{role | role}}</div>
                <span class="font">{{userName}}</span>
            </el-tooltip>
             <el-button class="button" round @click="postContent">发表</el-button>
        </div>
        <router-view></router-view>
    </div>
</template>
<script>
export default {
    data(){
        return{
            userName:this.$store.state.userName,
            role:this.$store.state.role,
        }
    },
    methods:{
        back(){ 
            this.$router.push("contents")

        },
        postContent(){
            if(this.role==1){
                this.$message.error('您是平民，没有发表权限');
            }else{
                this.$router.push("postContent")
            }
        }
    },
    filters:{
        role:function(params){
            if(params==0){
                return "平民"
            }else{
                return "专家"
            }
        }
    }
}
</script>
<style lang="scss" scoped>
.container{
    width:100%;
    background-color:white;
    .header{
        padding-left:20px;
        height:100px;
        background-color:rgb(84, 92, 100);
        position:relative;
        .button{
                position: absolute;
                top: 25px;
                left: 120px;
        }
         .font{
                font-size:40px;
                color:white;
                font-family:"快乐体";
                position: absolute;
                top: 20px;
            }

    }
   
}
</style>