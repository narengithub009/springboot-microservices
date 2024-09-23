package com.java.microservices.product.config;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;


@Component
public class RequestResponseLoggingInterceptor implements HandlerInterceptor {

    private static final Logger log = LoggerFactory.getLogger(RequestResponseLoggingInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // Log the incoming request details
        log.info("Incoming request: {} {}", request.getMethod(), request.getRequestURI());
        return true;  // Continue processing the request
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        // Log the outgoing response details
        log.info("Response: {} {}, status: {}", response.getStatus(), response.getContentType(), response.getHeader("X-Products-Count"));
    }
}