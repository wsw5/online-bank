<template>
    <div class="content">
         <h3 class="title">注册</h3>
        <el-form ref="registerForm" :model="registerForm" :rules="registerRules" class="register-form">
     

            <el-row :gutter=50>
                <el-col :span="8" >
                    <el-form-item label="户名" prop="userName">
                    <el-input class="prefix" type="text" placeholder="请输入户名" v-model="registerForm.userName" autocomplete="off" prefix-icon="el-icon-user-solid"></el-input>
                    </el-form-item>
                </el-col>
                <el-col :span="8">
                      <el-form-item prop="realName" label="真实姓名">
                    <el-input type="text" placeholder="请输入您的真实名字" v-model="registerForm.realName" autocomplete="off" prefix-icon="el-icon-platform-eleme"></el-input>
                    </el-form-item>
                    </el-col>
                    <el-col :span="8">
                        <el-form-item prop="age" label="年龄">
                    <el-input type="text" placeholder="请输入您的年龄" v-model="registerForm.age" autocomplete="off" prefix-icon="el-icon-platform-eleme"></el-input>
                    </el-form-item>
                     </el-col>
               
            </el-row>

             <el-row :gutter=50>
                   <el-col :span="8">
                    <el-form-item  prop="password" label="密码">
                    <el-input type="password" placeholder="请输入密码" v-model="registerForm.password" autocomplete="off" prefix-icon="el-icon-platform-eleme">
                    </el-input>
                    </el-form-item>
                </el-col>
                 <el-col :span="8">
                     <el-form-item prop="checkPass" label="确认密码">
                    <el-input type="password" placeholder="请再次输入密码" v-model="registerForm.checkPass" autocomplete="off" prefix-icon="el-icon-platform-eleme"></el-input>
                    </el-form-item>
                </el-col>
                
                <el-col :span="8">
                    <el-form-item prop="email" label="邮箱">
                    <el-input type="email" placeholder="请输入邮箱" v-model="registerForm.email" autocomplete="off" prefix-icon="el-icon-platform-eleme"></el-input>
                    </el-form-item>
                </el-col>
                     
            </el-row>

             <el-row :gutter=50>
               
                 <el-col :span="8">
                    <el-form-item prop="phoneNumber" label="电话号码">
                    <el-input type="text" placeholder="请输入电话号码" v-model="registerForm.phoneNumber" autocomplete="off" prefix-icon="el-icon-platform-eleme"></el-input>
                    </el-form-item>
                </el-col>
                <el-col :span="14">
                        <el-form-item prop="idNumber" label="身份证号码">
                    <el-input type="text" style="width='350px'"  placeholder="请输入您的身份证号码" v-model="registerForm.idNumber" autocomplete="off" prefix-icon="el-icon-platform-eleme"></el-input>
                    </el-form-item>
                     </el-col>
               
            </el-row>
            <el-row :gutter=50>
             <el-col :span="12">
                   <el-form-item prop="address" label="地址">
                    <el-input id="suggestion" type="text" placeholder="请输入您的地址" v-model="registerForm.address" autocomplete="off" prefix-icon="el-icon-platform-eleme"></el-input>
                    </el-form-item>
                     
            </el-col>
             <el-col :span="4">
                   <el-form-item label="验证码" prop="code">
            <el-input  class="auth_input" type="text" v-model="registerForm.code"  placeholder="输入验证码" />
           
             </el-form-item>
                </el-col>
                <el-col :span="6">
                   <div class="span">
                        <span v-show="sendAuthCode" class="auth_text" @click="getAuthCode">获取验证码</span>
                    <span v-show="!sendAuthCode" class="auth_text_back">{{auth_time}}秒之后重新发送</span> 
                   </div>
                   
                </el-col>
            </el-row>
              <el-row :gutter=50>
             <el-col :span="12">
                   <el-form-item prop="emergencyOneName" label="紧急联系人1">
                    <el-input type="text" placeholder="请输入您的第一个紧急联系人姓名" v-model="registerForm.emergencyOneName" autocomplete="off" prefix-icon="el-icon-platform-eleme"></el-input>
                    </el-form-item>
                     
            </el-col>
              <el-col :span="12">
           <el-form-item prop="emergencyOnePhone" label="紧急联系人2电话号码">
                    <el-input type="text" placeholder="请输入您的第一个联系人电话号码" v-model="registerForm.emergencyOnePhone" autocomplete="off" prefix-icon="el-icon-platform-eleme"></el-input>
                    </el-form-item>
                     </el-col>
            </el-row>
            <el-row :gutter=50>
             <el-col :span="12">
                   <el-form-item prop="emergencyOneIdNumber" label="紧急联系人1身份证号">
                    <el-input type="text" placeholder="请输入您的第一个紧急联系人身份证号" v-model="registerForm.emergencyOneIdNumber" autocomplete="off" prefix-icon="el-icon-platform-eleme"></el-input>
                    </el-form-item>
                     
            </el-col>
              <el-col :span="12">
           <el-form-item prop="emergencyOneAddress" label="紧急联系人1地址">
                    <el-input type="text" id="contact1" placeholder="请输入您的第一个联系人地址" v-model="registerForm.emergencyOneAddress" autocomplete="off" prefix-icon="el-icon-platform-eleme"></el-input>
                    </el-form-item>
                     </el-col>
            </el-row>




             <el-row :gutter=50>
             <el-col :span="12">
                   <el-form-item prop="emergencyTwoName" label="紧急联系人2">
                    <el-input type="text" id="contact2" placeholder="请输入您的第二个紧急联系人姓名" v-model="registerForm.emergencyTwoName" autocomplete="off" prefix-icon="el-icon-platform-eleme"></el-input>
                    </el-form-item>
            </el-col>
              <el-col :span="12">
                   <el-form-item prop="emergencyTwoPhone" label="紧急联系人2电话号码">
                    <el-input type="text" placeholder="请输入您的第二个联系人电话号码" v-model="registerForm.emergencyTwoPhone" autocomplete="off" prefix-icon="el-icon-platform-eleme"></el-input>
                    </el-form-item>
                   </el-col>
            </el-row>
            <el-row :gutter=50>
             <el-col :span="12">
                   <el-form-item prop="emergencyTwoIdNumber" label="紧急联系人2身份证号">
                    <el-input type="text" placeholder="请输入您的第二个紧急联系人身份证号" v-model="registerForm.emergencyTwoIdNumber" autocomplete="off" prefix-icon="el-icon-platform-eleme"></el-input>
                    </el-form-item>
                     
            </el-col>
              <el-col :span="12">
           <el-form-item prop="emergencyTwoAddress" label="紧急联系人2地址">
                    <el-input type="text" placeholder="请输入您的第二个联系人地址" v-model="registerForm.emergencyTwoAddress" autocomplete="off" prefix-icon="el-icon-platform-eleme"></el-input>
                    </el-form-item>
                     </el-col>
            </el-row>
            <el-row>
            <el-col :span="24">
                 <el-button type="success" round size="medium" @click="putUser('registerForm')">提交</el-button>
            </el-col>
            </el-row>
        <div id="allmap"></div>


       

        
        <router-link class="link" to="/nohome/login">
            <span>
                <i class="el-icon-arrow-left"></i>    
            </span>返回登录页面
        </router-link>
        
      
           
          
    </el-form>
    </div>
</template>
<script>
import axios from 'axios'

export default {
    data(){
        //校验第二次输入的密码
        var validatePass2 = (rule, value, callback) => {
            if (value === '') {
                callback(new Error('请再次输入密码'));
            } else if (value !== this.registerForm.password) {
                callback(new Error('两次输入密码不一致!'));
            } else {
                callback();
            }
        };
        //校验电话号码
        var telCheck = (rule, value, callback) => {
            if (value === '') {
                return callback(new Error('电话号码是必须的'))
            } else {
                const reg = /^1[3|4|5|7|8][0-9]\d{8}$/
                if (reg.test(value)) {
                    callback();
                } else {
                    return callback(new Error('请输入正确的手机号'));
                }
            }
        };
        //校验年龄
        var ageCheck = (rule, value, callback) => {
            if (value === '') {
                return callback(new Error('请输入您的年龄'))
            } 
                if (!Number.isInteger(Number(value))) {
                    callback(new Error('请输入数字值'));
                } else {
                    if (value < 18) {
                    callback(new Error('必须年满18岁'));
                    } else if(value>100){
                    callback(new Error('您的年龄输入有误'));
                    }
                }
        };
        //校验身份证
         var idNumberCheck = (rule, value, callback) => {
            if (value === '') {
                callback(new Error('请输入您的身份证'));
            } else {
               const reg= /(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/
                if (reg.test(value)) {
                    callback();
                } else {
                    return callback(new Error('请输入正确的身份证号码'));
                }
            }
        };
        return{

            sendAuthCode:true,/*布尔值，通过v-show控制显示‘获取按钮'还是‘倒计时' */
            auth_time: 0, /*倒计时 计数器*/
            address_detail: null, //详细地址
            userlocation: {lng: "", lat: ""},
             registerForm:{
                userName:'',
                password:'',
                checkPass:'',
                email:'',
                phoneNumber:'',
                realName:'',
                age:'',
                idNumber:'',
                code:'',//绑定输入验证码框框
                address:'',
                emergencyOneName:'',
                emergencyTwoName:'',
                emergencyOnePhone:'',
                emergencyTwoPhone:'',
                emergencyOneIdNumber:'',
                emergencyTwoIdNumber:'',
                emergencyOneAddress:'',
                emergencyTwoAddress:''
            },
             registerRules:{
                userName:[
                    { required: true, message: '请输入户名', trigger: 'blur' },
                    { min: 3, max: 5, message: '长度在 3 到 5 个字符', trigger: 'blur' }
                ],
                password:[
                    { required: true, message: '请输入密码', trigger: 'blur' },
                    { min: 8, max: 12, message: '长度在 8 到 12 个字符', trigger: 'blur' }
                ],
                checkPass:[
                    { validator: validatePass2, trigger: 'blur' }
                ],
                email:[
                    { required: true, message: '请输入邮箱地址', trigger: 'blur' },
                    { type: 'email', message: '请输入正确的邮箱地址', trigger: ['blur', 'change'] }
                ],
                phoneNumber:[
                    { validator: telCheck, trigger: 'blur' }
                ],
                realName:[
                     { required: true, message: '请输入您的真实姓名', trigger: 'blur' },
                ],
                age:[
                    {validator:ageCheck,trigger:'blur'}
                ],
                idNumber:[
                    {validator:idNumberCheck,trigger:'blur'}
                ],
                code:[
                    { required: true, message: '请输入验证码', trigger: 'blur' },
                ],
                address:[
                     { required: true, message: '请输入您的地址', trigger: 'blur' },
                ],
                emergencyOneName:[
                    { required: true, message: '请输入联系人的名字', trigger: 'blur' },
                ],
                emergencyTwoName:[
                    { required: true, message: '请输入联系人的名字', trigger: 'blur' },
                ],
                emergencyOnePhone:[
                     { validator: telCheck, trigger: 'blur' }
                ],
                emergencyTwoPhone:[
                     { validator: telCheck, trigger: 'blur' }
                ],
                emergencyOneIdNumber:[
                    {validator:idNumberCheck,trigger:'blur'}
                ],
                emergencyTwoIdNumber:[
                    {validator:idNumberCheck,trigger:'blur'}
                ],
                emergencyOneAddress:[
                    { required: true, message: '请输入联系人的地址', trigger: 'blur' },
                ],
                emergencyTwoAddress:[
                    { required: true, message: '请输入联系人的地址', trigger: 'blur' },
                ]
                     
                
            }

        }
    },
    methods:{
            //  验证
            getAuthCode:function () {
                this.sendAuthCode = false;
                // const verification =this.ReginForm.tel;
                // const url = "/in/register"
                // console.log("url",url);
                // axios.get(url).then(function (response) {
                // console.log("请求成功",response)
                //  }, function (error) {
                //  console.log("请求失败",error);
                // })
            //设置倒计时秒
            this.auth_time = 60;
            var auth_timetimer = setInterval(()=>{
                this.auth_time--;
                    if(this.auth_time<0){
                    this.sendAuthCode = true;
                    clearInterval(auth_timetimer);
                    }
            } , 1000);
        },
        putUser(formName){
           this.$refs[formName].validate((valid) => {
              
            if (valid) {
                axios.post("/in/register",this.registerForm).then(result=>{
                    if(result[0].data.code==200){
                        console.log(result)
                        this.open(result[0].data.msg);
                    }
                },error=>{
                 
                    console.log(error)
                })
                 console.log(registerForm)
            } else {
                  
                console.log('error submit!!');
                return false;
            }
            });
        },
         open(msg) {
            this.$alert('提交成功'+msg, '', {
            callback: action => {
            }
            });
      }
    } ,
     mounted(){
           this.$nextTick(function () {

                   var th = this
                   // 创建Map实例
                   var map = new BMap.Map("allmap");
                   // 初始化地图,设置中心点坐标，
                   var point = new BMap.Point(121.160724,31.173277); // 创建点坐标，汉得公司的经纬度坐标
                   map.centerAndZoom(point, 15);
                   map.enableScrollWheelZoom();
                   var ac = new BMap.Autocomplete(    //建立一个自动完成的对象
                       {
                           "input": "suggestion"
                           , "location": map
                       })
                   var myValue
                   ac.addEventListener("onconfirm", function (e) {    //鼠标点击下拉列表后的事件
                       var _value = e.item.value;
                       myValue = _value.province + _value.city + _value.district + _value.street + _value.business;
                       this.address_detail = myValue
                       setPlace();
                   });

                   function setPlace() {
                       map.clearOverlays();    //清除地图上所有覆盖物
                       function myFun() {
                           th.userlocation = local.getResults().getPoi(0).point;    //获取第一个智能搜索的结果
                           map.centerAndZoom(th.userlocation, 18);
                           map.addOverlay(new BMap.Marker(th.userlocation));    //添加标注
                       }

                       var local = new BMap.LocalSearch(map, { //智能搜索
                           onSearchComplete: myFun
                       });
                       local.search(myValue);

                       //测试输出坐标（指的是输入框最后确定地点的经纬度）
                       map.addEventListener("click",function(e){
                           //经度
                           console.log(th.userlocation.lng);
                           //维度
                           console.log(th.userlocation.lat);

                       })
                   }

           })
       },

}
</script>
<style lang="scss" scoped>
* /deep/ .el-col-24 {
    width: 100%;
    text-align: center;
}
* /deep/ .el-button--medium.is-round {
    padding: 10px 20px;
    width: 120px;
}
* /deep/ .el-form-item__label {
    text-align: right;
    vertical-align: middle;
    float: left;
    font-size: 18px;
    color: #606266;
    line-height: 30px;
    padding: 0 12px 0 0;
    -webkit-box-sizing: border-box;
    box-sizing: border-box;
    color:white;
}
* /deep/ .el-input--prefix .el-input__inner {
    padding-left: 30px;
    width:300px;
}
.content{
    line-height:20px;
     width: 1000px;
    height: 1000px;
    border-radius: 6px;
    background-color: rgba(0,0,0,0.4);
    padding: 25px 50px 0px 60px;
     margin: auto;
   
     .title{
            text-align: center;
            color: white;
            position:relative;
            left:-20px;
 .el-form{
        width: 500px;
        height: 100%;
       
            .el-form-item {
                margin: 30px;
            color: white;
        
        
                .auth_input{
                    width: 50%;
                }
            .el-row{
                text-align: -webkit-center;  
            }
            
            }
            
        }
      
        
    }
     .auth_text{
           color:white;
            position: relative;
             top: 30px;
            left:-20px;
            font-size:15px;
            top: 30px;
       }
       .auth_text_back{
            color:white;
            position: relative;
             top: 30px;
            left:-20px;
            font-size:15px;
            top: 30px;
       }
       .auth_text:hover{
           color:blue;
       }
       .allmap{
           width:400px;
           height:400px;
           font-family:"微软雅黑";
           border:1px solid green; 
       }
       .link{
                position: relative;
                left: 0;
                bottom: 0;
                color: white;
            }
        .link:hover{
            color:yellow;
        }
}
   
</style>
