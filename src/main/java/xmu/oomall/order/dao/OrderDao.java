package xmu.oomall.order.dao;


import com.sun.org.apache.xpath.internal.operations.Or;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import xmu.oomall.order.domain.OrderItem;
import xmu.oomall.order.domain.OrderItemPo;
import xmu.oomall.order.domain.OrderPo;
import xmu.oomall.order.mapper.OrderItemMapper;
import xmu.oomall.order.mapper.OrderMapper;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

/**
 * @author :Fy
 */
@Repository
public class OrderDao {
    @Autowired
    OrderMapper orderMapper;
    @Autowired
    OrderItemMapper orderItemMapper;

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

    public Object cancelOrder(Integer orderId) {
        orderMapper.updateOrderByOrderId(orderId,1);
        OrderPo orderPo = (OrderPo) orderMapper.getOrderPoById(orderId);
        if(null == orderPo)
        {
            return null;
        }
        else
        {
            return orderPo;
        }
    }

    public Object confirmOrder(Integer orderId) {
        orderMapper.updateOrderByOrderId(orderId,6);
        OrderPo orderPo = (OrderPo) orderMapper.getOrderPoById(orderId);
        if(null == orderPo)
        {
            return null;
        }
        else
        {
            return orderPo;
        }
    }

    public Object refundOrderItem(OrderItem orderItem) {
        orderItemMapper.updateOrderItemByOrderItemId(orderItem.getId(),5);
        OrderItemPo orderItemPo = orderItemMapper.getOrderItemPoById(orderItem.getId());
        if(null == orderItemPo) {
            return null;
        }
        else
        {
            return orderItemPo;
        }
    }
}
