package com.smart.web;

import com.smart.domain.User;
import com.smart.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Controller     // 标注成一个SpringMVC的Controller
public class LoginController {
    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    // 负责处理/index.html的请求
    @RequestMapping(value = "index.html")
    public String loginPage()
    {
        return "login";
    }

    @RequestMapping(value = "/loginVerify.html")
    public ModelAndView loginCheck(HttpServletRequest request, LoginCommand loginCommand)
    {
        boolean isValidUser = userService.hasMatchUser(loginCommand.getUserName(), loginCommand.getPassword());
        if (!isValidUser)
        {
            // 第一个参数代表视图的逻辑名，第二、第三个参数分别为数据模型名称和数据模型对象，
            // 数据模型对象将以数据模型名称为参数名放置到request的属性中
            return new ModelAndView("login", "error", "用户名或密码错误");
        }
        else
        {
            User user = userService.findUserByUserName(loginCommand.getUserName());
            user.setLastIp(request.getLocalAddr());
            user.setLastVisit(new Date());
            userService.loginSuccess(user);
            request.getSession().setAttribute("user", user);
            return new ModelAndView("main");
        }
    }
}
