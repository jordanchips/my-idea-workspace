package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpSession;

/**
 * Description: 处理登录和注销请求
 */
@Controller
public class LoginController {

    @RequestMapping("/login")
    public String login(
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            Model model,
            HttpSession session) {

        //具体的业务
        if (!StringUtils.isEmpty(username) && "1".equals(password)) {
            //session会传到拦截器中
            session.setAttribute("loginUser", username);
            //重定向到 MyMvcConfig 中的 登录映射
            return "redirect:/main.html";
        } else {
            model.addAttribute("msg", "用户名或密码错误！");
            return "index";
        }

    }

    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/index.html";
    }

}
