package com.zhaohu.service;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * just use dynamic proxy to write some logs.
 */
public class ProcessExecutorProxy implements InvocationHandler {

    private Object target;

    public ProcessExecutorProxy(Object target) {
        this.target = target;
    }

    public Object getTarget() {
        return target;
    }

    public void setTarget(Object target) {
        this.target = target;
    }

    private void printLog(String str) {
        System.out.println(str);
    }

    private void beforeMethod(Method method) {
        printLog("Call " + method.getName());
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        beforeMethod(method);
        method.invoke(target, args);
        return null;
    }
}
