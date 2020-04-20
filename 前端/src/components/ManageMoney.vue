<template>
     <div class="container">
       <div class="main">
           <div class="search">
                    <span> <el-select
                                v-model="manageMoneyProductName"
                                filterable
                                remote
                                clearable
                                placeholder="请输入理财产品名称"
                                :remote-method="remoteMethod"
                                :loading="loading">
                                <el-option
                                v-for="(item,i) in options"
                                :key="i"
                                :value="item.manageMoneyName">
                                </el-option>
                            </el-select>
                    </span>
                    <span><el-button type="info" icon="el-icon-search" @click="getManageMoneyProduct">搜索</el-button></span>
                </div>
                <div class="content">
                      <el-table
                      :data="this.manageMoneyProductData.slice((currentPage-1)*pagesize,currentPage*pagesize)"
                            stripe
                            :default-sort = "{prop: 'date', order: 'descending'}">
                            <el-table-column
                                prop="manageMoneyName"
                                label="名称">
                                 <template slot-scope="scope">
                                <div>{{scope.row.manageMoneyName}}</div>           
                                 </template>
                            </el-table-column>
                            <el-table-column
                                prop="time"
                                label="期限">
                                 <template slot-scope="scope">
                                <div>{{scope.row.time}}</div>           
                                 </template>
                            </el-table-column>
                            <el-table-column
                                prop="beginMoney"
                                label="起价">
                                 <template slot-scope="scope">
                                <div>{{scope.row.beginMoney}}</div>           
                                 </template>
                            </el-table-column>
                            <el-table-column
                                prop="endTime"
                                label="结束时间">
                                 <template slot-scope="scope">
                                <div>{{scope.row.endTime | dateFormat}}</div>           
                                 </template>
                            </el-table-column>   
                             <el-table-column
                                prop="rate"
                                label="近一年来收益率">
                                 <template slot-scope="scope">
                                <div>{{scope.row.rate}}</div>           
                                 </template>
                            </el-table-column>   
                             <el-table-column
                                prop="status"
                                label="状态">
                                 <template slot-scope="scope">
                                <div>{{scope.row.status |status}}</div>           
                                 </template>
                            </el-table-column>   
                             <el-table-column
                                    prop="handle"
                                    label="操作">
                                    <template slot-scope="scope">
                                    <el-button type="success"  @click="payevent(scope.row)">购买</el-button>
                                     </template> 
                                </el-table-column>                     
                            </el-table>
                </div>
                <el-pagination
                        background
                        layout="prev, pager, next"
                        :total="total"
                        @current-change="current_change">
                    </el-pagination>
       </div>
        <el-dialog title="购买" :visible.sync="dialogForm" width="30%">
                <el-form :model="manageMoneyProductForm" :rules="manageMoneyProductRules"  ref="manageMoneyProductForm">
                    <el-form-item label="理财产品名称" :label-width="formLabelWidth" prop="fundName">
                    <el-input v-model="manageMoneyProductForm.manageMoneyName" autocomplete="off"></el-input>
                    </el-form-item>
                    <el-form-item label="用户名" :label-width="formLabelWidth" prop="money">
                         <el-input v-model="manageMoneyProductForm.userName" autocomplete="off"></el-input>
                    </el-form-item>
                     <el-form-item label="真实姓名" :label-width="formLabelWidth" prop="money">
                         <el-input v-model="manageMoneyProductForm.realName" autocomplete="off"></el-input>
                    </el-form-item>
                    <el-form-item label="身份证号码" :label-width="formLabelWidth" prop="money">
                         <el-input v-model="manageMoneyProductForm.idNumber" autocomplete="off"></el-input>
                    </el-form-item>
                     <el-form-item label="买入" :label-width="formLabelWidth" prop="money">
                         <el-input v-model="manageMoneyProductForm.money" autocomplete="off"></el-input>
                    </el-form-item>
                    <el-form-item label="付款卡号" :label-width="formLabelWidth" prop="creditCard">
                     <el-select v-model="manageMoneyProductForm.cardNumber" placeholder="请选择">
                        <el-option
                            v-for="(item,i) in creditCard"
                            :key="i"
                            :label="item.label"
                            :value="item">
                        </el-option>
                    </el-select>
                    </el-form-item>
                     <el-form-item label="密码" :label-width="formLabelWidth" prop="money">
                         <el-input v-model="manageMoneyProductForm.password" autocomplete="off" type="password"></el-input>
                    </el-form-item>
                     
                </el-form>
                 <div slot="footer" class="dialog-footer">
                          <el-button @click="resetForm('manageMoneyProductForm')">取 消</el-button>
                        <el-button type="primary" @click="buyManageMoneyProduct('manageMoneyProductForm')">确定</el-button>
                </div>
               
                   

        </el-dialog>
       
   </div>
</template>
<script>
import axios from 'axios'
export default {
    data(){
        var moneyCheck=(rule,value,callback)=>{
             if(value === ''){
                  return callback(new Error('买入多少'))
            }else if(isNaN(Number(value))){
                return callback(new Error('必须是数字'))
            }else if(Number(value)<Number(this.startMoney)){
                 return callback(new Error('买入必须大于起价'))
            } else {
                callback()
            }
        }
        return{
            formLabelWidth:"120px",
            creditCard:[],
            loading:false,
            manageMoneyProductData:[],
            manageMoneyProductAllData:[],
            options:[],
            currentPage:1,
            pagesize:10,
            total:1000,
            dialogForm:false,
            manageMoneyProductName:'',
            startMoney:'',
            manageMoneyProductForm:{
                mid:null,
                manageMoneyName:'',
                money:'',
                cardNumber:'',
                userName:this.$store.state.userName,
                realName:'',
                idNumber:'',
                creditCard:'',
                password:'',
            },
            manageMoneyProductRules:{
                manageMoneyName:[{ required: true, message: '请输入理财产品名称', trigger: 'blur' }],
                money:[{ validator: moneyCheck, trigger: 'blur' }],
                creditCard:[{ required: true, message: '请选择付款卡号', trigger: 'blur' }],
            },
             
        }
    },
    created(){
        this.getManegMoneyProductData()
    },
    methods:{
         resetForm(manageMoneyProductForm){
                this.dialogForm=false;
                this.$refs[manageMoneyProductForm].resetFields();
        },
        buyManageMoneyProduct(manageMoneyProductForm){
              this.$refs[manageMoneyProductForm].validate((valid) => {
                    if (valid) { 
                        axios.post('/in/buyManage',this.manageMoneyProductForm).then(result=>{

                            if(result.code==200){
                                this.$message({
                                showClose: true,
                                message: '购买成功',
                                type: 'success'
                                });
                                }else{
                                    this.$message({
                                    showClose: true,
                                    message: '购买失败',
                                    type: 'error'
                                    });
                                }
                        },error=>{})
                        this.resetForm('manageMoneyProductForm')
                    } else {
            console.log('error submit!!');
            return false;
          }
        });
        }, 
         payevent(row){
             this.startMoney=row.beginMoney
            this.manageMoneyProductForm.mid=row.id
            this.manageMoneyProductForm.manageMoneyName=row.manageMoneyName
            this.creditCard=this.$store.state.creditCard
            this.dialogForm=true
         },
        getManageMoneyProduct(){
            if(!this.manageMoneyProductName==''){
                this.manageMoneyProductData=this.manageMoneyProductAllData.filter(item=>{
                    if(item.manageMoneyName==this.manageMoneyProductName){
                        return item
                    }
                })
            }else{
               this.fundData=this.fundAllData
            }
        },
         current_change(currentPage){
            this.currentPage=currentPage
        },
        getManegMoneyProductData(){
            axios.get('/in/findManageMoneyProduct').then(result=>{
                console.log(result)
                if(result.code==200){
                    this.manageMoneyProductAllData=result.data
                    this.manageMoneyProductData=this.manageMoneyProductAllData
                    this.total=this.manageMoneyProductData.length/this.pagesize*10;
                }
            },error=>{})
        },
        remoteMethod(query) {
            if (query !== '') {
            this.loading = true;
             setTimeout(() => {
                this.loading = false;
                this.options = this.manageMoneyProductAllData.filter(item => {
                    if(item.manageMoneyName.includes(query)){      
                        return item
                    }
                });
            }, 200);
            } else {
                 this.options = [];
            }
      }

    },
     filters:{
           status:function(params){
            if(params==0){
                return '正常'
            }else{
                return '不正常'
            }
        }
     }
}
</script>
<style lang="scss" scoped>

</style>