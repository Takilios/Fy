package xmu.oomall.order.service;


import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import xmu.oomall.order.OrderApplication;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import xmu.oomall.order.dao.OrderDao;
import xmu.oomall.order.domain.Order;
import xmu.oomall.order.domain.OrderItem;
import xmu.oomall.order.domain.OrderItemPo;
import xmu.oomall.order.domain.OrderPo;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes= OrderApplication.class)
public class ShareServiceTest {

    @Autowired
    OrderService orderService;
    @Autowired
    OrderDao orderDao;


    @Test
    public void test()
    {
        /*
        List<Order> orderList=orderService.searchOrderForShare();
        for(Order order:orderList)
        {
            List<OrderItem> orderItemList=order.getOrderItemList();
            for(OrderItem orderItem:orderItemList)
            {
                System.out.println(orderItem.getOrderId());
            }
        }
        */
    }


}
