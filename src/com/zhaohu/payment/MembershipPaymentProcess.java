package com.zhaohu.payment;

import com.zhaohu.entity.Order;
import com.zhaohu.exception.PaymentCannotCompleteException;
import com.zhaohu.exception.PaymentFailException;
import com.zhaohu.exception.PaymentNotPrepareException;
import com.zhaohu.utils.GlobalConsts;

import java.time.LocalDateTime;


public class MembershipPaymentProcess extends AbstractPaymentProcess {
    @Override
    public void pay(Order order) throws PaymentFailException {
        super.pay(order);
        if (order.getUser().getMemberType() == GlobalConsts.MemberShipTypes.G) {
            // active membership, if customer is a Guest
            order.getUser().setMemberType(GlobalConsts.MemberShipTypes.M);
            order.getUser().setExpiredDate(LocalDateTime.now().plusDays(30));
            System.out.println("===Active membership!");
        } else {
            // upgrade membership
            order.getUser().setExpiredDate(order.getUser().getExpiredDate().plusDays(30));
            System.out.println("===Update Membership exired date!");
        }
    }

    @Override
    public void afterPay(Order order) throws PaymentCannotCompleteException {
        super.afterPay(order);
        // send email to Customer
        System.out.println("===Send Email to Customer!");
    }
}
