package com.linkedbear.debugsource.mapperaop.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class OperationLogAspect {
    
    @Around("@annotation(com.linkedbear.debugsource.mapperaop.aop.OperationLog)")
    public Object log(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("拦截到方法执行：" + joinPoint.getSignature().getName());
        return joinPoint.proceed();
    }
}
