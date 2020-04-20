
//入口文件
import Vue from 'vue'

//导入路由的包
import VueRouter from 'vue-router'
//安装路由
Vue.use(VueRouter)
//引入vuex
import store from './store'

//导入element-ui的包
import elementui from 'element-ui'
Vue.use(elementui)

import 'element-ui/lib/theme-chalk/index.css'
import 'element-ui/lib/theme-chalk/display.css';
//引入第三方国标库
import 'font-awesome/css/font-awesome.min.css'

import vueJsonp from 'vue-jsonp'
Vue.use(vueJsonp)

import BaiduMap from 'vue-baidu-map'
 
Vue.use(BaiduMap, {
  /* 申请的百度密钥，可以在百度地图官网申请 */
  ak: 'BTd8pR413xq3aMT4zLH8st86Oonk5dWP'
})



//导入vue-resource包
// import VueResource from 'vue-resource'
// Vue.use(VueResource)

//导入格式化时间的插件
import moment from 'moment'

//定义全局的过滤器
Vue.filter('dateFormat',function(dataStr,pattern="YYYY-MM-DD HH:mm:ss"){
    let date=new Date(dataStr);
    return moment(date).format(pattern)
})

// 全局设置请求的根路径
// Vue.http.options.root="http://loaclhost:8080/"
//全局设置post时候表单数据的格式组织形式 application/x-www-form-urlencoded
//Vue.http.options.emulateJSON=true





//导入appa根组件
import app from './App.vue'


//导入自己的router模块
import router from './router.js'

var vm=new Vue({
    el:"#app",
    render:c=>c(app),
    router//挂载路由对象到VM实例上
    ,
    store,
})





