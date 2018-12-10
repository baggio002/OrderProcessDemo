package com.zhaohu.payment;

import com.zhaohu.entity.Order;
import com.zhaohu.exception.PaymentCannotCompleteException;

public class VideoPaymentProcess extends AbstractPaymentProcess {
    @Override
    public void afterPay(Order order) throws PaymentCannotCompleteException {
        if ("Learning to Ski".equals(order.getItem().getName())) {
            // add a free "First Aid" video to the packing slip (the result of a court decision in 1997)
            System.out.println("add a free \"First Aid\" video to the packing slip (the result of a court decision in 1997)");
        }
        super.afterPay(order);
    }
}
