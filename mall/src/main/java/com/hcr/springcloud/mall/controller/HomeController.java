package com.hcr.springcloud.mall.controller;

import com.hcr.springcloud.mall.config.RestTemplateConfig;
import com.hcr.springcloud.mall.service.ProductService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @Autowired
    public RestTemplateConfig restTemplateConfig;

    @RequestMapping("/index")
    @HystrixCommand(fallbackMethod = "productServiceError")
    public String index() {
        String name = restTemplateConfig.getRestTemplate().getForObject("http://PRODUCT-SERVICE/product/getName", String.class);
        //String name = productService.hello() + "abc";
        return name;
    }

    public String productServiceError() {
        return "商品服务出现异常";
    }
}
