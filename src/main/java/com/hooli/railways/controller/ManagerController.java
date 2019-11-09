package com.hooli.railways.controller;


import com.hooli.railways.entity.Agent;
import com.hooli.railways.entity.Station;
import com.hooli.railways.repository.AgentRepository;
import com.hooli.railways.repository.StationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ManagerController {

    @Autowired
    AgentRepository agentRepository;
    @Autowired
    StationRepository stationRepository;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @GetMapping("/insertAgent")
    public String insertAgent(Model model) {
        Agent agent = new Agent();
        model.addAttribute("agent", agent);
        return "upsertAgent";
    }

    @GetMapping("/updateAgent")
    public String updateAgent(Integer id, Model model) {
        Agent agent = agentRepository.findById(id).orElse(null);
        model.addAttribute("agent", agent);
        return "upsertAgent";
    }

    @PostMapping("/saveAgent")
    public String saveAgent(@ModelAttribute("agent") Agent agent) {
        stationRepository.save(new Station(agent.getStationName()));
        agent.setPassword(passwordEncoder.encode(agent.getPassword()));
        agentRepository.save(agent);
        return "redirect:/profile";
    }


}
