package com.patsnap.search.demo.sentinel.controller;

import com.patsnap.search.demo.sentinel.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Copyright 2022 PatSnap All rights reserved.
 *
 * @author lilei
 * @date 2022/5/9
 * @since 1.0.0
 */
@RestController
@RequestMapping("/demo")
public class DemoController {
    @Autowired
    private DemoService demoService;

    @GetMapping("/sayHello")
    public String sayHello() {
        return demoService.hello(System.currentTimeMillis());
    }

    @GetMapping("/sayHi")
    public String sayHi(String name) {
        return demoService.sayHi(name);
    }
}
