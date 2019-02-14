package fyihan.cn.entity;

import java.io.Serializable;

public class ClassUserInfo implements Serializable {

    private Integer UserInfoId;
    private String Username;
    private String UserPassword;
    private String UserEmail;

    public ClassUserInfo() {
    }

    public ClassUserInfo(String username, String userPassword, String userEmail) {
        Username = username;
        UserPassword = userPassword;
        UserEmail = userEmail;
    }

    public ClassUserInfo(Integer userInfoId, String username, String userPassword, String userEmail) {
        UserInfoId = userInfoId;
        Username = username;
        UserPassword = userPassword;
        UserEmail = userEmail;
    }

    public Integer getUserInfoId() {
        return UserInfoId;
    }

    public void setUserInfoId(Integer userInfoId) {
        UserInfoId = userInfoId;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getUserPassword() {
        return UserPassword;
    }

    public void setUserPassword(String userPassword) {
        UserPassword = userPassword;
    }

    public String getUserEmail() {
        return UserEmail;
    }

    public void setUserEmail(String userEmail) {
        UserEmail = userEmail;
    }

    @Override
    public String toString() {
        return "ClassUserInfo{" +
                "UserInfoId=" + UserInfoId +
                ", Username='" + Username + '\'' +
                ", UserPassword='" + UserPassword + '\'' +
                ", UserEmail='" + UserEmail + '\'' +
                '}';
    }
}
