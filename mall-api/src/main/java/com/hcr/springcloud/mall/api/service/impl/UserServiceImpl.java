package com.hcr.springcloud.mall.api.service.impl;

import com.hcr.springcloud.common.util.Result;
import com.hcr.springcloud.mall.api.config.RestTemplateConfig;
import com.hcr.springcloud.mall.api.dto.UserDTO;
import com.hcr.springcloud.mall.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    public RestTemplateConfig restTemplateConfig;

    @Override
    public Result<String> login(String userName, String password) {
        System.out.println(userName);
        UserDTO result = restTemplateConfig.getRestTemplate().getForObject("http://BASE-SERVICE/user/info?userName=admin&password=123456", UserDTO.class);
        System.out.println(result);
        return Result.error("用户名或密码错误");
    }
}
