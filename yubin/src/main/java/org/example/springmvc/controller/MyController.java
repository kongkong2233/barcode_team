package org.example.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyController {
    @GetMapping("/home")
    public String name() {
        return "home";
    }

    @GetMapping("/about")
    public String about() {
        return "about";
    }

    @GetMapping("/contact")
    public String contact() {
        return "contact";
    }

    @ResponseBody
    @GetMapping("rest")
    public String rest() {
        return "restbody test!!";
    }

    @GetMapping("greeting")
    public ModelAndView greet(@RequestParam String name, ModelAndView modelAndView) {
        //http://localhost:8888/greeting?name=carami&age=20
        System.out.println(name);
//        System.out.println(age);

        modelAndView.addObject("name", name);
        modelAndView.setViewName("greeting");

        return modelAndView;
    }
}