package fyihan.cn.service;

import fyihan.cn.entity.ClassUserInfo;
import fyihan.cn.repository.ClassUserInfoMapper;
import fyihan.cn.util.BaseResponse;

import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.HashMap;

@Service
public class ClassUserInfoService {

    @Autowired
    private ClassUserInfoMapper classUserInfoMapper;
    @Value("${spring.mail.username}")  //发送人的邮箱  比如155156641XX@163.com
    private String from;
    @Autowired
    private JavaMailSender javaMailSender;
    @Autowired
    private HttpSession session;

    @Async  //意思是异步调用这个方法
    public void sendMail(String title, String url, String email) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from); // 发送人的邮箱
        message.setSubject(title); //标题
        message.setTo(email); //发给谁  对方邮箱
        message.setText(url); //内容
        javaMailSender.send(message);

    }


    public BaseResponse LoginOn(String Username, String UserPassword){
        ClassUserInfo cui = classUserInfoMapper.LoginOneUser(Username,UserPassword);
        BaseResponse bs = new BaseResponse();
        if(cui!=null){
            bs.setCode(1);
            bs.setMsg("登录成功");
            bs.setResponseBody(cui);
            return bs;
        }else{
            bs.setCode(0);
            bs.setMsg("登录失败");
            bs.setResponseBody(cui);
            return bs;
        }
    }

    public BaseResponse selectOneExist(String Username){
        ClassUserInfo cui =classUserInfoMapper.selectOneUserExist(Username);
        BaseResponse bs = new BaseResponse();
        if(cui!=null){
            bs.setCode(0);
            bs.setMsg("该用户已经存在");
            return bs;
        }else{
            bs.setCode(1);
            bs.setMsg("可以注册");
            return bs;
        }
    }

    public BaseResponse RegOneUser(HashMap<String,Object> map){
        JSONObject jsonObject = JSONObject.fromObject(map.get("cui"));
        ClassUserInfo cui = new ClassUserInfo();
        cui.setUsername(jsonObject.getString("Username"));
        cui.setUserEmail(jsonObject.getString("UserEmail"));
        cui.setUserPassword(jsonObject.getString("UserPassword"));
//        System.out.println("===>" + cui);
        BaseResponse bs = new BaseResponse();
        boolean result = classUserInfoMapper.regOneUser(cui);
        if(result!=false){
           bs.setCode(1);
           bs.setMsg("注册成功");
           return bs;
        }else{
           bs.setCode(0);
           bs.setMsg("注册失败");
           return bs;
         }
    }

    public BaseResponse selectForgetExist(String Username,String UserEmail){
        ClassUserInfo cui = classUserInfoMapper.selectForgetUser(Username,UserEmail);
        BaseResponse bs = new BaseResponse();
        if(cui!=null){
            bs.setCode(1);
            bs.setMsg("请查收验证码");
            String title = "验证码";
            String email = UserEmail;
            String url = "12313";
            System.out.println("====>" + url);
            sendMail(title,url,email);
            session.setAttribute("yzCode",url);
            session.setAttribute("Username",Username);
            return bs;
        }else {
            bs.setMsg("用户信息不存在");
            bs.setCode(0);
            return bs;
        }
    }

    public BaseResponse balanceCode(String yzCode){
        String url =(String)session.getAttribute("yzCode");
        BaseResponse bs = new BaseResponse();
        if(yzCode.equals(url)){
            bs.setCode(1);
            bs.setMsg("验证成功");
            return bs;
        }else{
            bs.setCode(1);
            bs.setMsg("验证码不正确请重新输入");
            return bs;
        }
    }

    public BaseResponse updateNewPwd(HashMap<String,String>map){
        String Username = (String)session.getAttribute("Username");
        String newpwd = map.get("password");
        BaseResponse bs = new BaseResponse();
        boolean result = classUserInfoMapper.updatePwd(Username,newpwd);
        if(result!=false){
            bs.setCode(1);
            bs.setMsg("修改成功");
            return bs;
        }else{
            bs.setCode(0);
            bs.setMsg("修改失败");
            return bs;
        }
    }



}
