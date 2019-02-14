<template>
  <div id="appMain">
      <el-container>
        <el-header><strong>教室电源管理系统</strong></el-header>
        <hr width="80%" id="hr"/>
        <el-container>
            <el-aside>
                <el-tree
                   node-key="teachBuildRoomId"
                   :data="data" :props="defaultProps" 
                   @node-click="handleNodeClick" 
                   leafOnly="true"  
                   ref="tree">
                </el-tree>           
           </el-aside>
            <el-main>
              <table class="lightsClass">  
                  <tr>
                    <td class="tdA" v-for="(item,key) in lightsList" v-if="key<=1">
                      <div v-if=" item.teachRoomLightsStatus=='0'">
                          <el-dropdown style="background-color:#C0C0C0">
                            <span class="el-dropdown-link">
                                {{item.teachRoomLightsName}}<i class="el-icon-arrow-down el-icon--right"></i>
                              </span>
                            <el-dropdown-menu slot="dropdown">
                              <el-dropdown-item @click.native="turnDown(item.teachRoomLightsId)" :plain="true">turn down</el-dropdown-item>
                              <el-dropdown-item @click.native="turnUp(item.teachRoomLightsId)" :plain="true">turn up</el-dropdown-item>                          
                            </el-dropdown-menu>
                          </el-dropdown>
                      </div>
                      <div v-else>
                           <el-dropdown style="background-color:#DDBE44">
                            <span class="el-dropdown-link">
                                {{item.teachRoomLightsName}}<i class="el-icon-arrow-down el-icon--right"></i>
                              </span>
                            <el-dropdown-menu slot="dropdown">
                              <el-dropdown-item @click.native="turnDown(item.teachRoomLightsId)" :plain="true">turn down</el-dropdown-item>
                              <el-dropdown-item @click.native="turnUp(item.teachRoomLightsId)" :plain="true">turn up</el-dropdown-item>                          
                            </el-dropdown-menu>
                          </el-dropdown>
                      </div>
                    </td>   
                  </tr>

                  <tr>
                     <td class="tdA" v-for="(item,key) in lightsList" v-if="key>1">
                      <div v-if=" item.teachRoomLightsStatus=='0' ">
                          <el-dropdown style="background-color:#C0C0C0">
                          <span class="el-dropdown-link">
                              {{item.teachRoomLightsName}}<i class="el-icon-arrow-down el-icon--right"></i>
                            </span>
                          <el-dropdown-menu slot="dropdown">
                            <el-dropdown-item @click.native="turnDown(item.teachRoomLightsId)" :plain="true">turn down</el-dropdown-item>
                            <el-dropdown-item @click.native="turnUp(item.teachRoomLightsId)" :plain="true">turn up</el-dropdown-item>         
                          </el-dropdown-menu>
                        </el-dropdown>
                      </div>
                      <div v-else>
                          <el-dropdown style="background-color:#DDBE44">
                          <span class="el-dropdown-link">
                              {{item.teachRoomLightsName}}<i class="el-icon-arrow-down el-icon--right"></i>
                            </span>
                          <el-dropdown-menu slot="dropdown">
                            <el-dropdown-item @click.native="turnDown(item.teachRoomLightsId)" :plain="true">turn down</el-dropdown-item>
                            <el-dropdown-item @click.native="turnUp(item.teachRoomLightsId)" :plain="true">turn up</el-dropdown-item>        
                          </el-dropdown-menu>
                        </el-dropdown>
                      </div>  
                     </td>
                  </tr>
              </table>
            </el-main>
        </el-container>
        </el-container>
  </div>
</template>

<script>

import service from "../script/service.js";
 export default {
    data() {
      return {
        data: [],
        defaultProps: {
          children: 'tbrs',
          label: 'teachName'
        },
        teachBuildRoomId:'',
        lightsList:[],
        msg:'',
        teachRoomLightsId:''
      };
    },
    methods: {
      handleNodeClick() {
        let params={
            teachBuildRoomId: this.$refs.tree.getCurrentNode().teachBuildRoomId
        };
        service.ListRoomLights(params).then(res => {
            this.lightsList = res.data
        }).catch(err => {
            console.log(err);
        });   
      },
      turnDown(id){
           let params={
             teachRoomLightsId:id
           };
           service.turnDownLights(params).then(res => {
              this.msg = res.data.msg;
              if(this.msg=='turn down success'){
                  this.$message({
                      message: 'turndown成功',
                      type: 'success',     
                  });
                  this.$router.push({path: '/mainPage'});    
              }else{
                this.$message.error('turndown失败');
              }
          }).catch(err => {
              console.log(err);
          });   
      },
      turnUp(id){
           let params={
             teachRoomLightsId:id
           };
           service.turnUpLights(params).then(res => {
              this.msg = res.data.msg;
              if(this.msg=='turn up success'){
                  this.$message({
                      message: 'turnUp成功',
                      type: 'success'
                  });
                  this.$router.push({path: '/mainPage'});    
              }else{
                this.$message.error('turnup失败');
              }
          }).catch(err => {
              console.log(err);
          });   
      }
     
    },

    mounted(){
         service.ListTeachBuild().then(res => {
            this.data = res.data
        }).catch(err => {
            alert(this.Host);
            console.log(err);
        });     
    }
  };

</script>

<style>
.el-dropdown {
    position: relative;
    font-size: 14px;
    width: 50%;
    border-radius: 5px;
}
.tdA{
   width:618px;
   height:334px;
}
#hr{
    margin:0 auto;
}
.el-aside{
    width: 200px;
    height:668px;
}

#appMain{
    opacity:0.92;
    width:100%;
    height: 100%;
    background-image: url(tk.jpg); 
    background-repeat: repeat-x;
    background-size: 100%;
}
  .el-header, .el-footer {
    color: #333;
    text-align: center;
    line-height: 60px;
  }
  
  .el-aside {
    color: #333;
    text-align: center;
    line-height: 200px;
  }
  
  .el-main {
    color: #333;
    text-align: center;
    line-height: 160px;
  }
  
  body > .el-container {
    margin-bottom: 40px;
  }
  
  .el-container:nth-child(5) .el-aside,
  .el-container:nth-child(6) .el-aside {
    line-height: 260px;
  }
  
  .el-container:nth-child(7) .el-aside {
    line-height: 320px;
  }
  .el-tree {
    opacity:0.7;
    position: relative;
    cursor: default;
    background: #fff;
    color: #e0e6f3;
    margin-top: 15px;
    }
    .el-tree-node {
        opacity:0.8;
        white-space: nowrap;
        background-color:#1988C6;
    }
    .el-tree-node:focus > .el-tree-node__content {
        background-color: #A3C4E4;
    }
    .el-tree-node__content:hover {
    background-color: #8A8A8A;
    }

    .lightsClass .tr{
      width: 50%;
    }
</style>
