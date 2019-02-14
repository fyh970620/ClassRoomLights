package fyihan.cn.controller;

import fyihan.cn.entity.ClassUserInfo;
import fyihan.cn.service.ClassUserInfoService;
import fyihan.cn.util.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping(value="/roomlights/userInfo")
public class ClassUserInfoController {

    @Autowired
    private ClassUserInfoService classUserInfoService;

    @RequestMapping(value="/loginUserInfo.action" ,method = RequestMethod.GET)
    public BaseResponse getLoginUser(@RequestParam("Username")String Username,
                                      @RequestParam("UserPassword")String UserPassword){
        return classUserInfoService.LoginOn(Username,UserPassword);
    }

    @RequestMapping(value="/selectUserInfoExist.action" ,method = RequestMethod.GET)
    public BaseResponse getSelectUserExist(@RequestParam("Username")String Username){
        return classUserInfoService.selectOneExist(Username);
    }

    @RequestMapping(value="/regUserInfo.action" ,method = RequestMethod.POST)
    public BaseResponse getRegNewUser(@RequestBody HashMap<String,Object> map){
        return classUserInfoService.RegOneUser(map);
    }

    @RequestMapping(value="/forgetOneUser.action" ,method = RequestMethod.GET)
    public BaseResponse forgetOneUser(@RequestParam("Username")String Username,
                                      @RequestParam("UserEmail") String UserEmail){
        return classUserInfoService.selectForgetExist(Username,UserEmail);
    }

    @RequestMapping(value="/yzCode.action" ,method = RequestMethod.GET)
    public BaseResponse yzCode(@RequestParam("yzCode")String yzCode){
        return classUserInfoService.balanceCode(yzCode);
    }

    @RequestMapping(value="/updatePwd.action" ,method = RequestMethod.POST)
    public BaseResponse updateOnePwd(@RequestBody HashMap<String,String>map){
        return classUserInfoService.updateNewPwd(map);
    }
}
