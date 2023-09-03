package cn.gary.SysControllers;

import cn.gary.entities.TAdminAdminEntity;
import cn.gary.service.TAdminAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;

@Controller
@RequestMapping("/sys")
public class SysIndexController {

    @Autowired
    TAdminAdminService adminService;
    //呈现数据
    @GetMapping("/login") //http get
    public String login() {
        return "sys/login";
    }

    //采集数据
    @PostMapping("login")//post
    public String login(String username,String userpwd,HttpSession session,HttpServletRequest request){
        //获取用户名密码数据后，应用model，完成数据检验
        //TAdminAdminService service=new TAdminAdminService();
       TAdminAdminEntity adminUser= adminService.login(username,userpwd);
       // System.out.println (username + ":" + userpwd);
       if (adminUser!=null){
           //用户名密码对
           //使用session记录，当前的用户身份信息
           session.setAttribute("adminName",adminUser.getAdminname());
           session.setAttribute("adminId",adminUser.getAdminid());
           session.setAttribute("ip",request.getRemoteAddr());
           session.setAttribute("loginTime",new Date());
           return "redirect:/sys/frame";
       }else {
           //用户名密码错
           return "sys/login";
       }
    }
    @RequestMapping("/frame")
    public String frame(HttpSession session){
        //使用内置对象
        if (session.getAttribute("adminName")==null){
            return "redirect:login";
        }
        //默认返回值是一个视图名
        //加载视图
        return "sys/frame";
    }
    @RequestMapping("/logout")
    public String logout(HttpSession session){
        //清理登录的数据
        session.removeAttribute("adminName");
        session.removeAttribute("adminId");
        session.removeAttribute("ip");
        session.removeAttribute("loginTime");
        return "redirect:login";
    }

}
