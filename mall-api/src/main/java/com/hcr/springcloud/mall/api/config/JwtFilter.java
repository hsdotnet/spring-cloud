package com.hcr.springcloud.mall.api.config;

import com.hcr.springcloud.mall.api.dto.JwtProperty;
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

    private final JwtProperty jwtProperty;

    public JwtFilter(JwtProperty jwtProperty) {
        super();
        this.jwtProperty = jwtProperty;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        if ("OPTIONS".equals(request.getMethod())) {
            response.setStatus(HttpServletResponse.SC_OK);
            chain.doFilter(servletRequest, servletResponse);
        }

        String url = request.getRequestURI().substring(request.getContextPath().length());

        System.out.println(url);

        if (isInclude(url)) {
            //如果是属于排除的URL，比如登录，注册，验证码等URL，则直接通行
            response.setStatus(HttpServletResponse.SC_OK);
            chain.doFilter(servletRequest, servletResponse);
        }

        String token = request.getHeader("token");

        if ((token != null) && (token.length() > 7)) {
            String HeadStr = token.substring(0, 6).toLowerCase();
            if (HeadStr.compareTo("bearer") == 0) {
                token = token.substring(7, token.length());
                System.out.println(token);
                //Claims claims = JwtUtil.parseJWT(token, jwtProperty.getBase64Secret());
                //if (claims != null) {
                // System.out.println(claims);
                //}
            }
        }

        chain.doFilter(servletRequest, servletResponse);
    }

    /**
     * 是否需要过滤
     *
     * @param url
     * @return
     */
    private boolean isInclude(String url) {
        String excludeUrl = jwtProperty.getExcludeUrl();
        if (excludeUrl != null) {
            String[] excludeUrls = excludeUrl.split(",");
            for (String patternUrl : excludeUrls) {
                Pattern p = Pattern.compile(patternUrl);
                Matcher m = p.matcher(url);
                if (m.find()) {
                    return true;
                }
            }
        }
        return false;
    }
}
