package com.hcr.springcloud.mall.api.service;

import com.hcr.springcloud.common.util.Result;

public interface UserService {
    /**
     * @param userName
     * @param password
     * @return
     */
    Result<String> login(String userName, String password);
}
