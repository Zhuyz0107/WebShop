package cn.gary.service;

import cn.gary.dao.TAdminAdminDao;
import cn.gary.entities.TAdminAdminEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;

//服务层
//@Component  //纳入spring管理(new TAdminAdminService ==>Dao)
@Service    //语义化注解和上面作用一样
public class TAdminAdminService {

 @Autowired
    TAdminAdminDao dao;

    public TAdminAdminEntity login(String adminName,String adminPwd){
//调用dao层代码完成验证
      TAdminAdminEntity adminUser= dao.selectByNameAndPwd(adminName,adminPwd);
      return adminUser;
    }
    public int modifyPwd(String adminName,String adminPwd){
        //调用dao层代码
      int result= dao.updateUserPwd(adminName,adminPwd);
      return result;
    }
    //管理员列表
    //maodel仅限于控制器和页面之间
     public List<TAdminAdminEntity>  list (){
      //调用dao层代码
        List<TAdminAdminEntity> entities= dao.select();

        return entities;
    }


    //分页支持
    public List<TAdminAdminEntity> list(int pageIndex, int pageSize){
        //调用Dao层代码
        //根据pageIndex 1、pageSize 3 求出 offset、length

        int offset = (pageIndex-1)*pageSize;
        int length = pageSize;

        List<TAdminAdminEntity> entities = dao.selectPager(offset, length);
        return entities;
    }
    //分页总支持
    public int selectRecordCount(){
        return dao.selectRecordCount();
    }


    public int insert(TAdminAdminEntity entity){
        //dao insert

       return dao.insert(entity);
    }

  public TAdminAdminEntity findById(int id){
        //修改键
        TAdminAdminEntity entity = dao.selectById(id);
        return entity;
    }

    public int modify(TAdminAdminEntity entity){
        //修改键
        int result = dao.update(entity);
        return result;
    }

    public int remove(int adminid){
        //删除键
       int result= dao.delete(adminid);
        return result;
    }


}
