package cn.stevekung.controller;

import cn.stevekung.dto.ResultDTO;
import cn.stevekung.pojo.User;
import cn.stevekung.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class UserController {

    @Autowired
    UserServiceImpl userService;

    @RequestMapping("/hello")
    public String hello(Model model){
        model.addAttribute("msg", "123456789");
        return "hello";
    }

    @RequestMapping("/login")
    @ResponseBody
    public ResultDTO login(String userTel, String userPwd) {
        return userService.login(userTel, userPwd);
    }

}
