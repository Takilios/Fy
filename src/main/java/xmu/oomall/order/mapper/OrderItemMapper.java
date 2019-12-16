package xmu.oomall.order.mapper;

import xmu.oomall.order.domain.OrderItemPo;

/**
 * @Author: FY
 * @ModifiedDate: 1:11 2019/12/17
 * @ModifiedBy:
 * @Version:1.0
 */
public interface OrderItemMapper {
    /**
     * 更新订单单项状态
     * @param orderId
     * @param status
     */
    void updateOrderItemsByOrderId(Integer orderId, Integer status);

    /**
     * 更新订单单项
     * @param orderItemId
     * @param status
     */
    void updateOrderItemByOrderItemId(Integer orderItemId,Integer status);

    /**
     * 获取orderItem
     * @param orderItemId
     * @return orderItem
     */
    OrderItemPo getOrderItemPoById(Integer orderItemId);
}
