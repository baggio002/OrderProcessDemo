# OrderProcessDemo
A small demo for a tech test http://codekata.com/kata/kata16-business-rules/

I just try to write a small demo to simulate the payment process.

In this demo, if we need to add a new payment process, we need 2 step to do: 

1. create a PaymentProcess class which extends AbstractPaymentProcess and override the special part of the process. 
2. write the class name into the payment-rules.xml!

You can run the Applicatoin using main function in the com.zhaohu.Main class. I wrote a little JUnit test cases, but I know it's not enough, just for example.

As for the project, I designed a Service interface as the business logic entrance.

The part of core logic is deal those defferent payment process. I use PaymentProcessFactory to assemble the PaymentProcess according to the Item type of the order. I use reflect mechanism to design it. 

Meanwhile, I define a AbstractPaymentProcess to achieve normal payment process. If we want to reality any PaymentProcess interface, we'd better to extends AbstractPaymentProcess class. Meanwhile, I split the payment logic to 3 parts: beforePay, pay, afterPay.

I used dynamic proxy to write some logs.
