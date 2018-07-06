package com.hcr.springcloud.api.service.order.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {

    @RequestMapping("/info")
    public String get(String name) {
        return "订单服务：" + name;
    }
}
