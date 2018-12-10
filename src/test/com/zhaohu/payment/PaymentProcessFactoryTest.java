package test.com.zhaohu.payment;

import com.zhaohu.entity.Order;
import com.zhaohu.payment.PaymentProcess;
import com.zhaohu.payment.PaymentProcessFactory;
import com.zhaohu.service.Service;
import com.zhaohu.utils.GlobalConsts;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/**
 * PaymentProcessFactory Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>Dec 7, 2018</pre>
 */
public class PaymentProcessFactoryTest {
    private List<Order> orders = new ArrayList<Order>();
    private Service service;

    @Before
    public void before() throws Exception {
        int id = 0;
        Order order = new Order();
        order.setOrderId(id++);
        orders.add(order);
        order = new Order();
        order.setOrderId(id++);
        order.getItem().setType(GlobalConsts.ItemTypes.B);
        orders.add(order);
        order = new Order();
        order.setOrderId(id++);
        order.getItem().setType(GlobalConsts.ItemTypes.M);

        order = new Order();
        order.setOrderId(id++);
        order.getItem().setType(GlobalConsts.ItemTypes.M);
        order.getUser().setMemberType(GlobalConsts.MemberShipTypes.M);
        orders.add(order);
        order = new Order();
        order.setOrderId(id++);
        order.getItem().setType(GlobalConsts.ItemTypes.V);
        order.getItem().setName("Learning to Ski");
        orders.add(order);
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: generatePaymentProcess(Order order)
     */
    @Test
    public void testGeneratePaymentProcess() throws Exception {
        orders.stream().forEach((order) -> {
            try {
                PaymentProcess paymentProcess = PaymentProcessFactory.generatePaymentProcess(order);
                Assert.assertFalse(GlobalConsts.MAP_PAYMENT_PROCESS_CLASS_STRING.get(order.getItem().getType().name())
                        .equals(paymentProcess.getClass().getName()));
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
                Assert.fail(e.getMessage());
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
                Assert.fail(e.getMessage());
            } catch (IllegalAccessException e) {
                e.printStackTrace();
                Assert.fail(e.getMessage());
            } catch (InvocationTargetException e) {
                e.printStackTrace();
                Assert.fail(e.getMessage());
            } catch (InstantiationException e) {
                e.printStackTrace();
                Assert.fail(e.getMessage());
            }
        });
    }


} 
