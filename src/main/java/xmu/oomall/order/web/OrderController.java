package xmu.oomall.order.web;


import com.sun.org.apache.xpath.internal.objects.XObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xmu.oomall.order.Util.JacksonUtil;
import xmu.oomall.order.mapper.OrderMapper;
import xmu.oomall.order.web.VO.OrderSubmitVo;
import xmu.oomall.order.domain.*;
import xmu.oomall.order.service.OrderService;
import xmu.oomall.order.Util.ResponseUtil;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * @author Fy
 */
@RestController
public class OrderController {
    @Autowired
    private OrderService orderService;

    /**
     * 提交订单
     * @param userId
     * @param submitVo
     * @return retOrder
     */
    @PostMapping("/orders")
    public Object submitOrder(@RequestHeader Integer userId, @RequestBody OrderSubmitVo submitVo)
    {
        Address address = new Address();
        OrderPo orderPo = new OrderPo();
        orderPo.setAddress(JacksonUtil.toJson(address));
        orderPo.setConsignee(address.getConsignee());
        orderPo.setMobile(address.getMobile());
        orderPo.setUserId(userId);
        return  ResponseUtil.ok();
    }

    /**
     * 取消订单
     * @param orderId
     * @param order
     * @return order
     */
    @PutMapping("/orders/{orderId}/cancel")
    public Object cancelOrder(@PathVariable Integer orderId,@RequestBody Order order)
    {
        orderService.cancelOrder(orderId);
        return ResponseUtil.ok();
    }

    /**
     * 确认订单
     * @param orderId
     * @param order
     * @return
     */
    @PutMapping("/orders/{orderId}/confirm")
    public Object confirm(@PathVariable Integer orderId,@RequestBody Order order)
    {
        orderService.confirmOrder(orderId);
        return ResponseUtil.ok();
    }

    /**
     * 订单退货
     * @param orderId
     * @param orderItem
     * @return
     */
    @PostMapping("/orders/{orderId}/refund")
    public Object orderRefund(@PathVariable Integer orderId,@RequestBody OrderItem orderItem)
    {
        orderService.refundOrderItem(orderItem);
        return ResponseUtil.ok();
    }

    /**
     * 创建订单支付
     * @param orderId
     * @return
     */
    @PostMapping("/orders/{orderId}/payment")
    public Object orderPayment(@PathVariable Integer orderId)
    {
        orderService.orderPayment(orderId);
        return ResponseUtil.ok();
    }

    /**
     * 管理员查看订单
     * @param userId
     * @param page
     * @param limit
     * @param orderSn
     * @param orderStatusArray
     * @return orderList
     */
    @GetMapping("/admin/orders")
    public Object adminGetOrders(@RequestHeader Integer userId
            ,@RequestParam Integer page
            ,@RequestParam Integer limit
            ,@RequestParam Integer orderSn
            ,@RequestParam List<Short> orderStatusArray)
    {

        return ResponseUtil.ok();
    }

    /**
     * 管理员查看订单详情
     * @param orderId
     * @return order
     */
    @GetMapping("/admin/orders/{orderId}")
    public Object adminGetOrderById(@PathVariable Integer orderId)
    {

        return ResponseUtil.ok();
    }

    /**
     * 管理员确认退货
     * @param orderId
     * @return
     */
    @PostMapping("/admin/orders/{orderId}/refund")
    public Object adminRefundOrder(@PathVariable Integer orderId)
    {
        return ResponseUtil.ok();
    }

    /**
     * 管理员发货订单
     * @param orderId
     * @return
     */
    @PostMapping("/orders/{orderId}/ship")
    public Object adminShipOrder(@PathVariable Integer orderId)
    {
        return ResponseUtil.ok();
    }
}
