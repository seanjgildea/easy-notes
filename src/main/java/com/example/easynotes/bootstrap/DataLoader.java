package com.example.easynotes.bootstrap;

import com.example.easynotes.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;


@Component
public class DataLoader implements ApplicationListener<ContextRefreshedEvent> {

    boolean alreadySetup = false;

    @Autowired
    private RoleRepository roleRepository;

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
