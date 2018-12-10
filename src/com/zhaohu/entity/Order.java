package com.zhaohu.entity;

import com.zhaohu.utils.GlobalConsts.OrderStatus;

import static com.zhaohu.utils.GlobalConsts.OrderStatus.p;

public class Order {
    private int orderId;
    private User user = new User();
    private Payment payment = new Payment();
    private OrderStatus status = p;
    private Shipment shipment = new Shipment();
    private Item item = new Item();
    // .. private Shipment Shipment, private Address address; and so on ...

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public Shipment getShipment() {
        return shipment;
    }

    public void setShipment(Shipment delivery) {
        this.shipment = delivery;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }
}
