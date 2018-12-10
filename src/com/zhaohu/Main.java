package com.zhaohu;

import com.zhaohu.entity.Order;
import com.zhaohu.service.PaymentService;
import com.zhaohu.service.Service;
import com.zhaohu.utils.GlobalConsts;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Order> orders = new ArrayList<Order>();
        Service service;
        int id = 0;
        Order order = new Order();
        order.setOrderId(id++);
        orders.add(order);
        order = new Order();
        order.setOrderId(id++);
        order.getItem().setType(GlobalConsts.ItemTypes.B);
        orders.add(order);
        order = new Order();
        order.setOrderId(id++);
        order.getItem().setType(GlobalConsts.ItemTypes.M);

        order = new Order();
        order.setOrderId(id++);
        order.getItem().setType(GlobalConsts.ItemTypes.M);
        order.getUser().setMemberType(GlobalConsts.MemberShipTypes.M);
        orders.add(order);
        order = new Order();
        order.setOrderId(id++);
        order.getItem().setType(GlobalConsts.ItemTypes.V);
        order.getItem().setName("Learning to Ski");
        orders.add(order);
        service = new PaymentService();
        orders.stream()
                .forEach((o) -> service.service(o));
    }
}
