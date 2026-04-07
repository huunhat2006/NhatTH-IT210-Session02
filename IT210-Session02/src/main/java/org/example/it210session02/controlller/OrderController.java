package org.example.it210session02.controlller;


import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpSession;
import org.example.it210session02.model.Order;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Controller
public class OrderController {

    @GetMapping("/orders")
    public String showOrders(HttpSession session, Model model, ServletContext application) {
        String user = (String) session.getAttribute("loggedUser");
        if (user == null) {
            return "redirect:/login";
        }
        List<Order> list = new ArrayList<>();
        list.add(new Order("OD01", "Laptop", 15000000, new Date()));
        list.add(new Order("OD02", "Chuột", 500000, new Date()));
        list.add(new Order("OD03", "Bàn phím", 1200000, new Date()));
        model.addAttribute("orderList", list);
        AtomicInteger counter = (AtomicInteger) application.getAttribute("totalViewCount");
        if (counter == null) {
            counter = new AtomicInteger(0);
            application.setAttribute("totalViewCount", counter);
        }
        counter.incrementAndGet();
        return "orders";
    }
}