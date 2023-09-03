package cn.gary.dao;

import cn.gary.entities.TNewsClassEntity;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
/**
 * 新闻表 数据访问层
 */

public interface TNewsClassDao {
    @Insert("insert into t_news_class(className) values (#{className})")
    int insert(TNewsClassEntity entity);

    @Update("update t_news_class set className=#{className} where classId=#{classId}")
    int update(TNewsClassEntity entity);

    @Delete("delete from t_news_class where classId=#{classId}")
    int delete(int classId);

    @Select("select *from t_news_class")
    List<TNewsClassEntity> select();

    @Select("select *from t_news_class where classId=#{classId}")
    TNewsClassEntity selectById(int classId);
}