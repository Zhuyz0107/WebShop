package cn.gary.SysControllers;

import cn.gary.entities.TProductBrandEntity;
import cn.gary.entities.TProductClassEntity;
import cn.gary.entities.TProductProductEntity;
import cn.gary.entities.TAdminGroupEntity;
import cn.gary.service.*;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * 后台管理员相关
 */
@Controller
@RequestMapping("/sys/product")
public class SysProductController {

    @Autowired
    TProductProductService productService;

    @Autowired
    TProductBrandService brandService;

    @Autowired
    TProductClassService classService;


    //管理员列表
    @RequestMapping("/list")
    public String list(Integer pageIndex, Integer pageSize, Model model, HttpSession session) {

        //权限控制
        if(session.getAttribute("adminName")==null){
            //非正常访问者或是超时访问者，都应该重新登录
            return "redirect:../login";
        }

        if(pageIndex==null)pageIndex=1;
        if(pageSize==null)pageSize=5;
        List<TProductProductEntity> entities = productService.list(pageIndex, pageSize);
        model.addAttribute("entities", entities);

        //分页连接组件 数据支持
        //前一页页码
        int prepage = pageIndex-1;
        if(pageIndex==1)
            prepage = 1;
        //总页数（数据表记录数16，pageSize=5，请计算一共有几页）
        int recordCount = productService.selectRecordCount();
        int totalpagenum = recordCount/pageSize;
        if((recordCount%pageSize)!=0)totalpagenum+=1;
        if(totalpagenum==0)totalpagenum=1;
        //下一页页码
        int nextpage=totalpagenum;
        if(pageIndex < totalpagenum)
            nextpage=pageIndex+1;
        model.addAttribute("prepage", prepage);
        model.addAttribute("totalpagenum", totalpagenum);
        model.addAttribute("nextpage", nextpage);
        //分页连接组件 数据支持

        //加载视图，携带列表数据
        return "sys/product/list";
    }

    //商品 添加（呈现界面）
    @GetMapping("/add")
    public ModelAndView add(ModelAndView mav, HttpSession session) {
        //权限控制
        if(session.getAttribute("adminName")==null){
            //非正常访问者或是超时访问者，都应该重新登录
            //return "redirect:login";
            mav.setViewName("redirect:../login");
        }

        List<TProductClassEntity> classEntities = classService.list();
        List<TProductBrandEntity> brandEntities = brandService.list();

        mav.addObject("classEntities", classEntities);
        mav.addObject("brandEntities", brandEntities);
        mav.setViewName("sys/product/add");
        return mav;
    }

    //数据采集
    @PostMapping("/add")
    public String add(TProductProductEntity entity, MultipartFile smallimgFile, MultipartFile bigimgFile, HttpSession session) throws IOException {

        //权限控制
        if(session.getAttribute("adminName")==null){
            //非正常访问者或是超时访问者，都应该重新登录
            return "redirect:../login";
        }

        //缩略图保存
        if(!smallimgFile.isEmpty()){
            String oldFilename = smallimgFile.getOriginalFilename();
            String fileSuffix = oldFilename.substring(oldFilename.lastIndexOf("."), oldFilename.length());
            String newFilename = UUID.randomUUID().toString().replaceAll("-", "") + fileSuffix;
            smallimgFile.transferTo(new File("D:\\imageserver\\"+newFilename));
            entity.setSmallimg(newFilename);
        }

        //原图保存
        if(!bigimgFile.isEmpty()){
            String oldFilename = bigimgFile.getOriginalFilename();
            String fileSuffix = oldFilename.substring(oldFilename.lastIndexOf("."), oldFilename.length());
            String newFilename = UUID.randomUUID().toString().replaceAll("-", "") + fileSuffix;
            bigimgFile.transferTo(new File("D:\\imageserver\\"+newFilename));
            entity.setBigimg(newFilename);
        }


        //提交服务层，调用dao层，完成数据持久化
        productService.insert(entity);
        //return "sys/admin/list";
        return "redirect:/sys/product/list";
    }

    //商品 添加（呈现界面）
    @GetMapping("/modify")
    public String modify(int productid, Model model, HttpSession session) {
        //权限控制
        if(session.getAttribute("adminName")==null){
            //非正常访问者或是超时访问者，都应该重新登录
            return "redirect:../login";
        }

        //把原来的商品数据下载回来
        TProductProductEntity entity = productService.findById(productid);

        List<TProductClassEntity> classEntities = classService.list();
        List<TProductBrandEntity> brandEntities = brandService.list();

        model.addAttribute("classEntities", classEntities);
        model.addAttribute("brandEntities", brandEntities);
        //当前商品数据
        model.addAttribute("entity", entity);
        return "sys/product/modify";
    }

    @PostMapping("/modify")
    public String modify(TProductProductEntity entity, HttpSession session){
        //权限控制
        if(session.getAttribute("adminName")==null){
            //非正常访问者或是超时访问者，都应该重新登录
            return "redirect:../login";
        }

        int result = productService.modify(entity);
        return "redirect:/sys/product/list";
    }

    @RequestMapping("/remove")
    public String remove(int productid, HttpSession session){
        //权限控制
        if(session.getAttribute("adminName")==null){
            //非正常访问者或是超时访问者，都应该重新登录
            return "redirect:../login";
        }

        //调用三层，完成删除
        int result = productService.remove(productid);

        return "redirect:/sys/product/list";
    }

}
