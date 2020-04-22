package cn.stevekung.controller;

import cn.stevekung.pojo.User;
import cn.stevekung.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserServiceImpl userService;

    @RequestMapping("/users")
    @ResponseBody
    public List<User> getUsers(){
        List<User> users = userService.getUsers();
        return users;
    }

    @RequestMapping("/regist/{mail}/{password}")
    @ResponseBody
    public String regist(@PathVariable("mail") String mail,
                         @PathVariable("password") String password){
        System.out.println(mail);
        System.out.println(password);
        return "regist 成功";
    }

    @RequestMapping("/login")
    @ResponseBody
    public String login(String name, String password){
        System.out.println(name + ":" + password);
        if ("steve".equals(name) && "123456".equals(password))
            return "success";
        else
            return "error";
    }
}
