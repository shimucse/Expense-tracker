package com.project.expensetracker.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/home")
    public String home() {
        return "home";
    }

    @GetMapping("/")
    public String showLoginPage() {
        return "login";
    }
    @GetMapping("/access-denied")
    public String accessDenied(){
        return "access-denied";
    }

}
