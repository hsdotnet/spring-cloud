package com.hcr.springcloud.api.service.base.controller;

import com.hcr.springcloud.api.service.base.dto.UserDTO;
import com.hcr.springcloud.common.util.Result;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @PostMapping("/info")
    public UserDTO getUserInfo(String userName, String password) {
        if (userName.equals("admin") && password.equals("123456")) {
            UserDTO dto = new UserDTO();
            dto.setUserName(userName);
            dto.setPassword(password);
            dto.setUserId(10);
            //return Result.success(dto);
            return dto;
        } else {
            //return Result.error("用户名或者密码错误");
            return null;
        }
    }
}
