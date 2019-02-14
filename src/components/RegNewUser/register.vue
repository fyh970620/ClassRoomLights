<template>
  <div id="appReg">
      <div id="userReg">
            <div id="headfont">注册新用户</div>
            <el-input v-model="Username" placeholder="账号/用户名" @click="noExist()"></el-input>   
            <el-input v-model="UserPassword" placeholder="密码"></el-input>  
            <el-input v-model="reUserPassword" placeholder="重复密码"></el-input>   
            <el-input v-model="UserEmail" placeholder="邮箱"></el-input> 
            <el-button class="reg_el_button" type="primary" @click="sure()" :plain="true">确认</el-button>   <el-button class="reg_el_button" type="info" @click="back()">取消</el-button>
      </div>
  </div>
</template>

<script>

import service from "../script/service.js";

export default {
  data () {
    return {
        cui:{
            Username:'',
            UserPassword:'',
            UserEmail:''
        },
        Username:'',
        UserPassword:'',
        reUserPassword:'',
        UserEmail:'',
        msg:'',
        msgreg:'',
    }
  },
  methods:{
      back(){
          this.$router.push({path: '/login'})
      },
      sure(){
        let params = {
            Username: this.Username
        };
        
        service.noExistUserinfo(params).then(res => {
            this.msg = res.data.msg;
            if(this.msg == "可以注册"){
                let params = {
                    Username: this.Username,
                    UserPassword: this.UserPassword,
                    reUserPassword: this.reUserPassword,
                    UserEmail: this.UserEmail
                };
                if(this.UserPassword==this.reUserPassword){
                    this.cui.Username = this.Username;
                    this.cui.UserPassword = this.UserPassword;
                    this.cui.UserEmail = this.UserEmail;
                    let params = {
                       cui:this.cui
                    };
                    service.regOneUser(params).then(res => {
                    this.msgreg=res.data.msg;
                    if(this.msgreg == "注册成功"){
                        this.$message({
                            message: '注册成功',
                            type: 'success'
                        });
                            this.$router.push({path: '/login'}); 
                        }else{
                            this.$message.error('注册失败');
                            this.$router.push({path: '/reg'});   
                        }                  
                    }).catch(err => {
                        alert(this.Host);
                        console.log(err);
                    });   
                }else{
                    this.$message.error('两次密码不一致');
                    this.$router.push({path: '/reg'});   
                }
                
            }else{
                this.$message.error('注册失败，该用户已经存在');
                this.$router.push({path: '/reg'});            
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
#appReg{
    width:  100%;
    height: 100%;
    background-image: url(reg.jpg); 
    background-repeat: repeat-x;
    background-size: 100%;
}
#userReg{
    opacity:0.9;
    border-radius:5px 5px 5px 5px;
    float: left;
    width: 30%;
    height: 400px;
    text-align: center;
    background-color:#F0F0F0;
    margin-left: 720px;
    margin-top: 150px;
}
.reg_el_button {
    width: 25%;
}

.el-button--primary {
    margin-bottom: 15px;
}
.el-input{
    margin-bottom: 16px
}
.el-input__inner {
    width:60%
}

</style>
