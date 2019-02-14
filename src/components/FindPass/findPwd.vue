<template>
  <div id="appFindPwd">
      <div id="findmypwd">
        <div id="findPassword">找回密码</div>
        <el-input v-model="Username" placeholder="输入账号"></el-input>
        <el-input v-model="UserEmail" placeholder="输入绑定邮箱"></el-input>  
        <el-button type="info" :plain="true" @click="jump()">发送验证码</el-button>
        <el-input placeholder="请输入邮箱验证码" v-model="input1" :disabled="true"></el-input>
        <el-button type="success">确认提交</el-button>
      </div>
      

  </div>
</template>

<script>
import service from "../script/service.js";

export default {
  data () {
    return {
        Username:'',
        UserEmail:'',
        input1:''
    }
  },
  methods:{
      jump(){
        let params = {
            Username: this.Username,
            UserEmail: this.UserEmail
        };
         service.selectExistByUNandEmail(params).then(res => {
            this.msg = res.data.msg;
            if(this.msg == "请查收验证码"){
                this.$message({
                    message: '请查收验证码',
                    type: 'success'
                });
            }else{
                this.$message.error('该用户不存在请去注册');
            }
        }).catch(err => {
            alert(this.Host);
            console.log(err);
        });   
      }
  }
}
</script>

<style>
#appFindPwd{
    opacity:0.92;
    width:  100%;
    height: 100%;
    background-image: url(findpwd.jpg); 
    background-repeat: repeat-x;
    background-size: 100%;

}
.el-button{
    margin-bottom: 10px;
}
#findPassword{
    margin-top: 10px;
    color: #333;
    margin-bottom: 16px;
    font-size: 20px;
    font-family: helvetica,arial,微软雅黑,华文黑体
}
#findmypwd{
     opacity:0.92;
    float:left;
    border-radius:5px 5px 5px 5px;
    width: 30%;
    height: 50%;
    background-color: #F0F0F0;
    margin-left:34%;
    margin-top:10%;
    text-align: center;
}
.el-input__inner {
    width:60%
}
</style>
