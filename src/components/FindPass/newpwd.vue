<template>
  <div id="appFindPwd">
      <div id="getNewPwd">
        <div id="findPassword">修改密码</div>
        <el-input v-model="input" placeholder="输入新的密码"></el-input>
        <el-input v-model="input" placeholder="重复输入密码"></el-input>  
        <el-button type="success" >确认提交</el-button>
      </div>
      

  </div>
</template>

<script>

export default {
  data () {
    return {
        input:''
    }
  },
    
}
</script>

<style>
#appFindPwd{
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
#getNewPwd{
     opacity:0.92;
    float:left;
    border-radius:5px 5px 5px 5px;
    width: 30%;
    height: 40%;
    background-color: #F0F0F0;
    margin-left:34%;
    margin-top:10%;
    text-align: center;
}
.el-input__inner {
    width:60%
}
</style>
