package fyihan.cn.controller;

import fyihan.cn.entity.TeachBuild;
import fyihan.cn.entity.TeachRoomLights;
import fyihan.cn.service.TeachBuildService;
import fyihan.cn.util.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping(value="/roomlights/teachBuild")
public class TeachBuildController {

    @Autowired
    private TeachBuildService teachBuildService;

    @RequestMapping(value="/selectListTeachBuilds.action" ,method = RequestMethod.GET)
    public List<TeachBuild> getListTeachBuilds(){
        return teachBuildService.getAllListBuilder();
    }

    @RequestMapping(value="/selectListRoomLights.action" ,method = RequestMethod.GET)
    public List<TeachRoomLights> getListTeachBuilds(@RequestParam("teachBuildRoomId") Integer teachBuildRoomId){
        return teachBuildService.getAllListRoomLights(teachBuildRoomId);
    }

    @RequestMapping(value="/turnDownLights.action" ,method = RequestMethod.POST)
    public BaseResponse getLightsDown(@RequestBody HashMap<String,Object> map){
        return teachBuildService.updateListRoomLights(map);
    }

    @RequestMapping(value="/turnUpLights.action" ,method = RequestMethod.POST)
    public BaseResponse getLightsUp(@RequestBody HashMap<String,Object> map){
        return teachBuildService.updateListRoomLightsUp(map);
    }
}
