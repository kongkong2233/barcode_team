package org.example.springmvc.controller;

import org.example.springmvc.domain.Item;
import org.example.springmvc.domain.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class ExamController {
    @GetMapping("/welcome")
    public String welcome(Model model) {
        model.addAttribute("welcomeMsg", "환영합니다! spring MVC를 이용해봅시다.");
        List<Item> items = Arrays.asList(
                new Item("pen", 3000),
                new Item("notebook", 50000),
                new Item("cup", 2000)
        );

        model.addAttribute("itemList", items);

        return "welcome";
    }

    //url = /products
    @GetMapping("/products")
    public String products(Model model) {
        model.addAttribute("productMsg", "products 페이지 실습");
        List<Product> products = new ArrayList<>(Arrays.asList(
                new Product(1, "Apple", 1.20),
                new Product(2, "Banana", 0.75),
                new Product(3, "Cherry", 2.05)
        ));

        model.addAttribute("productList", products);

        return "products";
    }

    @GetMapping("/example")
    public String showExam(Model model) {
        model.addAttribute("username", "carami");
        model.addAttribute("isAdmin", false);
        model.addAttribute("languages", new String[]{"English", "Spanish", "German"});

        return "exam";
    }

    //http://localhost/users 사용자 목록 출력하기
    //사용자 목록에서 사용자, 관리자 여부 출력하기

    @GetMapping("/list")
    public String list(Model model) {
        List<String> items = Arrays.asList("Item 1", "Item 2", "Item 3", "Item 4", "Item 5",
                "Item 6", "Item 7", "Item 8", "Item 9", "Item 10");
        model.addAttribute("items", items);
        return "list";
    }

    @GetMapping("/datetime")
    public String datetime(Model model) {
        LocalDate date = LocalDate.now();
        LocalDateTime dateTime = LocalDateTime.now();
        LocalTime time = LocalTime.now();
        ZonedDateTime zonedDateTime = ZonedDateTime.now(ZoneId.of("Asia/Seoul"));

        model.addAttribute("currentDate", date);
        model.addAttribute("currentDateTime", dateTime);
        model.addAttribute("currentTime", time);
        model.addAttribute("currentZonedDateTime", zonedDateTime);

        return "datetime";
    }

    @GetMapping("/guest/{name}")
    public String guest(@PathVariable String name) {
        System.out.println(name);
        return "redirect:/datetime";
    }

}
