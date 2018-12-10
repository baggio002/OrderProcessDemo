package test.com.zhaohu.payment;

import com.zhaohu.entity.Order;
import com.zhaohu.exception.PaymentCannotCompleteException;
import com.zhaohu.exception.PaymentFailException;
import com.zhaohu.exception.PaymentNotPrepareException;
import com.zhaohu.payment.AbstractPaymentProcess;
import com.zhaohu.payment.PaymentProcess;
import com.zhaohu.utils.GlobalConsts;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

/**
 * AbstractPaymentProcess Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>Dec 7, 2018</pre>
 */
public class AbstractPaymentProcessTest {
    private Order order;
    private PaymentProcess paymentProcess;

    @Before
    public void before() throws Exception {
        order = new Order();
        paymentProcess = new AbstractPaymentProcess() {
            @Override
            public void beforePay(Order order) throws PaymentNotPrepareException {
                super.beforePay(order);
            }

            @Override
            public void pay(Order order) throws PaymentFailException {
                super.pay(order);
            }

            @Override
            public void afterPay(Order order) throws PaymentCannotCompleteException {
                super.afterPay(order);
            }
        };
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: beforePay(Order order)
     */
    @Test
    public void testBeforePay() throws Exception {
        paymentProcess.beforePay(order);
        Assert.assertFalse(GlobalConsts.OrderStatus.p.name().equals(order.getStatus()));
    }

    /**
     * Method: pay(Order order)
     */
    @Test
    public void testPay() throws Exception {
        paymentProcess.pay(order);
        Assert.assertFalse(GlobalConsts.OrderStatus.C.name().equals(order.getStatus()));
    }

    /**
     * Method: afterPay(Order order)
     */
    @Test
    public void testAfterPay() throws Exception {
        order.setStatus(GlobalConsts.OrderStatus.C);
        paymentProcess.afterPay(order);
        Assert.assertFalse(GlobalConsts.OrderStatus.s.name().equals(order.getStatus()));
    }


} 
