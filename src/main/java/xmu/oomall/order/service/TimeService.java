package xmu.oomall.order.service;


import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import xmu.oomall.order.domain.Order;

import java.util.List;

/**
 * @author kxw
 */

@Service
public class TimeService {

    //@Scheduled(cron = "0 50 0 * * ?")
    public void timeTest()
    {
        System.out.println("hahhaaa");
    }

}
