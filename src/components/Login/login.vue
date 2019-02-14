<template>
  <div id="appLogin">      
      <div id="user">
            <div id="headfont">账号密码登录</div>
            <el-input v-model="Username" placeholder="账号/用户名"></el-input>   
            <el-input v-model="UserPassword" placeholder="密码"></el-input>   
            <el-button type="primary" :plain="true" @click="getMain()">登录</el-button>
            <div id="dhang">
                 <router-link id="rl" class="rl" to="/reg">注册用户  |</router-link>
                <router-link id="rl" class="rl" to="/findpwd">忘记密码  |</router-link>
                <router-link id="rl" class="rl" to="/aboutus">关于我们</router-link>
            </div>
      </div>
       
  </div>
</template>

<script>

import service from "../script/service.js";
export default {
  data () {
    return {
        Username: '',
        UserPassword: '',
        msg:''
    }
  },
  methods:{
      getMain(){
        let params = {
            Username: this.Username,
            UserPassword: this.UserPassword
        };
        service.loginUserInfo(params).then(res => {
            this.msg = res.data.msg;
            if(this.msg == "登录成功"){
                this.$message({
                    message: '登录成功',
                    type: 'success'
                });
                this.$router.push({path: '/mainPage'});            
            }else{
                this.$message.error('登录失败');
                this.$router.push({path: '/Login'});            

            }
        }).catch(err => {
            alert(this.Host);
            console.log(err);
        });   

        
      }
  },
  
}
</script>

<style>
#appLogin{
    width:  100%;
    height: 100%;
    background-image: url(backgroundimg.jpg); 
    background-repeat: repeat-x;
    background-size: 100%;
}

#user{
    opacity:0.92;
    border-radius:5px 5px 5px 5px;
    float: left;
    width: 30%;
    height: 300px;
    text-align: center;
    background-color:#F0F0F0;
    margin-left: 720px;
    margin-top: 150px;

}
#headfont {
    margin-top: 10px;
    color: #333;
    margin-bottom: 16px;
    font-size: 20px;
    font-family: helvetica,arial,微软雅黑,华文黑体
}
.el-button--primary {
    margin-bottom: 40px;
}
.el-input{
    margin-bottom: 16px
}
.el-input__inner {
    width:60%
}
.el-button {
    width:60%
}
#dhang{
    margin-left:160px;
}
a{
    margin-left:5px;
    color:#C9BFD3;
    font-size:14px;
    text-decoration:none
}
a:hover{
    color:#3481CF
}
</style>
