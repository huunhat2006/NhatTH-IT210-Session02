package org.example.it210session02b5.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AuthController {

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password, HttpSession session, Model model) {
        if ("hr_manager".equals(username) && "hr123".equals(password)) {
            session.setAttribute("loggedUser", username);
            session.setAttribute("role", "hr_manager");
            return "redirect:/employees";
        }
        if ("hr_staff".equals(username) && "staff456".equals(password)) {
            session.setAttribute("loggedUser", username);
            session.setAttribute("role", "hr_staff");
            return "redirect:/employees";
        }
        model.addAttribute("errorMessage", "Sai tài khoản hoặc mật khẩu");
        return "login";
    }
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }
}