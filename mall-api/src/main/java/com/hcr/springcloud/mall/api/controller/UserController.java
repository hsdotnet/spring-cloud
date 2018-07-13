package com.hcr.springcloud.mall.api.controller;

import com.hcr.springcloud.common.dto.UserDTO;
import com.hcr.springcloud.common.util.Result;
import com.hcr.springcloud.mall.api.dto.UserLoginDTO;
import com.hcr.springcloud.mall.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    public UserService userService;

    @PostMapping("/login")
    public Result<String> login(@RequestBody UserLoginDTO dto) {
        return userService.login(dto.getUserName(), dto.getPassword());
    }

    @GetMapping("/getUserInfoById")
    public Result<UserDTO> getUserInfoById(int userId) {
        return userService.getUserInfoById(userId);
    }

    @GetMapping("/getUsers")
    public Result<List<UserDTO>> getUsers(int deptId, String userName, String email) {
        return userService.getUsers(deptId, userName, email);
    }
}