package fyihan.cn.entity;

import java.io.Serializable;
import java.util.List;

public class TeachBuild implements Serializable {

    private Integer teachBuildId;     //教学楼ID
    private String teachName;    //教学楼名称

    //附加属性
    private List<TeachBuildRoom> tbrs;

    @Override
    public String toString() {
        return "TeachBuild{" +
                "teachBuildId=" + teachBuildId +
                ", teachName='" + teachName + '\'' +
                ", tbrs=" + tbrs +
                '}';
    }

    public Integer getTeachBuildId() {
        return teachBuildId;
    }

    public void setTeachBuildId(Integer teachBuildId) {
        this.teachBuildId = teachBuildId;
    }

    public String getTeachName() {
        return teachName;
    }

    public void setTeachName(String teachName) {
        this.teachName = teachName;
    }

    public List<TeachBuildRoom> getTbrs() {
        return tbrs;
    }

    public void setTbrs(List<TeachBuildRoom> tbrs) {
        this.tbrs = tbrs;
    }
}
