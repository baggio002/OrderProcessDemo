package com.zhaohu.utils;

import com.zhaohu.payment.MembershipPaymentProcess;
import com.zhaohu.payment.PhysicalProductProcess;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Utils {
    public static final Map<String, String> PaymentProcessClassNameMap = makePaymentProcessClassNameMap();

    public static Map<String, String> makePaymentProcessClassNameMap() {
        Map<String, String> map = new HashMap<String, String>();
        Document document = null;
        try {
            document = DocumentBuilderFactory.newInstance().newDocumentBuilder()
                    .parse(GlobalConsts.PAYMENT_RULES_XML_FILE_NAME);
        } catch (SAXException e) {
            e.printStackTrace();
            // do sth for solve exception
        } catch (IOException e) {
            e.printStackTrace();
            // do sth for solve exception
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
            // do sth for solve exception
        }
        NodeList list = document.getDocumentElement()
                .getElementsByTagName(GlobalConsts.XmlPaymentsRules.PAYMENT_NODE_NAME);
        Node node;
        for (int i = 0; i < list.getLength(); i++) {
            node = list.item(i);
            map.put(node.getAttributes().getNamedItem(GlobalConsts.XmlPaymentsRules.PAYMENT_ATTRIBUTE_NAME)
                    .getNodeValue(), node.getTextContent());
        }
        return map;
    }

    public static String getClassNameString(String packageName, String className) {
        return packageName + "." + className;
    }

}
