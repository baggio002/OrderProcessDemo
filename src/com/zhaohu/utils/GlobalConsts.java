package com.zhaohu.utils;

import com.zhaohu.payment.PaymentProcess;

import java.util.Map;

public class GlobalConsts {

    public static final String PAYMENT_PACKAGE_NAME = PaymentProcess.class.getPackageName();
    public static final String PAYMENT_RULES_XML_FILE_NAME = "payment-rules.xml";
    public static final Map<String, String> MAP_PAYMENT_PROCESS_CLASS_STRING = Utils.makePaymentProcessClassNameMap();


    /**
     * P is status for Place Order
     * p is that order has been in payment process
     * S is payment sucess
     * f is payment fail
     * l is not enough inventory
     * s is prepare to shipment
     * D is Delivery
     * d is delivery fail
     * C is the Order Complete
     * X is Cancel
     * .....many many status
     */
    public enum OrderStatus {
        P, p, S, s, f, l, C, D, d, X,
    }

    /**
     * P is physical product
     * B is book
     * V is video
     * M is membership
     */
    public enum ItemTypes {
        B, P, V, M
    }

    /**
     * G is Guest,
     * M is MemberShip
     */
    public enum MemberShipTypes {
        G, M
    }

    public enum ShipmentPackageTypes {
        G,
    }

    static final class XmlPaymentsRules {
        public static final String PAYMENT_NODE_NAME = "payment";
        public static final String PAYMENT_ATTRIBUTE_NAME = "name";
    }
}
