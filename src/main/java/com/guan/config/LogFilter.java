package com.guan.config;

import java.util.Enumeration;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class LogFilter implements Filter {
    static Logger LOGGER = LoggerFactory.getLogger(LogFilter.class);

    @Override
    public void init(FilterConfig config) throws ServletException {}

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws java.io.IOException, ServletException {
        if (request instanceof HttpServletRequest) {
            String url = ((HttpServletRequest) request).getRequestURL().toString();
            String queryString = ((HttpServletRequest) request).getQueryString();
            if (!url.contains("resources")) {
                LOGGER.debug(url + "?" + queryString);
                Enumeration<String> headerNames = ((HttpServletRequest) request).getHeaderNames();
                while (headerNames.hasMoreElements()) {
                    String key = (String) headerNames.nextElement();
                    String value = ((HttpServletRequest) request).getHeader(key);
                    LOGGER.debug(key + " : " + value);
                }
            }
        }
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {}
}
