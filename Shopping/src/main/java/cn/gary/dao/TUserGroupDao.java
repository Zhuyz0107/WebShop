package cn.gary.dao;


import cn.gary.entities.TUserGroupEntity;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface TUserGroupDao {
    @Insert("insert into t_user_group groupname) values (#{groupname})")
    int insert(TUserGroupEntity entity);

    @Update("update t_user_group set groupname=#{groupname} where usergroupid=#{usergroupid}")
    int update(TUserGroupEntity entity);

    @Delete("delete from t_user_group where usergroupid=#{usergroupid}")
    int delete(int usergroupid);

    @Select("select *from t_user_group")
    List<TUserGroupEntity> select();

    @Select("select *from t_user_group where usergroupid=#{usergroupid}")
    TUserGroupEntity selectById(int usergroupid);
}
