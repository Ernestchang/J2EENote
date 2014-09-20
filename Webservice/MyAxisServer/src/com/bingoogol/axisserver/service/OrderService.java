package com.bingoogol.axisserver.service;

import com.bingoogol.axisserver.pojo.Order;

public class OrderService {

    public Order returnOrder(Order order) {
        Order newOrder = new Order();
        if(order.getId().equals("1")){
            newOrder.setName("Jacky");
        }else{
            newOrder.setName("Tom");
        }
        return newOrder;
    }
}