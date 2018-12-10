package com.zhaohu.payment;

import com.zhaohu.entity.Item;
import com.zhaohu.entity.Order;
import com.zhaohu.utils.GlobalConsts;
import com.zhaohu.utils.Utils;

import java.lang.reflect.InvocationTargetException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PaymentProcessFactory {

    private PaymentProcessFactory() {

    }

    /**
     * - If the payment is for a physical product, generate a packing slip for shipping.
     * - If the payment is for a book, create a duplicate packing slip for the royalty department.
     * - If the payment is for a membership, activate that membership.
     * - If the payment is an upgrade to a membership, apply the upgrade.
     * - If the payment is for a membership or upgrade, e-mail the owner and inform them of the activation/upgrade.
     * - If the payment is for the video "Learning to Ski," add a free "First Aid" video to the packing slip (the result of a court decision in 1997).
     * - If the payment is for a physical product or a book, generate a commission payment to the agent. and so on, and so on, for seven long, long, yellow pages.
     */
    public static PaymentProcess generatePaymentProcess(Order order) throws ClassNotFoundException,
            NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        return (PaymentProcess) Class.forName(Utils.getClassNameString(GlobalConsts
                        .PAYMENT_PACKAGE_NAME,
                GlobalConsts.MAP_PAYMENT_PROCESS_CLASS_STRING.get(order.getItem().getType().name())))
                .getDeclaredConstructor().newInstance();
    }
}
