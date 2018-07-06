package com.hcr.springcloud.mall.api.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {

    @RequestMapping("/getOrderInfo")
    public String get(String name) {
        return "mall-api：" + name;
    }
}
