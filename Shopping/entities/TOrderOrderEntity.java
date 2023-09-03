package cn.gary.entities;

import lombok.Data;

import java.sql.Timestamp;

/*
 * 订单信息表实体类
 * */
@Data
public class TOrderOrderEntity {
    private Integer orderid;
    private Integer userid;
    private Integer receiveid;
    private Double ordersum;
    private Timestamp ordertime;
}
