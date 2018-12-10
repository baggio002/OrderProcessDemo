package com.zhaohu.payment;

import com.zhaohu.entity.Order;
import com.zhaohu.exception.PaymentCannotCompleteException;
import com.zhaohu.exception.PaymentFailException;
import com.zhaohu.exception.PaymentNotPrepareException;

public class BookPaymentProcess extends AbstractPaymentProcess {
    @Override
    public void pay(Order order) throws PaymentFailException {
        super.pay(order);
        System.out.println("===Generate a commission payment to the agent!");
    }

    @Override
    public void afterPay(Order order) throws PaymentCannotCompleteException {
        System.out.println("===Create a duplicate packing slip for the royalty department!");
        super.afterPay(order);
        // Create a duplicate packing slip for the royalty department.
    }
}
