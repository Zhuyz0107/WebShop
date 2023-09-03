package cn.gary.service;

import cn.gary.dao.TOrderOrderDao;
import cn.gary.dao.TOrderOrderitemsDao;
import cn.gary.entities.TOrderCartEntity;
import cn.gary.entities.TOrderOrderEntity;
import cn.gary.entities.TOrderOrderitemsEntity;
import cn.gary.entities.TUserReceiveEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class TOrderOrderService {

    @Autowired
    TOrderCartService cartService;

    @Autowired
    TOrderOrderDao orderDao;

    @Autowired
    TOrderOrderitemsDao orderitemsDao;

    @Transactional
    public void generateOrder(int userid, TUserReceiveEntity receiver, String orderId, double sum){

        try{
            //生成订单
            TOrderOrderEntity orderOrderEntity = new TOrderOrderEntity();
            orderOrderEntity.setOrderid(orderId);
            orderOrderEntity.setUserid(userid);
            orderOrderEntity.setReceivename(receiver.getReceivename());
            orderOrderEntity.setProvince(receiver.getProvince());
            orderOrderEntity.setAddress(receiver.getAddress());
            orderOrderEntity.setTel(receiver.getTel());
            orderOrderEntity.setOrdersum(sum);
            orderOrderEntity.setOrdertime(new Timestamp(new Date().getTime()));
            orderDao.insert(orderOrderEntity);              //insert


            //生成订单明细
            List<TOrderCartEntity> cartEntities = cartService.list(userid);
            for(TOrderCartEntity cartEntity : cartEntities){
                TOrderOrderitemsEntity orderitemsEntity = new TOrderOrderitemsEntity();
                orderitemsEntity.setOrderid(orderId);
                orderitemsEntity.setProductid(cartEntity.getProductid());
                orderitemsEntity.setProductName(cartEntity.getProductName());
                orderitemsEntity.setProductPrice(cartEntity.getProductPrice());
                orderitemsEntity.setBuynum(cartEntity.getProductNum());
                orderitemsDao.insert(orderitemsEntity);         //N个insert
            }

            //清空购物车
            int result = cartService.removeByUserid(userid);    //delete
        }catch (Exception e){
            //事务回滚
            throw new RuntimeException("生成订单过程中，发生异常情况，启动事务回滚，请重新下单...");
        }

    }

}
