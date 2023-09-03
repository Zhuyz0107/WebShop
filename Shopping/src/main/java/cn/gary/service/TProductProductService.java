package cn.gary.service;

import cn.gary.dao.TAdminAdminDao;
import cn.gary.dao.TProductProductDao;
import cn.gary.entities.TProductProductEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//服务层
//@Component  //纳入spring管理(new TAdminAdminService ==>Dao)
@Service    //语义化注解和上面作用一样
public class TProductProductService {

 @Autowired
 TProductProductDao dao;

    //分页支持
    public List<TProductProductEntity> list(int pageIndex, int pageSize){
        //调用Dao层代码
        //根据pageIndex 1、pageSize 3 求出 offset、length

        int offset = (pageIndex-1)*pageSize;
        int length = pageSize;

        List<TProductProductEntity> entities = dao.selectPager(offset, length);
        return entities;
    }
    //分页总支持
    public int selectRecordCount(){
        return dao.selectRecordCount();
    }


    public int insert(TProductProductEntity entity){
        //dao insert

       return dao.insert(entity);
    }

  public TProductProductEntity findById(int id){
        //修改键
        TProductProductEntity entity = dao.selectById(id);
        return entity;
    }

    public int modify(TProductProductEntity entity){
        //Dao调用
        int result = dao.update(entity);
        return result;
    }

    public int remove(int id){
        //删除键
       int result= dao.delete(id);
        return result;
    }


}
