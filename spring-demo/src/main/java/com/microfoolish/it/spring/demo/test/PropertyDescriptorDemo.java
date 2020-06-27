package com.microfoolish.it.spring.demo.test;

import com.microfoolish.it.spring.demo.pojo.vo.UserVO;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyEditorSupport;
import java.util.stream.Stream;

public class PropertyDescriptorDemo {
	public static void main(String[] args) throws IntrospectionException {
		/**
		 * Java 内省类
		 * Introspector 可获取Java Bean中可读、可写的方法
		 * Ojbect.class 传参，用作当前类存在多个层次时，找到它的类层次父类为 Object为止
		 */
		BeanInfo beanInfo = Introspector.getBeanInfo(UserVO.class,Object.class);
		Stream.of(beanInfo.getPropertyDescriptors()).forEach(propertyDescriptor -> {
			System.out.println(propertyDescriptor);
			if ("age".equals(propertyDescriptor.getName())){
				propertyDescriptor.setPropertyEditorClass(IntegerToStringPropertyEditor.class);
				// propertyDescriptor.createPropertyEditor()
			}
		});
	}

	public static class IntegerToStringPropertyEditor extends PropertyEditorSupport {
		@Override
		public void setAsText(String text) throws IllegalArgumentException {
			Integer value = Integer.valueOf(text);
			setValue(value);
		}
	}
}
