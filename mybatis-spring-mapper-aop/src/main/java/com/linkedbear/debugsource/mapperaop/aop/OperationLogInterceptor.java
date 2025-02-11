package com.linkedbear.debugsource.mapperaop.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class OperationLogInterceptor implements MethodInterceptor {
    
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        System.out.println("OperationLogInterceptor拦截到方法执行：" + invocation.getMethod().getName());
        return invocation.proceed();
    }
}
