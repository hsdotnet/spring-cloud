package com.hcr.springcloud.api.service.base.service;

import com.hcr.springcloud.common.dto.UserDTO;
import com.hcr.springcloud.common.util.Result;

import java.util.List;

public interface UserService {
    Result<UserDTO> getUserInfo(String userName, String password);

    Result<UserDTO> getUserInfoById(int userId);

    Result<UserDTO> getUserInfoByUserName(String userName);

    Result<List<UserDTO>> getUsers(int deptId, String userName, String email);
}
