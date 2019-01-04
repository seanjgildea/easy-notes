package com.example.easynotes.bootstrap;

import com.example.easynotes.model.Role;
import com.example.easynotes.model.User;
import com.example.easynotes.repository.RoleRepository;
import com.example.easynotes.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;


@Component
public class DataLoader implements ApplicationListener<ContextRefreshedEvent> {

    boolean alreadySetup = false;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserRepository userRepository;

    @Bean
    PasswordEncoder getEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {

        /*
        Role adminRole = new Role();
        adminRole.setName("ROLE_ADMIN");
        roleRepository.save(adminRole);

        User user = new User();
        //user.setFirstName("Brad");
        //user.setLastName("Pitt");
        user.setPassword("password");
        //user.setMatchingPassword("password");
        user.setEmail("test@liferay.com");
        //user.setRoles(Arrays.asList(adminRole));
        //user.setEnabled(true);
        userRepository.save(user);
        */
    }
}
