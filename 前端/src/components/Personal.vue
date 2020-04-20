<template>
<div class="container">
   
  <div class="aside" >
    <span class="span">
       <el-avatar icon="el-icon-user-solid"></el-avatar>
    </span>
    
    <span class="span">{{form.role}}</span>
    <span class="span" v-text="form.userName">
      户名：{{this.form.userName}}
    </span>
    <span class="span">
      真实姓名：{{this.form.realName}}
    </span>
    <span class="span">
     年龄：{{this.form.age}}
    </span>
    <span class="span">
     状态：{{this.form.status}}
    </span>
  </div>
  <div class="main">
    <span class="h1">基本信息</span>
    <div class="inContainer"> 
      <div class="button">
         <span class="h2">个人</span>
          <el-button type="info" icon="el-icon-edit" @click="dialogFormVisible = true">修改</el-button>
      </div>
     
      <el-row :gutter="18">
      <el-col :span="8"><div class="grid-content bg-purple">
      <span class="span">电话号码:{{this.form.phoneNumber}}</span></div></el-col>
      <el-col :span="8"><div class="grid-content bg-purple">
      <span class="span">地址:{{form.address}}</span></div></el-col>
      <el-col :span="8"><div class="grid-content bg-purple">
      <span class="span">邮箱:{{form.email}}</span></div></el-col>
    </el-row>
    <div class="button">
     <span class="h2">紧急联系人一</span>
      <el-button type="info" icon="el-icon-edit" @click="dialogFormEemergency1 = true">修改</el-button>
    </div>
    <el-row :gutter="18">
      <el-col :span="4"><div class="grid-content bg-purple">
      <span class="span">姓名:{{form.emergencyOneName}}</span></div></el-col>
      <el-col :span="6"><div class="grid-content bg-purple">
      <span class="span">地址:{{form.emergencyOneAddress}}</span></div></el-col>
      <el-col :span="8"><div class="grid-content bg-purple">
        <span class="span">身份证:{{form.emergencyOneIdNumber}}</span></div></el-col>
        <el-col :span="6"><div class="grid-content bg-purple">
      <span class="span">电话号码:{{form.emergencyTwoPhone}}</span></div></el-col>
    </el-row>
    <div class="button">
        <span class="h2">紧急联系人二</span>
        <el-button type="info" icon="el-icon-edit" @click="dialogFormEemergency2 = true">修改</el-button>
    </div>
    <el-row :gutter="18">
      <el-col :span="4"><div class="grid-content bg-purple">
      <span class="span">姓名:{{form.emergencyTwoName}}</span></div></el-col>
      <el-col :span="6"><div class="grid-content bg-purple">
      <span class="span">地址:{{form.emergencyTwoAddress}}</span></div></el-col>
      <el-col :span="8"><div class="grid-content bg-purple">
        <span class="span">身份证:{{form.emergencyTwoIdNumber}}</span></div></el-col>
        <el-col :span="6"><div class="grid-content bg-purple">
      <span class="span">电话号码:{{form.emergencyTwoPhone}}</span></div></el-col>
    </el-row>
    </div>
   
   
    </div>

          <el-dialog title="个人" :visible.sync="dialogFormVisible">
            <el-form :model="form" :rules="rules">
              <el-form-item label="电话号码" :label-width="formLabelWidth">
                <el-input v-model="form.phoneNumber" autocomplete="off"></el-input>
              </el-form-item>
              <el-form-item label="邮箱" :label-width="formLabelWidth">
                <el-input v-model="form.email" autocomplete="off"></el-input>
              </el-form-item>
              <el-form-item label="地址" :label-width="formLabelWidth">
                <el-input v-model="form.address" autocomplete="off"></el-input>
              </el-form-item>
            </el-form>
            <div slot="footer" class="dialog-footer">
              <el-button @click="dialogFormVisible = false">取 消</el-button>
              <el-button type="primary" @click="personEdit">确 定</el-button>
            </div>
          </el-dialog>

           <el-dialog title="紧急联系人一" :visible.sync="dialogFormEemergency1">
            <el-form :model="form" :rules="rules">
              <el-form-item label="姓名" :label-width="formLabelWidth">
                <el-input v-model="form.emergencyOneName" autocomplete="off"></el-input>
              </el-form-item>
              <el-form-item label="电话号码" :label-width="formLabelWidth">
                <el-input v-model="form.emergencyOnePhone" autocomplete="off"></el-input>
              </el-form-item>
              <el-form-item label="地址" :label-width="formLabelWidth">
                <el-input v-model="form.emergencyOneAddress" autocomplete="off"></el-input>
              </el-form-item>
               <el-form-item label="身份证号" :label-width="formLabelWidth">
                <el-input v-model="form.emergencyOneIdNumber" autocomplete="off"></el-input>
              </el-form-item>
            </el-form>
            <div slot="footer" class="dialog-footer">
              <el-button @click="dialogFormEemergency1 = false">取 消</el-button>
              <el-button type="primary" @click="closePerson1">确 定</el-button>
            </div>
          </el-dialog>
          <el-dialog title="紧急联系人二" :visible.sync="dialogFormEemergency2">
            <el-form :model="form" :rules="rules">
              <el-form-item label="姓名" :label-width="formLabelWidth">
                <el-input v-model="form.emergencyTwoName" autocomplete="off"></el-input>
              </el-form-item>
              <el-form-item label="电话号码" :label-width="formLabelWidth">
                <el-input v-model="form.emergencyTwoPhone" autocomplete="off"></el-input>
              </el-form-item>
              <el-form-item label="地址" :label-width="formLabelWidth">
                <el-input v-model="form.emergencyTwoAddress" autocomplete="off"></el-input>
              </el-form-item>
               <el-form-item label="身份证号" :label-width="formLabelWidth">
                <el-input v-model="form.emergencyTwoIdNumber" autocomplete="off"></el-input>
              </el-form-item>
            </el-form>
            <div slot="footer" class="dialog-footer">
              <el-button @click="dialogFormEemergency2 = false">取 消</el-button>
              <el-button type="primary" @click="closePerson2">确 定</el-button>
            </div>

          </el-dialog>

</div>
  

</template>
<script>
// import Mock from '../mock/index.js'
import axios from '../../http/axiosInit.js';
export default {
    data(){
      //校验电话号码
        var telCheck = (rule, value, callback) => {
            if (value === '') {
                return callback(new Error('电话号码是必须的'))
            } else if (!Number.isInteger(value)) {
                return callback(new Error('电话号码必须是数字'))
            } else if (value.toString().length !== 11) {
                return callback(new Error('电话号码必须是11位数字'))
            } else {
                callback()
            }
        };
      return{
       
        dialogFormVisible: false,
        dialogFormEemergency1:false,
        dialogFormEemergency2:false,
        formLabelWidth: '120px',
        form: {
          uId:this.$store.state.userId,
           userName:'',
            realName:'',
            age:'',
            status:'',
            role:'',
          phoneNumber:'',
          address:'',
          email:'',
          emergencyOneName:'',
          emergencyOnePhone:'',
          emergencyOneAddress:'',
          emergencyOneIdNumber:'',
          emergencyTwoName:'',
          emergencyTwoPhone:'',
          emergencyTwoAddress:'',
          emergencyTwoIdNumber:''          
        },
        rules:{
            email:[
                  { required: true, message: '请输入邮箱地址', trigger: 'blur' },
                  { type: 'email', message: '请输入正确的邮箱地址', trigger: ['blur', 'change'] }
            ],
            phone:[
                    { validator: telCheck, trigger: 'blur' }
            ]
        },
        
      }
    },
   created(){
        this.getUser()
    },
    methods:{
    getUser(){
    var userName=this.$store.state.userName
	console.log(userName)
        axios.get('/in/findOne',{params:{userName:userName}}).then(result=>{
	
          console.log(result)
          if(result.code==200){
             var dataArray=result.data
	     console.log("个人管理系统")
          this.form.userName=dataArray.userName
          this.form.realName=dataArray.realName
          this.form.age=dataArray.age
          if(dataArray.role==0){
            this.form.role='平民'
          }else{
            this.form.role='专家'
            this.$store.dispatch("updateRole",dataArray.role)
          }
          if(dataArray.status==0){
              this.form.status='可用状态'
          }else{
              this.form.status='禁用状态'
              this.$store.dispatch("updateStatus",dataArray.status)
          }
        
          this.form.phoneNumber=dataArray.phoneNumber
          this.form.address=dataArray.address
          this.form.email=dataArray.email
          this.form.emergencyOneName=dataArray.emergencyOneName
          this.form.emergencyTwoName=dataArray.emergencyTwoName
          this.form.emergencyOnePhone=dataArray.emergencyOnePhone
          this.form.emergencyTwoPhone=dataArray.emergencyTwoPhone
          this.form.emergencyOneAddress=dataArray.emergencyOneAddress
          this.form.emergencyTwoAddress=dataArray.emergencyTwoAddress
          this.form.emergencyOneIdNumber=dataArray.emergencyOneIdNumber
           this.form.emergencyTwoIdNumber=dataArray.emergencyTwoIdNumber
          }
         
        },error=>{
          console.log(error)
        })
    },
      personEdit(){
        axios.put("/in/updateUser",this.form).then(result=>{
         console.log(result)
         if(result.code==200){
           this. dialogFormVisible=false
            this.$message({
              showClose: true,
              message: result.msg,
              type: 'success'
            });
         }else{
           this. dialogFormVisible=false
            this.$message({
              showClose: true,
              message: result.msg,
              type: 'error'
            });
         }
        },error=>{

        })
      },
      closePerson1(){
        axios.put('/in/updateUser',this.form).then(result=>{
          if(result.code==200){
            this.dialogFormEemergency1=false
            this.$message({
              showClose: true,
              message: result.msg,
              type: 'success'
            });
          }else{
            this.dialogFormEemergency1=false
            this.$message({
              showClose: true,
              message: result.msg,
              type: 'error'
            });
          }
        },error=>{

        })
      },
      closePerson2(){
        axios.put('/in/updateUser',this.form).then(result=>{
          if(result.code==200){
            this.dialogFormEemergency2=false
            this.$message({
              showClose: true,
              message:result.msg,
              type: 'success'
            });
          }else{
            this.dialogFormEemergency2=false
            this.$message({
              showClose: true,
              message: result.msg,
              type: 'error'
            });
          }
        },error=>{

        })
      }
    }
}
</script>
<style lang="scss" scoped>

.container{

    font-size:20px;
    font-family:'Microsoft YaHei';
    display: -webkit-flex;
    display: flex;
    width:1600px;
    height: 100%;
    background-color:white;
    box-shadow: 0 2px 4px rgba(0, 0, 0, .12), 0 0 6px rgba(0, 0, 0, .04);
    overflow:hidden;
    padding:10px;
    margin: auto;
  .aside{
    text-align: center;
    border-right: solid 1px #c7bebe;
    width: 300px;
    height: 100%;
    display: flex;
    flex-direction: column;
    .span{
      height: 50px;
    }
    
  
  }
  .main{
      padding:10px;
       width: 1400px;
        height: 100%;
      line-height: 50px;
        .h1{
          
          font-size:40px;

        }
        .inContainer{
          background-color:#DDDDDD;
          padding: 20px;
          height:600px;
          .button{
            span{
              margin: 0 10px 0 10px;
            }
            display: flex;
            justify-content: flex-start
          }
        }
         .message{
                      display: flex;

                      justify-content: space-around;
                      height: 50px;
            }
         .el-row {
           line-height:40px;
           margin-top: 20px;
              .el-col {
                border-radius: 4px;
              }
              .bg-purple {
                background: #d3dce6;
                font-size: 21px;
               span{
                  position: relative;
                top: 20px;
               }
              }
  
              .grid-content {
              border-radius: 4px;
              height: 80px;
            }
          }
          .update{
            
            height: 100px;
          }
  
        
  }

}




</style>