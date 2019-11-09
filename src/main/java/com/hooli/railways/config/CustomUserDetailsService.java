package com.hooli.railways.config;

import com.hooli.railways.entity.*;
import com.hooli.railways.repository.AgentRepository;
import com.hooli.railways.repository.ManagerRepository;
import com.hooli.railways.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    ManagerRepository managerRepository;
    @Autowired
    AgentRepository agentRepository;
    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        CustomUserDetails userDetails = new CustomUserDetails();

        Manager manager = managerRepository.findByUsername(username);
        Agent agent = agentRepository.findByUsername(username);
        User user = userRepository.findByUsername(username);

        if (manager != null) {
            userDetails.setPerson(new Person(manager.getUsername(), manager.getPassword(), "MANAGER"));
        } else if (agent != null) {
            userDetails.setPerson(new Person(agent.getUsername(), agent.getPassword(), "AGENT"));
        } else if (user != null) {
            userDetails.setPerson(new Person(user.getUsername(), user.getPassword(), "PASSENGER"));
        } else {
            throw new UsernameNotFoundException("User not exist with name : " + username);
        }

        return userDetails;
    }
}
