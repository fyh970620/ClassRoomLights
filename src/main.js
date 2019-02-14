// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import VueRouter from 'vue-router'

Vue.use(VueRouter)

import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
import VueResource from 'vue-resource';
Vue.use(ElementUI);
Vue.use(VueResource);

Vue.config.productionTip = false

//配置路由
import Login from "./components/Login/login";
import FindPwd from "./components/FindPass/findPwd";
import NewPwd from "./components/FindPass/newpwd";
import Reg from "./components/RegNewUser/register";
import Mainpage from "./components/Main/mainPage";

const routes =[
  {path: '/login',component:Login},
  {path: '/findpwd',component:FindPwd},
  {path: '/newpwd',component:NewPwd},
  {path: '/reg',component:Reg},
  {path: '/mainPage',component:Mainpage},
  {path: '*' ,redirect:'/login'}  //默认跳转的组件
]
const router = new VueRouter({
  routes  //(缩写)相当于 routes:routes
})

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
	render:h =>h(App)
})

//设置头部拦截器
const url = process.env.API_ROOT;
axios.interceptors.request.use(
    config => {
      let token = localStorage.getItem("x-auth-token");
      if (token) {  // 判断是否存在token，如果存在的话，则每个http header都加上token
        config.headers.token = `${token}`;
      }
   
      if (config.url.indexOf(url) === -1) {
        let getTimestamp=new Date().getTime();
        if(config.url.indexOf('?')>-1){
            config.url = url + config.url +"×tamp="+getTimestamp;
          }else{
            config.url = url +config.url +"?timestamp="+getTimestamp;
        }
        
      }
        return config;
    },
    err => {
      alert(err)
      return Promise.reject(err);
    }
);

