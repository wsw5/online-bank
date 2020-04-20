<template>
    <div class="container">
        <el-row :gutter="30" style="    margin-left: 20px;
    margin-right: 20px;">
        <el-col :span="6" >
            <div class="entrust">
                <img src='src/image/person2.jpg'/>
                
                <span style="font-size:20px;">委托贷款</span>
                <span><el-button type="danger" @click="dialogVisible1= true" plain>立即申请</el-button></span>
            </div></el-col>
        <el-col :span="6">
            <div class="entrust">
                <img src='src/image/mony2.jpg'/>
                <span style="font-size:20px;">信用贷款</span>
                <span><el-button type="danger" @click="dialogVisible2= true" plain>立即申请</el-button></span>
                </div></el-col>
        <el-col :span="6"><div>
                <div class="entrust">
                <img src='src/image/mony1.jpg'/>
                <span style="font-size:20px;">担保贷款</span>
                <span><el-button type="danger" @click="dialogVisible3= true" plain>立即申请</el-button></span>
                </div>
            </div></el-col>
        <el-col :span="6"> 
            <div class="entrust">
                <img src='src/image/loan.jpg'/>
                <span style="font-size:20px;"x>票据贴现</span>
                <span><el-button type="danger" @click="dialogVisible4= true" plain>立即申请</el-button></span>
                </div></el-col>
        </el-row>
        <el-dialog
            title="委托贷款"
            :visible.sync="dialogVisible1"
            width="900px"
            :before-close="handleClose">
            <div class="p">
                 <p >委托贷款是指由政府部门、企事业单位及个人等委托人提供资金，由贷款人(即受托人)根据委托人确定的贷款对象、用途、金额、期限、利率等代为发放、监督使用并协助收回的贷款。贷款人(受托人)只收取手续费，不承担贷款风险。
                办理个人委托贷款的基本程序是：</p>
                <p >一是由委托人向银行提出放款申请。</p>
                <p>二是银行根据双方的条件和要求进行选择配对，并分别向委托方和借款方推介。</p>
                <p>三是委托人和借款人双方直接见面，就具体事项和细节如借款金额、利率、贷款期限、还款方式等进行洽谈协商并作出决定。</p>
                <p>四是借贷双方谈妥要求条件之后，一起到银行并分别与银行签订委托协议。</p>
                <p >五是银行对借贷人的资信状况及还款能力进行调查并出具调查报告，然后借贷双方签订借款合同并经银行审批后发放。</p></span>
                <p >您的信息：</p>
            <div class="message">
                <span>姓名：<el-input style="width:150px" placeholder="名字" clearable></el-input></span>
                <span>身份证：<el-input style="width:250px" placeholder="身份证" clearable></el-input></span>
               
            </div>
            
            </div>
            <span>贷款金额：<el-input style="width:250px" placeholder="贷款金额" clearable></el-input></span>
           
            <span slot="footer" class="dialog-footer">
                <el-button @click="dialogVisible1 = false">取 消</el-button>
                <el-button type="primary" @click="dialogVisible1 = false">你确定要申请吗?</el-button>
            </span>
        </el-dialog>
        <el-dialog
            title="信用贷款"
            :visible.sync="dialogVisible2"
            width="700px"
            :before-close="handleClose">
            <div class="p">
                    <p>信用贷款是指以借款人的信誉发放的贷款。其特征就是债务人无需提供抵押品或第三方担保仅凭自己的信誉就能取得贷款，并以借款人信用程度作为还款保证的。这种信用贷款是我国银行长期以来的主要放款方式。由于这种贷款方式风险较大，一般要对借款方的经济效益、经营管理水平、发展前景等情况进行详细的考察，以降低风险。
                        从实际看，银行发放信用贷款的基本条件是：</p>
                    <p>一是企业客户信用等级至少在AA-(含)级以上的，经国有商业银行省级分行审批可以发放信用贷款；</p>
                    <P>二是经营收入核算利润总额近三年持续增长，资产负债率控制在60%的良好值范围，现金流量充足、稳定；</p>
                    <P>三是企业承诺不以其有效经营资产向他人设定抵(质)或对外提供保证，或在办理抵(质)押等及对外提供保证之前征的贷款银行同意；</p>
                    <P>四是企业经营管理规范，无逃废债、欠息等不良信用记录。</p>
                <p >您的信息：</p>
            <div class="message">
                <span>姓名：<el-input style="width:150px" placeholder="名字" clearable></el-input></span>
                <span>身份证：<el-input style="width:250px" placeholder="身份证" clearable></el-input></span>
            </div>
            
            </div>
            <span>贷款金额：<el-input style="width:250px" placeholder="贷款金额" clearable></el-input></span>
           
            <span slot="footer" class="dialog-footer">
                <el-button @click="dialogVisible2 = false">取 消</el-button>
                <el-button type="primary" @click="dialogVisible2 = false">你确定要申请吗?</el-button>
            </span>
        </el-dialog>
         <el-dialog
            title="担保贷款"
            :visible.sync="dialogVisible3"
            width="700px"
            :before-close="handleClose">
            <div class="p">
                    <p>担保贷款是指保证贷款、抵押贷款、质押贷款。
                    权利质押是指以汇票、支票、本票、债券、存款单、仓单、提单；依法可以转让的股份、股票；依法可以转让的商标专用权、专利权、着作权中的财产权；依法可以质押的其他权利。
                    质押与抵押相比，最大的特点是质物必须移交给银行占有。</p>
                <p >您的信息：</p>
            <div class="message">
                <span>姓名：<el-input style="width:150px" placeholder="名字" clearable></el-input></span>
                <span>身份证：<el-input style="width:250px" placeholder="身份证" clearable></el-input></span>
            </div>
             <div class="message">
            <span>贷款金额：<el-input style="width:150px" placeholder="贷款金额" clearable></el-input></span>
            <span>担保贷款类型：
                <el-select style="width:200px" placeholder="请选择">
                        <el-option
                        v-for="item in options"
                        :key="item.value"
                        :label="item.label"
                    :value="item">
                        </el-option>
                    </el-select></span>
           </div>
            
            </div>
            
            <span slot="footer" class="dialog-footer">
                <el-button @click="dialogVisible3= false">取 消</el-button>
                <el-button type="primary" @click="dialogVisible3 = false">你确定要申请吗?</el-button>
            </span>
        </el-dialog>
                <el-dialog
            title="票据贴现"
            :visible.sync="dialogVisible4"
            width="700px"
            :before-close="handleClose">
            <div class="p">
                   <p>票据贴现是指借款人将未到期商业票据(银行承兑汇票或商业承兑汇票)转让给银行，取得扣除贴现利息后的资金。俗话说，杀头的生意有人做，赔本的买卖无人干。票据贴现当然要有利可图，银行在接受企业的票据时，在原价基础上打个折扣，被称为贴现。</p>
                <p >您的信息：</p>
            <div class="message">
                <span>姓名：<el-input style="width:150px" placeholder="名字" clearable></el-input></span>
                <span>身份证：<el-input style="width:250px" placeholder="身份证" clearable></el-input></span>
            </div>           
            </div>
            <span slot="footer" class="dialog-footer">
                <el-button @click="dialogVisible2 = false">取 消</el-button>
                <el-button type="primary" @click="dialogVisible2 = false">你确定要申请吗?</el-button>
            </span>
        </el-dialog>
    </div>
</template>
<script>
export default {
    data(){
        return{
            dialogVisible1:false,
            dialogVisible2:false,
            dialogVisible3:false,
            dialogVisible4:false,
            options:["保证贷款","抵押贷款","质押贷款"]
        }
    }
}
</script>
<style lang="scss" scoped>
.container{
    height:100%;
    width:100%;
    background-color:white;
    display:flex;
    overflow-x:hidden;
    .el-row {
        -webkit-box-sizing: border-box;
        box-sizing: border-box;
        height: 380px;
        align-self:center;
        width:100%;
    }
    .el-col-6 {
        width: 25%;
        height: 380px;
        box-shadow: 0 2px 4px #888888, 0 0 6px #888888;
    }
    .entrust{
        width:100%;
        height:100%;
        display: flex;
    flex-direction: column;
    }
    img{
        width:100%;
        height:240px;
    }
    .p{
        text-indent:2em;
        text-align:left;
    }
    .message{
        display: flex;
         justify-content: space-around;

    }
    
}
</style>