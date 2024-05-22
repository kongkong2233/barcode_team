package org.example.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RoutingController {
    @GetMapping("/start")
    public String startProcess(Model model) {
        model.addAttribute("forwardTest", "forward Page~~");
        return "forward:/forward";
    }

    @GetMapping("/forward")
    public String forward() {
        return "forwardPage";
    }

    @GetMapping("/redirect")
    public String redirect(Model model) {
        model.addAttribute("redirectTest", "redirect Page~~");
        return "redirect:/finalDestination";
    }

    @GetMapping("/finalDestination")
    public String finalDestination() {
        return "redirectPage";
    }
}
