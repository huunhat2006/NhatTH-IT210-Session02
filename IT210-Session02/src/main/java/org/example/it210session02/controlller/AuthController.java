package org.example.it210session02.controlller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AuthController {

    @GetMapping("/login")
    public String showLogin() {
        return "login";
    }
    @PostMapping("/login")
    public String handleLogin(@RequestParam String username, @RequestParam String password, HttpSession session, Model model) {
        if ("hn".equals(username) && "hn123".equals(password)) {
            session.setAttribute("loggedUser", "Admin");
            session.setAttribute("role", "Quản trị");
            return "redirect:/orders";
        }
        if ("hnn".equals(username) && "hnn123".equals(password)) {
            session.setAttribute("loggedUser", "Staff");
            session.setAttribute("role", "Nhân viên");
            return "redirect:/orders";
        }
        model.addAttribute("error", "Sai tài khoản hoặc mật khẩu!");
        return "login";
    }
}