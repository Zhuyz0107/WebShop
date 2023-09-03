package cn.gary.entities;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class TOrderCartEntity {
    /**
     * t_order_cart
     */
    private Integer cartid;
    private String productName;
    private Double productPrice;
    private Integer productNum;
    private Timestamp buyTime;

}