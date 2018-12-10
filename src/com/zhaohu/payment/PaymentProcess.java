package com.zhaohu.payment;

import com.zhaohu.entity.Order;
import com.zhaohu.exception.PaymentCannotCompleteException;
import com.zhaohu.exception.PaymentFailException;
import com.zhaohu.exception.PaymentNotPrepareException;

public interface PaymentProcess {
    public void beforePay(Order order) throws PaymentNotPrepareException;
    public void pay(Order order) throws PaymentFailException;
    public void afterPay(Order order) throws PaymentFailException, PaymentCannotCompleteException;
}
