package xmu.oomall.order.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @Author: 数据库与对象模型标准组
 * @Description:订单明细对象
 * @Data:Created in 14:50 2019/12/11
 **/
@Getter
@Setter
@ToString
@EqualsAndHashCode(callSuper = true)
public class OrderItem extends OrderItemPo {
    private Product product;

    public OrderItem(OrderItemPo orderItemPo)
    {
        this.setProduct(null);
        this.setId(orderItemPo.getId());
        this.setOrderId(orderItemPo.getOrderId());
        this.setItemType(orderItemPo.getItemType());
        this.setStatusCode(orderItemPo.getStatusCode());
        this.setNumber(orderItemPo.getNumber());
        this.setPrice(orderItemPo.getPrice());
        this.setDealPrice(orderItemPo.getDealPrice());
        this.setGoodsId(orderItemPo.getGoodsId());
        this.setNameWithSpecifications(orderItemPo.getNameWithSpecifications());
        this.setPicUrl(orderItemPo.getPicUrl());
        this.setGmtCreate(orderItemPo.getGmtCreate());
        this.setGmtModified(orderItemPo.getGmtModified());
        this.setBeDeleted(orderItemPo.getBeDeleted());
    }
}
