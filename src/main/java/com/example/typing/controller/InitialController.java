package com.example.typing.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class InitialController {

    @RequestMapping(path = "/")
    public String redirectToTop() {
        return "redirect:/top";
    }

    @RequestMapping(path = "/top")
    public String top() {
        return "/index.html";
    }

}
