import axios from 'axios'

export default{
  //登录
  dataUrl: '/api/roomlights/userInfo/loginUserInfo.action',
  loginUserInfo: function (params) {
      return axios.get(this.dataUrl, {
        params
      });
  },

  //注册
  noExistUserinfo: function(params){
    return axios.get('/api/roomlights/userInfo/selectUserInfoExist.action', {
        params
    });
  },

  regOneUser: function(params){
    var requestData = JSON.stringify(params)
    var header = {
      headers: {
        "Content-Type": "application/json"
      }
    }
    return axios.post('/api/roomlights/userInfo/regUserInfo.action',requestData,header);
  },
  
  //忘记密码
  selectExistByUNandEmail: function(params){
    return axios.get('/api/roomlights/userInfo/forgetOneUser.action', {
        params
    });
  },


  //主页左边树显示  
  ListTeachBuild: function(){
    return axios.get('/api/roomlights/teachBuild/selectListTeachBuilds.action');
  },
  //主页内容显示
  ListRoomLights: function(params){
    return axios.get('/api/roomlights/teachBuild/selectListRoomLights.action',{
      params
    });
  },
  //turn down
  turnDownLights: function(params){
    var requestData = JSON.stringify(params)
    var header = {
      headers: {
        "Content-Type": "application/json"
      }
    }
    return axios.post('/api/roomlights/teachBuild/turnDownLights.action',requestData,header);
  },
  turnUpLights: function(params){
    var header = {
      headers: {
        "Content-Type": "application/json"
      }
    }
    return axios.post('/api/roomlights/teachBuild/turnUpLights.action',params,header);
  },




}
