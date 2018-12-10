package com.zhaohu.payment;

import com.zhaohu.entity.Order;
import com.zhaohu.exception.PaymentCannotCompleteException;
import com.zhaohu.exception.PaymentFailException;
import com.zhaohu.exception.PaymentNotPrepareException;
import com.zhaohu.utils.GlobalConsts;

public abstract class AbstractPaymentProcess implements PaymentProcess {
    /**
     * before do payment, we need to check inventory or some other conditions
     * @param order
     * @throws PaymentNotPrepareException
     */
    @Override
    public void beforePay(Order order) throws PaymentNotPrepareException {
        if (order.getStatus() != GlobalConsts.OrderStatus.p) {
            throw new PaymentNotPrepareException();
        }
        // do something before pay, for example, check inventory or check payment method is valid.
    }

    /**
     * pay method, connect bank or paypal to transfer money
     * @param order
     * @throws PaymentNotPrepareException
     * @throws PaymentFailException
     */
    @Override
    public void pay(Order order) throws PaymentFailException {
        // do payment process, for instance, make trade with bank or paypal and so on.
        order.setStatus(GlobalConsts.OrderStatus.C);
        if (order.getStatus() == GlobalConsts.OrderStatus.f) {
            throw new PaymentFailException();
        }
    }

    /**
     * after payment, we have to make package and prepare to shipment
     * @param order
     * @throws PaymentCannotCompleteException
     */
    @Override
    public void afterPay(Order order) throws PaymentCannotCompleteException {
        // do something after pay, for instance, check delivery is available or whether the package can prepare.
        if (order.getStatus() != GlobalConsts.OrderStatus.C) {
            throw new PaymentCannotCompleteException();
        }
        order.setStatus(GlobalConsts.OrderStatus.s);
    }
}
