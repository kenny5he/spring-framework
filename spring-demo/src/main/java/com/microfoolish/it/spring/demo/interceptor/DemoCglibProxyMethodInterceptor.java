package com.microfoolish.it.spring.demo.interceptor;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class DemoCglibProxyMethodInterceptor implements MethodInterceptor {

	@Override
	public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
		return null;
	}
}
