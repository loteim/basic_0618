package com.example.basic.intreceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.example.basic.model.UserModel;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class ServerCheckInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(
            HttpServletRequest request, HttpServletResponse response,
            Object handler) throws Exception {
        log.debug("preHandle");
        String referer = request.getHeader("referer");

        if (referer == null || referer.indexOf("localhost") == -1 || referer.indexOf("127.0.0.1") == -1) {
            response.sendRedirect("/login");
            return false;
        }
        return true;
    }

}
