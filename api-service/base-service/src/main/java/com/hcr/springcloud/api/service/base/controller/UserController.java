package com.hcr.springcloud.api.service.base.controller;

import com.hcr.springcloud.api.service.base.service.UserService;
import com.hcr.springcloud.common.dto.UserDTO;
import com.hcr.springcloud.common.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/getUserInfo")
    public Result<UserDTO> getUserInfo(String userName, String password) {
        return userService.getUserInfo(userName, password);
    }

    @GetMapping("/getUserInfoById")
    public Result<UserDTO> getUserInfoById(int userId) {
        return userService.getUserInfoById(userId);
    }

    @GetMapping("/getUserInfoByUserName")
    public Result<UserDTO> getUserInfoByUserName(String userName) {
        return userService.getUserInfoByUserName(userName);
    }

    @GetMapping("/getUsers")
    public Result<List<UserDTO>> getUsers(int deptId, String userName, String email) {
        return userService.getUsers(deptId, userName, email);
    }
}
