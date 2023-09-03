package cn.gary.entities;

import lombok.Data;

/**
 * t_order_orderitems
 */
@Data
public class TOrderOrderitemsEntity {

    private Integer orderitemId;
    private String orderid;
    private  Integer productid;
    private String productName;
    private Double productPrice;
    private Integer buynum;
}

