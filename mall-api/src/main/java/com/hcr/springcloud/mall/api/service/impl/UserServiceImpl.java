package com.hcr.springcloud.mall.api.service.impl;

import com.hcr.springcloud.common.util.Result;
import com.hcr.springcloud.mall.api.config.RestTemplateConfig;
import com.hcr.springcloud.mall.api.dto.JwtProperty;
import com.hcr.springcloud.mall.api.dto.UserDTO;
import com.hcr.springcloud.mall.api.service.UserService;
import com.hcr.springcloud.mall.api.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    public RestTemplateConfig restTemplateConfig;
    @Autowired
    public JwtProperty jwtProperty;

    @Override
    public Result<String> login(String userName, String password) {
        String url = "http://BASE-SERVICE/user/info?userName=" + userName + "&password=" + password;
        Result<UserDTO> result = restTemplateConfig.getRestTemplate().exchange(url,
                HttpMethod.POST, null, new ParameterizedTypeReference<Result<UserDTO>>() {
                }).getBody();
        if (result.getCode() == 0) {
            UserDTO user = result.getData();

            String token = JwtUtil.createJWT(user.getUserName(), String.valueOf(user.getUserId()), jwtProperty.getClientId(),
                    jwtProperty.getName(), jwtProperty.getExpiresSecond() * 1000, jwtProperty.getBase64Secret());

            return Result.success(token);
        } else {
            return Result.error(result.getMsg());
        }
    }
}
