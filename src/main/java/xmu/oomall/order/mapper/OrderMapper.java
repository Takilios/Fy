package xmu.oomall.order.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import xmu.oomall.order.domain.OrderItemPo;
import xmu.oomall.order.domain.OrderPo;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.*;

/**
 * @author :Fy
 */
@Mapper
public interface OrderMapper {


    /**
    * @Description: 获得今天到七天的订单，但未到八天(到八天的应该之前被计算过)的订单
    * @Param: [startTime, endTime]
    * @return: java.util.List<xmu.oomall.order.domain.OrderPo>
    * @Author: kxw
    * @Date: 2019/12/16
    */
    public List<OrderPo> getCanCalculateRebateOrder(@Param("startTime") LocalDateTime startTime, @Param("endTime")LocalDateTime endTime);

    /**
    * @Description: 根据订单号获取符合分享可计算返点条件的订单
    * @Param: orderId
    * @return: java.util.List<xmu.oomall.order.domain.OrderItemPo>
    * @Author: kxw
    * @Date: 2019/12/16
    */
    public List<OrderItemPo> getOrderItemPoFromOrderId(@Param("orderId") Integer orderId);

    /**
     * 更改订单状态
     * @param orderId
     * @param status
     * @return newOrder
     */
    Object updateOrderByOrderId(Integer orderId,Integer status);

    /**
     * 获取订单Po
     * @param orderId
     * @return
     */
    Object getOrderPoById(Integer orderId);

}
