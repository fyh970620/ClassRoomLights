package fyihan.cn.entity;

import java.io.Serializable;
import java.util.List;

public class TeachBuildRoom implements Serializable {

    private Integer teachBuildRoomId;   //教室id
    private String teachName;  //教室名
    private Integer teachBuildId;       //教学楼id

    private List<TeachRoomLights> trls;

    @Override
    public String toString() {
        return "TeachBuildRoom{" +
                "teachBuildRoomId=" + teachBuildRoomId +
                ", teachName='" + teachName + '\'' +
                ", teachBuildId=" + teachBuildId +
                ", trls=" + trls +
                '}';
    }

    public List<TeachRoomLights> getTrls() {
        return trls;
    }

    public void setTrls(List<TeachRoomLights> trls) {
        this.trls = trls;
    }

    public Integer getTeachBuildRoomId() {
        return teachBuildRoomId;
    }

    public void setTeachBuildRoomId(Integer teachBuildRoomId) {
        this.teachBuildRoomId = teachBuildRoomId;
    }

    public String getTeachName() {
        return teachName;
    }

    public void setTeachName(String teachName) {
        this.teachName = teachName;
    }

    public Integer getTeachBuildId() {
        return teachBuildId;
    }

    public void setTeachBuildId(Integer teachBuildId) {
        this.teachBuildId = teachBuildId;
    }
}
