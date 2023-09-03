package cn.gary.SysControllers;

import cn.gary.entities.TAdminAdminEntity;
import cn.gary.entities.TAdminGroupEntity;
import cn.gary.service.TAdminAdminService;
import cn.gary.service.TAdminGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.thymeleaf.model.IModel;

import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/sys/admin")
public class SysAdminController {

    @Autowired
    TAdminAdminService adminService;
    @Autowired
    TAdminGroupService groupService;
    //修改密码,呈现视图
    @GetMapping("/mypassword")
    public String mypassword(HttpSession session){
        //权限控制
        if(session.getAttribute("adminName")==null){
            //非正常访问者或是超时访问者，都应该重新登录
            return "redirect:login";
        }
        return "sys/admin/mypassword";
    }
    //修改密码--采集新密码进行修改
    @PostMapping("/mypassword")
    public String mypassword(String userpwd, String reuserpwd, HttpSession session){

        //权限控制
        if(session.getAttribute("adminName")==null){
            //非正常访问者或是超时访问者，都应该重新登录
            return "redirect:login";
        }

        if (!userpwd.equals(reuserpwd)){
            //密码不一致重新登录
            return "sys/admin/mypassword";
        }
        String adminName =session.getAttribute("adminName").toString();

        int result=adminService.modifyPwd(adminName,userpwd);
        // 验证：System.out.println(userpwd);

        return "redirect:/sys/frame";//注释：这个地方frame有二义性：/sys/frame以及/sys/admin/frame
    }

    //我的资料
    @RequestMapping("/profile")
    public String profile(HttpSession session){
        //权限控制
        if(session.getAttribute("adminName")==null){
            //非正常访问者或是超时访问者，都应该重新登录
            return "redirect:../login";
        }
        return "sys/admin/profile";
    }

    //管理员列表
    @RequestMapping("/list")
    public String list(Integer pageIndex, Integer pageSize, Model model, HttpSession session) {

        //权限控制
        if(session.getAttribute("adminName")==null){
            //非正常访问者或是超时访问者，都应该重新登录
            return "redirect:login";
        }

        if(pageIndex==null)pageIndex=1;
        if(pageSize==null)pageSize=5;
        List<TAdminAdminEntity> entities = adminService.list(pageIndex, pageSize);
        model.addAttribute("entities", entities);


        //分页连接组件 数据支持
        //前一页页码
        int prepage=pageIndex-1;
        if (pageIndex==1)
            prepage=1;
        //总页数(数据库表记录数16,pageSize=5,请计算一共有几页)
        int recordCount=adminService.selectRecordCount();
        int totalpagenum=recordCount/pageSize;
        if((recordCount%pageSize)!=0)totalpagenum+=1;
        //下一页页码
        int nextpage=totalpagenum;
        if (pageIndex<totalpagenum)
            nextpage=pageIndex+1;
        model.addAttribute("prepage",prepage);
        model.addAttribute("totalpagenum",totalpagenum);
        model.addAttribute("nextpage",nextpage);
        //分页连接组件 可重复调用


        //, ModelAndView mav //mav.addObject("entities",entities)//Model And View
        //加载视图只能显示静态数据
        return "sys/admin/list";
    }


    //管理员 添加（呈现界面）
    @GetMapping("/add")
    public ModelAndView add(ModelAndView mav,HttpSession session){

        //权限控制
        if(session.getAttribute("adminName")==null){
            //非正常访问者或是超时访问者，都应该重新登录
            //return "redirect:../login";
            mav.setViewName("redirect:login");
        }
        //加载管理员分组表数据集
        List<TAdminGroupEntity> groups = groupService.list();//shift+alt+l

        //ModelAddView(既能传递，又能处理视图)
        //Controller>>View 传递信息
        mav.addObject("groups",groups);
        mav.setViewName("sys/admin/add");
        return mav;


        //加载视图，提供管理员分组表数据集，初始化所属组
        //return "sys/admin/add";
    }

    /*数据采集
    @PostMapping("/add")
    public String add(Integer admingroupid,String adminname,String adminpwd,String gender,String description){
        //提交服务层，调用dao层，完成数据持久化
        TAdminAdminEntity admin =new TAdminAdminEntity();
        admin.setAdmingroupid(admingroupid);
        admin.setAdminname(adminname);
        admin.setAdminpwd(adminpwd);
        admin.setGender(gender);
        admin.setDescription(description);

        adminService.insert(admin);

        return "redirect:/sys/admin/list";
    }
    shift+alt+/
    */

    //数据采集
    @PostMapping("/add")
    public String add(TAdminAdminEntity admin,HttpSession session){

        //权限控制
        if(session.getAttribute("adminName")==null){
            //非正常访问者或是超时访问者，都应该重新登录
            return "redirect:login";
        }

        //提交服务层，调用dao层，完成数据持久化

        adminService.insert(admin);

        return "redirect:/sys/admin/list";
    }

    @GetMapping("/modify")
    public String modify( int adminId,Model model,HttpSession session) {
        //权限控制
        if(session.getAttribute("adminName")==null){
            //非正常访问者或是超时访问者，都应该重新登录
            return "redirect:login";
        }

        //加载管理员分组表数据集
        List<TAdminGroupEntity> groups = groupService.list();//shift+alt+l

        //把原来的业务管理员数据下载下来
        TAdminAdminEntity adminEntity = adminService.findById(adminId);

        //分组数据
        model.addAttribute("groups",groups);
        //当前管理员数据
        model.addAttribute("adminEntity",adminEntity);

        return "sys/admin/modify";

    }
    @PostMapping("/modify")
    //修改接收
    public String modify(TAdminAdminEntity entity,HttpSession session){

        //权限控制
        if(session.getAttribute("adminName")==null){
            //非正常访问者或是超时访问者，都应该重新登录
            return "redirect:login";
        }

        //修改时间
        Timestamp now =new Timestamp(new Date().getTime());
        entity.setModifytime(now);
        int result = adminService.modify(entity);
        return "redirect:/sys/admin/list";
    }


    @RequestMapping("/remove")
    public String remove(int adminid,HttpSession session){

        //权限控制
        if(session.getAttribute("adminName")==null){
            //非正常访问者或是超时访问者，都应该重新登录
            return "redirect:login";
        }

        int result=adminService.remove(adminid);
        return "redirect:/sys/admin/list";
    }






}
