package fyihan.cn.repository;

import fyihan.cn.entity.ClassUserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface ClassUserInfoMapper {

    /**
     * 登录
     * @return
     */
    public ClassUserInfo LoginOneUser(@Param("Username")String Username,@Param("UserPassword")String UserPassword);

    /**
     * 注册
     *1,该用户是否存在
     *2，注册用户
     **/
    public ClassUserInfo selectOneUserExist(@Param("Username")String Username);
    public boolean regOneUser(@Param("cui")ClassUserInfo cui);

    /**
     * 找回密码
     */
    public ClassUserInfo selectForgetUser(@Param("Username")String Username,@Param("UserEmail")String UserEmail);

    /**
     * 修改密码
     */
    public boolean updatePwd(@Param("Username")String Username,@Param("UserPassword")String UserPassword);

}
