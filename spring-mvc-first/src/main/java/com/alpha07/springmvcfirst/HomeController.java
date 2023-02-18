package com.alpha07.springmvcfirst;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    // The controller will return "home" whenever "/"(root application) is requested
    // And the ViewResolver will find the home.jsp from its directory
    @RequestMapping("/")
    public String showPage(){
        return "home";
    }
}
