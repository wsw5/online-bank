<template>
    <div class="accountContainer">
        <h1 class="h1">账户管理</h1>
        <el-row>
            <el-col :span="24"><div class="grid-content bg-purple-dark"><span>储蓄</span><span>可用余额</span></div></el-col>
        </el-row>
         <el-table :data="accountData" style="width: 100%">
            <el-table-column
                prop="cardNumber"
                label="卡号"
                width="300">
            </el-table-column>
            <el-table-column
                prop="money"
                label="账户余额">
            </el-table-column>
             <el-table-column
                prop="status"
                label="状态">
            </el-table-column>
            <el-table-column
                prop="handle"
                label="操作">
                <template slot-scope="scope">
                        <el-button type="success" :disabled="scope.row.status=='可用'? false : true " @click="transferevent(scope.$index,scope.row)">转账</el-button>
                         <el-button type="info" @click="reportevent(scope.row.cardNumber,0)">挂失</el-button>      
                </template>
            </el-table-column>
        </el-table>
        <el-row>
            <el-col :span="24"><div class="grid-content bg-purple-dark"><span>信用卡</span></div></el-col>
        </el-row>
                    <el-table
                        :data="creditData"
                        style="width: 100%">
                         <el-table-column type="expand">
                        <template slot-scope="props">
                            <el-table :data="props.row.pays">
                                <el-table-column
                                    prop="bill"
                                    label="账单"
                                    width="150">
                                </el-table-column>
                                <el-table-column
                                    prop="interest"
                                    label="计息"
                                    width="150">       
                                </el-table-column>
                                <el-table-column
                                    prop="payday"
                                    label="还款日"
                                    width="250">
                                    <template slot-scope="scope">
                                            {{ scope.row.payday | dateFormat}}
                                        </template>
                                </el-table-column>
				 <el-table-column
                                    prop="paied"
                                    label="已还"
                                    width="150">       
                                </el-table-column>
                                <el-table-column
                                    prop="paytotal"
                                    label="应还">
                                </el-table-column>
                                <el-table-column
                                    prop="handle"
                                    label="操作">
                                   
                                    <el-button type="success"  @click="payevent(props.row.cardNumber)">还款</el-button>
                                    
                                </el-table-column>
                         </el-table>
                        </template>
                         </el-table-column>
                        <el-table-column
                         label="卡号"
                        prop="cardNumber"
                        width="300">                     
                        </el-table-column>
                        <el-table-column
                        label="可用额度"
                        prop="avaliableCredit">
                        </el-table-column>
                        <el-table-column
                            label="状态"
                            prop="status">
                        </el-table-column>
                          <el-table-column
                            prop="handle"
                            label="操作">
                             <template slot-scope="scope">
                         <el-button type="info"  @click="reportevent(scope.row.cardNumber,1)">挂失</el-button> 
                         </template>
                         </el-table-column>     
                    </el-table>
                    
        <el-dialog title="转账登记" :visible.sync="dialogFormVisible1" width="40%">
                <el-form :model="transferForm" :rule="transferRules">

                    <el-form-item label="转账卡号" :label-width="formLabelWidth">
                    <el-input v-model="transferForm.cardNumber1" autocomplete="off"></el-input>
                    </el-form-item>

                    <el-form-item label="转账人身份证" :label-width="formLabelWidth">
                        <el-input v-model="transferForm.idNumber" autocomplete="off"></el-input>
                    </el-form-item>

                    <el-form-item label="被转账卡号" :label-width="formLabelWidth">
                        <el-input v-model="transferForm.cardNumber2" autocomplete="off"></el-input>
                    </el-form-item>

                    <el-form-item label="被转账人姓名" :label-width="formLabelWidth">
                        <el-input v-model="transferForm.name" autocomplete="off"></el-input>
                    </el-form-item>

                    <el-form-item label="转账金额" :label-width="formLabelWidth">
                        <el-input v-model="transferForm.money" autocomplete="off"></el-input>
                    </el-form-item>

                    <el-form-item label="转账卡号密码" :label-width="formLabelWidth">
                        <el-input v-model="transferForm.password" show-password autocomplete="off"></el-input>
                    </el-form-item>
                </el-form>
                <div slot="footer" class="dialog-footer">
                    <el-button @click="dialogFormVisible1 = false">取 消</el-button>
                    <el-button type="primary" @click="posttransfer">确 定</el-button>
                </div>
        </el-dialog>

         <el-dialog title="还款登记" :visible.sync="dialogFormVisible2" width="30%">
                <el-form :model="payForm" :rule="payRules">
                    <el-form-item label="信用卡卡号" :label-width="formLabelWidth">
                        <el-input v-model="payForm.cardNumber2" autocomplete="off"></el-input>
                    </el-form-item>
                    <el-form-item label="还款卡号" :label-width="formLabelWidth">
                        <el-select v-model="payForm.payNumber">
                            <el-option :label="item.cardNumber" :value="item.cardNumber"  v-for="(item,i) in accountData" :key="i"></el-option>
                        </el-select>
                    </el-form-item>
                    <el-form-item label="还款金额" :label-width="formLabelWidth">
                        <el-input v-model="payForm.money" autocomplete="off"></el-input>
                    </el-form-item>
                    <el-form-item label="转账卡号密码" :label-width="formLabelWidth">
                        <el-input v-model="payForm.password" show-password autocomplete="off"></el-input>
                    </el-form-item>
                </el-form>
                <div slot="footer" class="dialog-footer">
                    <el-button @click="dialogFormVisible2 = false">取 消</el-button>
                    <el-button type="primary" @click="postpay">确 定</el-button>
                </div>
        </el-dialog>

         <el-dialog title="挂失" :visible.sync="dialogFormVisible3" width="30%">
                <el-form :model="reportForm" :rule="reportRules">
                    <el-form-item label="卡号" :label-width="formLabelWidth">
                    <el-input v-model="reportForm.cardNumber3" autocomplete="off"></el-input>
                    </el-form-item>
                    <el-form-item label="姓名" :label-width="formLabelWidth">
                         <el-input v-model="reportForm.name" autocomplete="off"></el-input>
                    </el-form-item>
                    <el-form-item label="身份证" :label-width="formLabelWidth">
                        <el-input v-model="reportForm.idNumber" autocomplete="off"></el-input>
                    </el-form-item>
		     <el-form-item label="密码" :label-width="formLabelWidth">
                        <el-input v-model="reportForm.password" autocomplete="off"></el-input>
                    </el-form-item>
                </el-form>
                <div slot="footer" class="dialog-footer">
                    <el-button @click="dialogFormVisible = false">取 消</el-button>
                    <el-button type="primary" @click="postreport">挂   失</el-button>
                </div>
        </el-dialog>
    </div>
    
</template>
<script>
// import Mock from '../mock/index.js'
import axios from 'axios'
export default {
    data(){
        return{
            accountData:[],
            creditData:[],
            transferForm:{
                cardNumber1:'',
                idNumber:'',
                cardNumber2:'',
                name:'',
                money:'',
                password:''
            },
            transferRules:{
                cardNumber1:[{ required: true, message: '请输入您的卡号', trigger: 'blur' }],
                idNumber:[{ required: true, message: '请输入您的身份证', trigger: 'blur' }],
                cardNumber2:[{ required: true, message: '请输入您要转入的卡号', trigger: 'blur' }],
                name:[{ required: true, message: '请输入转入账户的姓名', trigger: 'blur' }],
                money:[{ required: true, message: '请输入转入金额', trigger: 'blur' }],
                password:[{ required: true, message: '请输入您的卡号密码', trigger: 'blur' }],
            },
            payForm:{
                cardNumber2:'',
                payNumber:'',
                money:'',
                password:''
            },
            payRules:{
                 cardNumber2:[{ required: true, message: '请输入您的信用卡号', trigger: 'blur' }],
                  payNumber:[{ required: true, message: '请输入您的还款卡号', trigger: 'blur' }],
                   money:[{ required: true, message: '请输入您的还款金额',trigger: 'blur' }],
                    password:[{ required: true, message: '请输入您的还款卡号密码', trigger: 'blur' }]

            },
            reportForm:{
                category:0,
                cardNumber3:'',
                name:'',
                idNumber:'',
		        password:'',
            },
            reportRules:{
                cardNumber3:[{ required: true, message: '请输入您的储蓄卡号', trigger: 'blur' }],
                name:[{ required: true, message: '请输入您的姓名', trigger: 'blur' }],
                idNumber:[{ required: true, message: '请输入您的身份证号', trigger: 'blur' }],
		 password:[{ required: true, message: '请输入您的卡号密码', trigger: 'blur' }]
            },
            dialogFormVisible1:false,
            dialogFormVisible2:false,
            dialogFormVisible3:false,
            formLabelWidth: '120px',
        }
    },
    created(){
        axios.get('/in/findByName',{params:{userName:this.$store.state.userName}}).then(result=>{
            console.log(result)
            
            if(result.code==200){
               for(var i=0;i<result.data.length;i++){
                   if(result.data[i].status==0){
                       result.data[i].status='可用'
                   }else{
                       result.data[i].status='禁用'
                   }
               }
               this.accountData=result.data
            }
        },error=>{})
        axios.get('/in/findCredit',{params:{userName:this.$store.state.userName}}).then(result=>{
            console.log(result)
            if(result.code==200){
                for(var i=0;i<result.data.length;i++){
                   if(result.data[i].status==0){
                      result.data[i].status='可用'
                   }else{
                       result.data[i].status='禁用'
                   }
               }
            this.creditData=result.data
            var array=[]
            this.creditData.forEach(function(e){
                array.push(e.cardNumber)
            })
            this.$store.dispatch("updateCreditCard",array)
            }
            
        },error=>{})
    },
    methods:{
        transferevent(index,row){
            console.log(index,row)
            this.transferForm.cardNumber1=row.cardNumber
             this.dialogFormVisible1 = true
        },
        payevent(cardNumber){

            this.payForm.cardNumber2=cardNumber
             this.dialogFormVisible2 = true
        },
        reportevent(cardNumber,category){
            console.log(cardNumber)
            console.log(category)
            this.reportForm.cardNumber3=cardNumber
            this.reportForm.category=category
            this.dialogFormVisible3 = true
        },
        posttransfer(){
            console.log(this.transferForm)
             this.dialogFormVisible1 = false
	      console.log(result)
            axios.put('/in/transfer',this.transferForm).then(result=>{
                if(result.code==200){
                     this.$message({
                    showClose: true,
                    message: result.msg,
                    type: 'success'
                    });
                }else{
                    this.$message({
                    showClose: true,
                    message: result.msg,
                    type: 'error'
                    });
                }
            },error=>{})
           
        },
        postpay(){

            axios.put('/in/pay',this.payForm).then(result=>{
	     console.log(result)
                if(result.code==200){

                     this.$message({
                    showClose: true,
                    message: result.msg,
                    type: 'success'
                    });
                }else{
                    this.$message({
                    showClose: true,
                    message: result.msg,
                    type: 'error'
                    });
                }
            },error=>{})
            this.dialogFormVisible2 = false
        },
        postreport(){
            if(this.reportForm.category==0){
                axios.put("/in/report",this.reportForm).then(result=>{
                    console.log(result)
                    if(result.code==200){
                        this.$message({
                        showClose: true,
                        message: result.msg,
                        type: 'success'
                        });
                    }else{
                        this.$message({
                        showClose: true,
                        message: result.msg,
                        type: 'error'
                        });
                    }
                },error=>{})
            }else{
                axios.put('/in/report',this.reportForm).then(result=>{
		 console.log(result)
                if(result.code==200){
                     this.$message({
                        showClose: true,
                        message: result.msg,
                        type: 'success'
                        });
                }else{
                    this.$message({
                        showClose: true,
                        message: result.msg,
                        type: 'error'
                        });
                }
             },error=>{})
            }
            
            this.dialogFormVisible3 = false
        }
        
       
    }
}
</script>
<style lang="scss" scoped>
* /deep/ .el-table td, .el-table th.is-leaf {
    border-bottom: 1px solid #EBEEF5;
    text-align: center;
}
* /deep/ .el-table th>.cell {
    display: inline-block;
    -webkit-box-sizing: border-box;
    box-sizing: border-box;
    position: relative;
    vertical-align: middle;
    padding-left: 10px;
    padding-right: 10px;
    width: 100%;
    text-align: center;
}
.accountContainer{

    .h1{
        font-size:30px;
        color:white;
    }
    text-align: center;
    width:1000px;
    margin:auto;
    padding:20px;

    .grid-content {
        border-radius: 4px;
        min-height: 36px;
        display:flex;
        justify-content:space-around;
    }
    
    .bg-purple-dark {
        background: #99a9bf;
    }
    .el-select {
    display: table;
    position: relative;
    /* justify-content: flex-start; */
    }
    
}

</style>