package xmu.oomall.order.dao;


import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import xmu.oomall.order.domain.OrderItemPo;
import xmu.oomall.order.domain.OrderPo;
import xmu.oomall.order.mapper.OrderMapper;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Repository
public class OrderDao {
    @Autowired
    OrderMapper orderMapper;

    /**
    * @Description: 检测当前数据库可以计算返点的OrderPo
    * @Param: []
    * @return: java.util.List<xmu.oomall.order.domain.OrderPo>
    * @Author: kxw
    * @Date: 2019/12/15
    */
    public List<OrderPo> getCanCalculateRebateOrderPo() {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime endTime=now.minusDays(7);
        LocalDateTime startTime=now.minusDays(8);
        List<OrderPo> orderPoList=orderMapper.getCanCalculateRebateOrder(startTime,endTime);
        return orderPoList;
    }

    /** 
    * @Description: 根据订单号获取符合分享可计算返点条件的订单
     * @Param: [orderId] 
    * @return: java.util.List<xmu.oomall.order.domain.OrderItemPo> 
    * @Author: kxw
    * @Date: 2019/12/15 
    */ 

    public List<OrderItemPo> getOrderItemPoFromOrderId(Integer orderId)
    {
        return orderMapper.getOrderItemPoFromOrderId(orderId);
    }

}
