package com.zhaohu.entity;

public class Payment {
    private int paymentId;
    private int money;

    // such as payment method, payment security information and so on...

    public int getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
}
