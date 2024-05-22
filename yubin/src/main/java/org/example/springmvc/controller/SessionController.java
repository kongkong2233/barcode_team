package org.example.springmvc.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@SessionAttributes("visitCount2")
public class SessionController {
    //HttpSession을 직접 사용한 예
//    @GetMapping("/visit2")
//    public String trackVisit(HttpSession session, Model model) {
//        //세션으로부터 방문횟수를 얻어오기
//        Integer visitCount = (Integer) session.getAttribute("visitCount");
//        if (visitCount == null) {
//            visitCount = 0; //처음 방문 시(초기값)
//        }
//        visitCount++; //방문 횟수 증가
//        session.setAttribute("visitCount", visitCount); //세션에 저장
//
//        model.addAttribute("visitCount", visitCount);
//        return "visit2";
//    }

    @ModelAttribute("visitCount2")
    public Integer initVisitCount2() { //방문 횟수 초기화
        return 0;
    }

    @GetMapping("/visit2")
    public String trackVisit(@ModelAttribute("visitCount2") Integer visitCount2,Model model) {
        visitCount2++; //방문 횟수 증가
        model.addAttribute("visitCount2", visitCount2);

        return "visit2";
    }

//    @GetMapping("/resetVisit")
//    public String resetVisit(SessionStatus status) {
//        status.setComplete(); //세션 초기화
//        return "redirect:/visit2";
//    }

    @GetMapping("/resetVisit")
    public String resetVisit(HttpSession session) {
        System.out.println(session.getAttribute("visitCount2"));
        session.removeAttribute("visitCount2");
        System.out.println(session.getAttribute("visitCount2"));
        return "redirect:/visit2";
    }
}
