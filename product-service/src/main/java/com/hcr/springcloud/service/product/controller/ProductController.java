package com.hcr.springcloud.service.product.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Value("${product.name}")
    private String name;

    @RequestMapping(value = "/getName")
    public String hi() {
        return name;
    }
}