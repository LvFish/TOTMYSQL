package com.lvfish.homework;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 *
 * 生成对于泛型T的动态代理，解析T的方法包含注解
 * @author lvFish
 * @date 2019/8/1
 * @param <T>
 */
public class TestInvocationHandler implements InvocationHandler {

    Object target;
    private static Transaction transaction;
    private static Log log;
    private static TransactionAspect transactionAspect = new TransactionAspect();
    private static LogAspect logAspect = new LogAspect();

    public TestInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println();
        Method targetMethod = target.getClass()
                .getDeclaredMethod(method.getName(), method.getParameterTypes());
        transaction = targetMethod.getAnnotation(Transaction.class);
        log = targetMethod.getAnnotation(Log.class);
        if (transaction != null) {
            transactionAspect.before();
        }
        if (log != null) {
            logAspect.before();
        }
        Object result = method.invoke(target, args);
        if (transaction != null) {
            transactionAspect.after();
        }
        if (log != null) {
            logAspect.after();
        }
        return result;
    }
}
