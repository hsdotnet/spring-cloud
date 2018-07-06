package com.hcr.springcloud.mall.service;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Service
//@FeignClient(value = "PRODUCT-SERVICE")
public interface ProductService {
    @RequestMapping(value = "/product/getName", method = RequestMethod.GET)
    String hello();
}
