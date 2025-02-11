package com.linkedbear.debugsource.mapperaop.aop;

import org.aopalliance.aop.Advice;
import org.springframework.aop.support.StaticMethodMatcherPointcutAdvisor;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class OperationLogAnnotationAdvisor extends StaticMethodMatcherPointcutAdvisor {
    
    private Class<? extends Annotation> annotationClass;
    
    public OperationLogAnnotationAdvisor(Advice advice, Class<? extends Annotation> annotationClass) {
        super(advice);
        this.annotationClass = annotationClass;
    }
    
    @Override
    public boolean matches(Method method, Class<?> targetClass) {
        return method.isAnnotationPresent(annotationClass);
    }
}
