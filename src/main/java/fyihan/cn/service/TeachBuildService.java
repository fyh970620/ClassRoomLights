package fyihan.cn.service;

import fyihan.cn.entity.TeachBuild;
import fyihan.cn.entity.TeachBuildRoom;
import fyihan.cn.entity.TeachRoomLights;
import fyihan.cn.repository.TeachBuildMapper;
import fyihan.cn.util.BaseResponse;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class TeachBuildService {

    @Autowired
    private TeachBuildMapper teachBuildMapper;

    public List<TeachBuild> getAllListBuilder(){
        List<TeachBuild> tbs = teachBuildMapper.selectListTeachBuild();
        return tbs;
    }

    public List<TeachRoomLights> getAllListRoomLights(Integer teachBuildRoomId){
        List<TeachRoomLights> trls = teachBuildMapper.selectOSAOfLights(teachBuildRoomId);
        return trls;
    }

    public BaseResponse updateListRoomLights(HashMap<String,Object> map){
        Integer teachRoomLightsId = (Integer) map.get("teachRoomLightsId");
        System.out.println("====>" + (Integer) map.get("teachRoomLightsId"));
        boolean result = teachBuildMapper.updateTurnDown(teachRoomLightsId);
        BaseResponse bs = new BaseResponse();
        if(result==true){
            bs.setCode(1);
            bs.setMsg("turn down success");
            return bs;
        }else{
            bs.setMsg("turn down failed");
            bs.setCode(0);
            return bs;
        }
    }

    public BaseResponse updateListRoomLightsUp(HashMap<String,Object> map){
        Integer teachRoomLightsId = (Integer) map.get("teachRoomLightsId");
        boolean result = teachBuildMapper.updateTurnUp(teachRoomLightsId);
        BaseResponse bs = new BaseResponse();
        if(result==true){
            bs.setCode(1);
            bs.setMsg("turn up success");
            return bs;
        }else{
            bs.setMsg("turn up failed");
            bs.setCode(0);
            return bs;
        }
    }
}
