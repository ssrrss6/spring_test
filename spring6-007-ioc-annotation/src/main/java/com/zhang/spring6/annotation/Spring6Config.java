package com.zhang.spring6.annotation;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({"com.zhang.spring6.annotation.dao", "com.zhang.spring6.annotation.service"})
public class Spring6Config {
}
