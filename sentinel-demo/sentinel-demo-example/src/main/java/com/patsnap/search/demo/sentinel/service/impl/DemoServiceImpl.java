package com.patsnap.search.demo.sentinel.service.impl;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.patsnap.search.demo.sentinel.service.DemoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * Copyright 2022 PatSnap All rights reserved.
 *
 * @author lilei
 * @date 2022/5/9
 * @since 1.0.0
 */
@Slf4j
@Service
public class DemoServiceImpl implements DemoService {

    /**
     * 原函数
     */
    @Override
    @SentinelResource(value = "hello", blockHandler = "exceptionHandler", fallback = "helloFallback")
    public String hello(long s) {
        return String.format("Hello at %d", s);
    }

    @Override
    @SentinelResource(value = "sayHi", blockHandler = "exceptionHandler", fallback = "sayHiFallback")
    public String sayHi(String name) {
        if (name == null || "".equals(name)) {
            name = "Demo";
        }
        return "Hello: " + name;
    }

    public String sayHiFallback() {
        return "Fallback";
    }

    /**
     * Fallback 函数，函数签名与原函数一致或加一个 Throwable 类型的参数.
     */
    public String helloFallback(long s) {
        return String.format("Halooooo %d", s);
    }

    /**
     * Block 异常处理函数，参数最后多一个 BlockException，其余与原函数一致.
     */
    public String exceptionHandler(long s, BlockException ex) {
        // Do some log here.
        ex.printStackTrace();
        return "Oops, error occurred at " + s;
    }
}
