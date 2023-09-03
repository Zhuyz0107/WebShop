package cn.gary.dao;


import cn.gary.entities.TAdminGroupEntity;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;
/**
 * 管理员分组表 数据访问层
 */
@Component  //将该类型纳入spring容器（装对象可以让Spring管理，帮助管理类对象）
@Mapper      //根据里面实现类，实现接口让service调用
public interface TAdminGroupDao {
    @Insert("insert into t_admin_group(admingroupname) values (#{admingroupname})")
    int insert(TAdminGroupEntity entity);

    @Update("update t_admin_group set admingroupname=#{admingroupname} where admingroupid=#{admingroupid}")
    int update(TAdminGroupEntity entity);

    @Delete("delete from t_admin_group where admingroupid=#{admingroupid}")
    int delete(int admingroupid);

    @Select("select *from t_admin_group")
    List<TAdminGroupEntity> select();

    @Select("select *from t_admin_group where admingroupid=#{admingroupid}")
    TAdminGroupEntity selectById(int admingroupid);
}
