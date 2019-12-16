package xmu.oomall.order.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xmu.oomall.order.dao.OrderDao;
import xmu.oomall.order.domain.Order;
import xmu.oomall.order.domain.OrderItem;
import xmu.oomall.order.domain.OrderItemPo;
import xmu.oomall.order.domain.OrderPo;
import xmu.oomall.order.service.OrderService;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderDao orderDao;


    /**
    * @Description: 获取给分享模块的订单列表
    * @Param: []
    * @return: java.util.List<xmu.oomall.order.domain.OrderPo>
    * @Author: kxw
    * @Date: 2019/12/15
    */
    @Override
    public List<Order> searchOrderForShare()
    {
        List<OrderPo> orderPoList=orderDao.getCanCalculateRebateOrderPo();
        List<Order> orderList=new ArrayList<Order>();
        for(OrderPo orderPo:orderPoList)
        {
            int id =orderPo.getId();
            //获取单个订单的订单项poList
            List<OrderItemPo> orderItemPoList=orderDao.getOrderItemPoFromOrderId(id);
            List<OrderItem> orderItemList=new ArrayList<OrderItem>() ;
            for(OrderItemPo orderItemPo:orderItemPoList)
            {
                OrderItem orderItem=new OrderItem(orderItemPo);
                orderItemList.add(orderItem);
            }
            Order tempOrder=new Order();
            tempOrder.setUserId(orderPo.getUserId());
            /*给订单赋值*/
            tempOrder.setOrderItemList(orderItemList);
            orderList.add(tempOrder);
        }
            return orderList;
    }








}
