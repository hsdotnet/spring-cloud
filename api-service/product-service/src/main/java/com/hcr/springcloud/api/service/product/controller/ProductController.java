package com.hcr.springcloud.api.service.product.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController {

    @RequestMapping("/info")
    public String get(String name) {
        return "商品服务：" + name;
    }
}
