package malgepav.dz7basic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyController {
    @GetMapping("/public-data")
    public String userPage(){
        return "PublicPage.html";
    }

    @GetMapping("/private-data")
    public String adminPage(){
        return "PrivatePage.html";
    }

    @GetMapping("/login")
    public String auth(){
        return "LoginPage.html";
    }

}
