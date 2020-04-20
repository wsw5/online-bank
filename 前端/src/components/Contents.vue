<template>
    <div class="contentContainer">
        <el-row class="row">
            <el-col :span="5" v-for="(o, index) in cardData.slice((currentPage-1)*pagesize,currentPage*pagesize)" :key="index" :offset="index > 0 ? 1 : 0">
                <el-card :body-style="{ padding: '0px' }" shadow="hover" >
               <el-image
		      style="width: 100%; height: 50%"
		      :src="o.imageUrl"
		      fit="fill"></el-image>
                <div style="padding: 14px;">
                    <span>{{o.name}}</span>
                   
                    <div class="bottom">
                    <p class="time">发表时间：{{ o.beginTime | dateFormat}}</p>
                    <p class="time">结束时间：{{ o.endTime | dateFormat}}</p>
                    </div>
		    <div class="last">
			 <span>点击次数：{{o.count}}</span>
			 <span @click="postIndex(o)">查看</span>
		    </div>
		    
                </div>
                </el-card>
            </el-col>
	    </br>
            <el-col>
                  <el-pagination
                        background
                        layout="prev, pager, next"
                        :total="total"
                        @current-change="current_change">
                    </el-pagination>
            </el-col>
          
        </el-row>
    </div>
</template>
<script>
import axios from '../../http/axiosInit.js'
export default {
    data(){
        return{
            total:1000,
            contentData:[],
            pagesize:4,
            currentPage:1,
            cardData:[],
        }
    },
    created(){
        this.getContent();
    },
    methods:{
        current_change(currentPage){
            this.currentPage=currentPage
        },
        getContent(){
            axios.get('/in/findCommunicate').then(result=>{
               console.log(result)
               if(result.code==200){
                   this.cardData=result.data
               }else{
                   console.log("获取失败")
               }
            },error=>{})
        },
        postIndex(o){
            console.log(o)
            axios.put('/in/updateCommunicate',o).then(result=>{
                console.log(result)
            },error=>{})
            this.$router.push({path:'/home/communicate/contract',query:o})
        }
    }
}
</script>
<style lang="scss" scoped>
    .contentContainer {
        background-color:white;
        padding:30px;
                .time {
            font-size: 13px;
            color: #999;
        }
        .row{
            border:1px black;
        }
        .bottom {
            margin-top: 13px;
            line-height: 12px;
        }

        .button {
            padding: 0;
            float: right;
        }

        .image {
            width: 100%;
            display: block;
        }
	el-col{
	border:1px solid black;
	}

       
	.last{
	display:flex;
	justify-content:space-between
	}
    }
</style>