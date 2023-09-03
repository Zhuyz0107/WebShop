package cn.gary.entities;

import lombok.Data;

/*
 * 收货信息表实体类
 * */
@Data
public class TUserReceiveEntity {
    private Integer receiveid;
    private Integer userid;
    private String receivename;
    private String province;
    private String tel;
    private String address;
    private Integer defult;
}
