/*
 * Copyright 2002-2011 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.beans.factory;

/**
 * 可通过Aware获取Spring容器本身的功能资源
 * 例:
 * 		1、ApplicationContextAware   能获取Application Context调用容器的服务
 * 		2、BeanNameAware    提供对BeanName进行操作
 * 		3、ApplicationEventPublisherAware   主要用于事件的发布
 * 		4、BeanClassLoadAware 相关的类加载器
 * 		5、BeanFactoryAware 声明BeanFactory，通过其获取BeanFactory，通过BeanFactory将普通Java对象封装为Spring Bean注册到Spring 容器中。
 *		6. ResourceLoaderAware 加载资源(基本不用，一般使用new ClassPathResource加载资源)
 * Marker superinterface indicating that a bean is eligible to be
 * notified by the Spring container of a particular framework object
 * through a callback-style method. Actual method signature is
 * determined by individual subinterfaces, but should typically
 * consist of just one void-returning method that accepts a single
 * argument.
 *
 * <p>Note that merely implementing {@link Aware} provides no default
 * functionality. Rather, processing must be done explicitly, for example
 * in a {@link org.springframework.beans.factory.config.BeanPostProcessor BeanPostProcessor}.
 * Refer to {@link org.springframework.context.support.ApplicationContextAwareProcessor}
 * and {@link org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory}
 * for examples of processing {@code *Aware} interface callbacks.
 *
 * @author Chris Beams
 * @since 3.1
 */
public interface Aware {

}
