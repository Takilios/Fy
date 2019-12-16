package xmu.oomall.order.service;

import org.springframework.stereotype.Service;
import xmu.oomall.order.domain.Order;
import xmu.oomall.order.domain.OrderItem;
import xmu.oomall.order.domain.OrderPo;

import java.util.List;


/**
 * @author:FY
 */
@Service
public interface OrderService {
    /**
     * @Description: 获取给分享模块的订单列表
     * @Param: []
     * @return: java.util.List<xmu.oomall.order.domain.OrderPo>
     * @Author: kxw
     * @Date: 2019/12/15
     */
    public List<Order> searchOrderForShare();

    /**
     * 取消订单
     * @param orderId
     * @return newOrder
     */
    Object cancelOrder(Integer orderId);

    /**
     * 确认订单
     * @param orderId
     * @return newOrder
     */
    Object confirmOrder(Integer orderId);

    
     /**
     * 用户查看自己的订单列表
     * @param userId
     * @param page
     * @param limit
     * @return OrderList
     */
    List<OrderPo> getOrderListByUserId(Integer userId,Integer page,Integer limit);

    /**
     * 用户查看订单详情
     * @param id
     * @return OrderItemList
     */
    List<OrderItem> getOrderDetails(Integer id);
    
    
    
    /**
     * 订单单项退货
     * @param orderItem
     * @return newOrderItem
     */
    Object refundOrderItem(OrderItem orderItem);

    /**
     * 订单付款
     * @param orderId
     * @return
     */
    Object orderPayment(Integer orderId);
}
