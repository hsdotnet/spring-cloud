package com.hcr.springcloud.mall.api.config;

import com.hcr.springcloud.mall.api.dto.JwtProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JwtConfig {

    @Autowired
    private JwtProperty jwtProperty;

    @Bean
    public FilterRegistrationBean jwtFilter() {
        final FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(new JwtFilter(jwtProperty));
        registrationBean.addUrlPatterns("/*");
        return registrationBean;
    }
}
