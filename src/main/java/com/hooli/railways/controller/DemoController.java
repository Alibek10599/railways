package com.hooli.railways.controller;

import com.hooli.railways.entity.Passenger;
import com.hooli.railways.entity.User;
import com.hooli.railways.repository.TicketRepository;
import com.hooli.railways.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class DemoController {

    @Autowired
    TicketRepository ticketRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;


    @GetMapping("/signup")
    public String signup(Model model) {

        User user = new User();
        model.addAttribute("user", user);

        return "signup";
    }

    @PostMapping("/signup")
    public String saveLogin(@ModelAttribute("user") User user) {

        if (userRepository.findById(user.getUsername()).isPresent()) {
            return "redirect:/signup?error";
        } else {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            userRepository.save(user);
            return "redirect:/profile";
        }
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/home")
    public String home(Model model) {
        return "home";
    }

    @GetMapping("/profile")
    public String profile(Model model) {

        model.addAttribute("tickets", ticketRepository.findAll());

        return "profile";
    }

}
