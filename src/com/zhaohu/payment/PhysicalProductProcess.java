package com.zhaohu.payment;

import com.zhaohu.entity.Order;
import com.zhaohu.exception.PaymentCannotCompleteException;
import com.zhaohu.exception.PaymentFailException;
import com.zhaohu.exception.PaymentNotPrepareException;

public class PhysicalProductProcess extends AbstractPaymentProcess {
    @Override
    public void pay(Order order) throws PaymentFailException {
        super.pay(order);
        System.out.println("===Generate a commission payment to the agent!");
    }

    @Override
    public void afterPay(Order order) throws PaymentCannotCompleteException {
        System.out.println("===Generate a packing slip for shipping.");
        super.afterPay(order);
        // generate a packing slip for shipping.
    }
}
