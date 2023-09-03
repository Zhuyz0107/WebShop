package cn.gary.dao;

import cn.gary.entities.TAdminAdminEntity;
import cn.gary.entities.TNewsNewsEntity;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface TNewsNewsDao {
    @Insert("insert into t_news_news(classId,title,content,gender,datetime,publisher)" +
            " values (#{classId},#{title},#{content},#{gender},#{datetime},#{publisher})")
    int insert(TNewsNewsEntity entity);
    @Update("update t_news_news set classId=#{classId},title=#{title},content=#{content},gender=#{gender}" +
            ",datetime=#{datetime},publisher=#{publisher} where newsId=#{newsId}")
    int update(TNewsNewsEntity entity);
    @Delete("delete from t_news_news where newsId=#{newsId}")
    int delete(int newsId);

    @Select("select *from t_news_news")
    List<TNewsNewsEntity> select();

    @Select("select *from t_news_news where newsId=#{newsId}")
    TNewsNewsEntity selectById(int newsId);
}
