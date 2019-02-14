package fyihan.cn.repository;

import fyihan.cn.entity.TeachBuild;
import fyihan.cn.entity.TeachBuildRoom;
import fyihan.cn.entity.TeachRoomLights;
import fyihan.cn.util.BaseResponse;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface TeachBuildMapper {

    public List<TeachBuild> selectListTeachBuild();

    public List<TeachRoomLights> selectOSAOfLights(@Param("teachBuildRoomId") Integer teachBuildRoomId);

    public boolean updateTurnDown(@Param("teachRoomLightsId")Integer teachRoomLightsId);

    public boolean updateTurnUp(@Param("teachRoomLightsId")Integer teachRoomLightsId);
}
