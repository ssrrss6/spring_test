package com.longbow.springmvc.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Method;

@RestController
public class ResquestMappingLimitTest {
    @RequestMapping(value = "test01", params = "id=1")
    public String test01() {
        return "hello";
    }

    @RequestMapping(value = "test02", method = RequestMethod.POST)
    public String test02() {
        return "hello02";
    }
}
