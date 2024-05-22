package org.example.springmvc.controller;

import jakarta.validation.Valid;
import org.example.springmvc.domain.Friend;
import org.example.springmvc.domain.FriendForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class FriendController {
    private List<Friend> friends = new ArrayList<>(Arrays.asList(
            new Friend(1, "kang", "kang123@email.com"),
            new Friend(2, "hong", "hong123@email.com"),
            new Friend(3, "lee", "lee123@email.com")
    ));
    @GetMapping("/friends")
    public String friendHome(Model model) {
        model.addAttribute("friendMsg", "친구 목록 사이트");
        model.addAttribute("friendList", friends);
        return "friends";
    }

    @GetMapping("/addform")
    public String showAddForm(Model model) {
        model.addAttribute("friendForm", new FriendForm());
        return "addform";
    }

    @PostMapping("/addform")
    public String addForm(@Valid @ModelAttribute("friendForm") FriendForm friendForm, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "addform";
        }
        friends.add(new Friend(friendForm.getId(), friendForm.getName(), friendForm.getEmail()));
        model.addAttribute("friendMsg", "친구 목록 사이트");
        model.addAttribute("friendList", friends);
        return "friends";
    }
}
