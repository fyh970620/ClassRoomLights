package fyihan.cn.entity;

import java.io.Serializable;

public class TeachRoomLights implements Serializable {

    private Integer teachRoomLightsId;           //教室电源id
    private String teachRoomLightsName;          //教室电源操作名
    private String teachRoomLightsStatus;        //教室电源状态
    private Integer teachBuildRoomId;                //教室id

    @Override
    public String toString() {
        return "TeachRoomLights{" +
                "teachRoomLightsId=" + teachRoomLightsId +
                ", teachRoomLightsName='" + teachRoomLightsName + '\'' +
                ", teachRoomLightsStatus='" + teachRoomLightsStatus + '\'' +
                ", teachBuildId=" + teachBuildRoomId +
                '}';
    }

    public Integer getTeachRoomLightsId() {
        return teachRoomLightsId;
    }

    public void setTeachRoomLightsId(Integer teachRoomLightsId) {
        this.teachRoomLightsId = teachRoomLightsId;
    }

    public String getTeachRoomLightsName() {
        return teachRoomLightsName;
    }

    public void setTeachRoomLightsName(String teachRoomLightsName) {
        this.teachRoomLightsName = teachRoomLightsName;
    }

    public String getTeachRoomLightsStatus() {
        return teachRoomLightsStatus;
    }

    public void setTeachRoomLightsStatus(String teachRoomLightsStatus) {
        this.teachRoomLightsStatus = teachRoomLightsStatus;
    }

    public Integer getTeachBuildId() {
        return teachBuildRoomId;
    }

    public void setTeachBuildId(Integer teachBuildId) {
        this.teachBuildRoomId = teachBuildId;
    }
}
