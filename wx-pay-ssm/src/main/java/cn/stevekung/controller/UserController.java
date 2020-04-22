package cn.stevekung.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class UserController {

    @RequestMapping("/hello")
    public String hello(Model model){
        model.addAttribute("msg", "123456789");
        return "hello";
    }
}
