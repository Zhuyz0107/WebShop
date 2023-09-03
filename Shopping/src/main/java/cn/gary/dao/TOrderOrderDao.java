package cn.gary.dao;

import cn.gary.entities.TOrderOrderEntity;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface TOrderOrderDao {
    @Insert("insert into t_order_order(orderid, userid,receivename, province, address, tel,ordersum,ordertime)" +
            " values (#{orderid},#{userid},#{receivename},#{province},#{address},#{tel},#{ordersum},#{ordertime})")
    int insert(TOrderOrderEntity entity);
    //@Update("update t_order_order set userid=#{userid},receiveid=#{receiveid},ordersum=#{ordersum},ordertime=#{ordertime}" +
    //        "where orderid=#{orderid}")
    //int update(TOrderOrderEntity entity);
    @Delete("delete from t_order_order where orderid=#{orderid}")
    int delete(int orderid);

    @Select("select *from t_order_order")
    List<TOrderOrderEntity> select();

    @Select("select *from t_order_order where orderid=#{orderid}")
    TOrderOrderEntity selectById(int orderid);
}
