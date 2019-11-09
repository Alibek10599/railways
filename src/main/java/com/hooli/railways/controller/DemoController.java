package com.hooli.railways.controller;

import com.hooli.railways.entity.Passenger;
import com.hooli.railways.entity.Ticket;
import com.hooli.railways.entity.User;
import com.hooli.railways.repository.AgentRepository;
import com.hooli.railways.repository.PassengerRepository;
import com.hooli.railways.repository.TicketRepository;
import com.hooli.railways.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class DemoController {

    @Autowired
    TicketRepository ticketRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    PassengerRepository passengerRepository;
    @Autowired
    AgentRepository agentRepository;
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

        if (userRepository.findByUsername(user.getUsername()) != null) {
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
    public String profile(Model model) throws Exception {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication.getAuthorities().contains(new SimpleGrantedAuthority("PASSENGER"))) {

            List<Ticket> tickets = new ArrayList<>();

            for (Passenger passenger : passengerRepository.findAllById(userRepository.findByUsername(authentication.getName()).getId())) {
                tickets.addAll(ticketRepository.findAllByPassengerId(passenger.getStateId()));
            }

            model.addAttribute("tickets", tickets);
            return "userprofile";
        } else if (authentication.getAuthorities().contains(new SimpleGrantedAuthority("AGENT"))) {
            return "agentprofile";
        } else if (authentication.getAuthorities().contains(new SimpleGrantedAuthority("MANAGER"))) {

            model.addAttribute("agents", agentRepository.findAll());

            return "managerprofile";
        } else {
            throw new Exception("no authorities");
        }
    }
}
