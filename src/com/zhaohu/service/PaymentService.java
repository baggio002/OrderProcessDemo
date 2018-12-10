package com.zhaohu.service;

import com.zhaohu.entity.Order;
import com.zhaohu.exception.PaymentCannotCompleteException;
import com.zhaohu.exception.PaymentFailException;
import com.zhaohu.exception.PaymentNotPrepareException;
import com.zhaohu.payment.PaymentProcess;
import com.zhaohu.payment.PaymentProcessFactory;
import com.zhaohu.utils.GlobalConsts;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Proxy;

import static java.lang.reflect.Proxy.newProxyInstance;

public class PaymentService implements Service<Order> {

    // if the service is not in any java container(like servlet or Spring), we should consider to use multi threads work.
    // I just consider one order with one item, if an order with many items, we should split the order and make every order with single item.
    @Override
    public void service(Order order) {
        PaymentProcess paymentProcess = null;
        System.out.println(" ====PAYMENT PROCESS BEGIN!====");
        System.out.println(" Deal the Order " + order.getOrderId() + ", and the item type is: " + order.getItem()
                .getType().name());
        try {
            Class cls[] = {PaymentProcess.class};
            paymentProcess = (PaymentProcess) Proxy.newProxyInstance(PaymentProcess.class.getClassLoader(), cls,
                    new ProcessExecutorProxy(PaymentProcessFactory.generatePaymentProcess(order)));
            paymentProcess.beforePay(order);
            paymentProcess.pay(order);
            paymentProcess.afterPay(order);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            // to do
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
            // to do
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            // to do
        } catch (InvocationTargetException e) {
            e.printStackTrace();
            // to do
        } catch (InstantiationException e) {
            e.printStackTrace();
            // to do
        } catch (PaymentNotPrepareException e) {
            e.printStackTrace();
            // to do
        } catch (PaymentFailException e) {
            e.printStackTrace();
            // to do
        } catch (PaymentCannotCompleteException e) {
            e.printStackTrace();
            // to do
        }
        // go to next step
        System.out.println(" ====PAYMENT PROCESS FINISH!====");
    }
}
