package cn.gary.service;


import cn.gary.dao.TAdminGroupDao;
import cn.gary.entities.TAdminGroupEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TAdminGroupService {

    @Autowired
    TAdminGroupDao dao;

    public List<TAdminGroupEntity> list(){
        //shift alt l
        List<TAdminGroupEntity> groups=dao.select();
        return groups;
    }

}
