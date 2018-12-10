package test.com.zhaohu.service;

import com.zhaohu.entity.Order;
import com.zhaohu.service.PaymentService;
import com.zhaohu.service.Service;
import com.zhaohu.utils.GlobalConsts;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import java.util.ArrayList;
import java.util.List;

/**
 * PaymentService Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>Dec 7, 2018</pre>
 */
public class PaymentServiceTest {
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
        service = new PaymentService();
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: service(Order order)
     */
    @Test
    public void testService() throws Exception {
        service = new PaymentService();
        orders.stream()
                .forEach((order) -> {
                    service.service(order);
                    Assert.assertFalse(GlobalConsts.OrderStatus.C.name().equals(order.getStatus().name()));
                });
        // if it's in reality environment, we can check order status and many other conditions to verify test results.
    }


} 
