package com.bishe.main.interceptor;

import com.bishe.main.entity.User;
import com.bishe.main.service.UserService;
import com.bishe.main.util.CookieUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Kirito
 * @Date 2019/11/15 16:19
 */
@Component
public class LoginHandlerInterceptor implements HandlerInterceptor {
    public static final String COOKIE_NAME = "USER_TOKEN";

    private static String token = "";
    @Autowired
    private UserService userService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
            if (request.getSession().getAttribute("user") == null || (!token.equals("") && !this.token.equals(CookieUtils.getCookieValue(request, COOKIE_NAME)))) {
                response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
                response.setHeader("Access-Control-Allow-Methods", "*");
                response.setHeader("Access-Control-Allow-Credentials", "true");
                response.setHeader("Access-Control-Allow-Headers", "x-requested-with,content-type");
                String token = CookieUtils.getCookieValue(request, COOKIE_NAME);
                if (StringUtils.isEmpty(token)) {
                    response.sendRedirect("http://39.106.218.135:8081/bs/login");
                    return false;
                }
                this.token = token;
                if (userService == null) {
                    BeanFactory factory = WebApplicationContextUtils.getRequiredWebApplicationContext(request.getServletContext());
                    userService = (UserService) factory.getBean("userServiceImpl");
                }
                String userStr = userService.queryUserByToken(token);
                if (userStr == null) {
                    response.sendRedirect("http://39.106.218.135:8081/bs/login");
                    return false;
                }
                ObjectMapper objectMapper = new ObjectMapper();
                User user = objectMapper.readValue(userStr, User.class);
                request.getSession().setAttribute("user", user);
                request.getSession().setAttribute("token", token);
                //返回值决定handler是否执行。true：执行，false：不执行。
            }
        return true;

    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
