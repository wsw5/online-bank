<template>
    <el-form ref="loginForm" :model="loginForm" :rules="loginRules" class="login-form">
      <h3 class="title">网上银行系统</h3>
      <el-form-item prop="username">
        <label style="color:white">户名</label>
        <el-input type="text" placeholder="请输入户名" v-model="loginForm.userName" autocomplete="off" prefix-icon="el-icon-user-solid">
        </el-input>
        </el-form-item>
        <el-form-item  prop="pass">
         <label style="color:white">密码</label>
        <el-input type="password" placeholder="请输入密码" v-model="loginForm.password" autocomplete="off" prefix-icon="el-icon-platform-eleme">
        </el-input>
        </el-form-item>
        <el-form-item>
       <el-row>
           <el-button type="primary" round @click="submitForm('loginForm')">登录</el-button>
            <el-button round @click="resetForm('loginForm')">重置</el-button>
       </el-row>   
        </el-form-item>
           
          <router-link class="link" to='/nohome/register'>注册</router-link>
    </el-form>
</template>
<script>
import axios from '../../../http/axiosInit.js'
import router from '../../router.js'
export default {

    data(){
        return{
            loginForm:{
                userName:'',
                password:''
            },
            loginRules:{
                userName:[
                    { required: true, message: '请输入户名', trigger: 'blur' },
                    { min: 3, max: 5, message: '长度在 3 到 5 个字符', trigger: 'blur' }
                ],
                password:[
                    { required: true, message: '请输入密码', trigger: 'blur' },
                    { min: 3, max: 5, message: '长度在 3 到 5 个字符', trigger: 'blur' }
                ]
                     
                
            }
        }
    },
    methods:{
        submitForm(loginForm) {
            this.$refs[loginForm].validate((valid) => {
            if (valid) {  
                axios.post('/in/login',this.loginForm)
                .then(result=>{
                    console.log(result)
                    if(result.code==200){
                    this.$store.dispatch("updateToken",result.data.token)
                    this.$store.dispatch("updateUserName",result.data.name)
                    sessionStorage.setItem('user', this.$store.state.userName) // 保存用户到本地会话
                        router.push('/home/subHome')
                    }
                
                    
                },error=>{
                    console.log("验证失败")
                })
            } else {
            console.log('error submit!!');
            return false;
          }
           });
        },
        resetForm(formName) {
            this.$refs[formName].resetFields();
        }
    }
}
</script>
<style lang="scss" scoped>
 .el-form{
        position: relative;
        border-radius: 6px;
        background-color: rgba(0,0,0,0.4);
        width: 400px;
        padding: 25px 25px 5px 25px;
        margin: auto;
        h3{
            text-align: center;
            color: white;
        }
        .el-form-item{
            margin: 30px;
           color: white;    
           .el-row{
               text-align: -webkit-center;  
           }
        }
        .link{
            margin-right: 20px;
            position: absolute;
            right: 0;
            bottom: 0;
            color: white;
        }
    }
</style>