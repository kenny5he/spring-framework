package com.microfoolish.it.spring.demo.config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;

@Configurable
@ComponentScan("com.microfoolish.it")
@ImportResource("classpath:applicationContext.xml")
public class AppConfig {

}
