package com.codex.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    @GetMapping("/")
    public String home() {
        return "pages/home";  // Make sure this matches your file location
    }

    @GetMapping("/learning-plan")
    public String learningPlan() {
        return "pages/learning-plan";
    }

    @GetMapping("/problems")
    public String problems() {
        return "pages/problems";
    }

    @GetMapping("/dashboard")
    public String dashboard() {
        return "pages/dashboard";
    }

    @GetMapping("/topics")
    public String topics() {
        return "pages/topics";
    }

    @GetMapping("/login")
    public String login() {
        return "pages/auth/login";
    }

    @GetMapping("/register")
    public String register() {
        return "pages/auth/register";
    }
}