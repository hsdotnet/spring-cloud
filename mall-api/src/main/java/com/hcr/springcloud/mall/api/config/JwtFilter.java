package com.hcr.springcloud.mall.api.config;

import com.hcr.springcloud.mall.api.dto.JwtProperty;
import com.hcr.springcloud.mall.api.util.JwtUtil;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JwtFilter extends GenericFilterBean {
    @Autowired
    private JwtProperty jwtProperty;

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpResponse = (HttpServletResponse) servletResponse;

        if ("OPTIONS".equals(httpRequest.getMethod())) {
            httpResponse.setStatus(HttpServletResponse.SC_OK);
            filterChain.doFilter(httpRequest, httpResponse);
        }

        String url = httpRequest.getRequestURI().substring(httpRequest.getContextPath().length());

        if (isInclude(url)) {
            //如果是属于排除的URL，比如登录，注册，验证码等URL，则直接通行
            httpResponse.setStatus(HttpServletResponse.SC_OK);
            filterChain.doFilter(httpRequest, httpResponse);
        }

        String token = httpRequest.getHeader("token");

        if ((token != null) && (token.length() > 7)) {
            String HeadStr = token.substring(0, 6).toLowerCase();
            if (HeadStr.compareTo("bearer") == 0) {
                token = token.substring(7, token.length());
                Claims claims = JwtUtil.parseJWT(token, jwtProperty.getBase64Secret());
                if (claims != null) {
                    System.out.println(claims);
                }
            }
        }
    }

    /**
     * 是否需要过滤
     *
     * @param url
     * @return
     */
    private boolean isInclude(String url) {
        String[] excludeUrls = jwtProperty.getExcludeUrl().split(",");
        for (String patternUrl : excludeUrls) {
            Pattern p = Pattern.compile(patternUrl);
            Matcher m = p.matcher(url);
            if (m.find()) {
                return true;
            }
        }
        return false;
    }
}
