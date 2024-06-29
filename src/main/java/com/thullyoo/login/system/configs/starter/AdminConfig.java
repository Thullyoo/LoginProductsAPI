package com.thullyoo.login.system.configs.starter;

import com.thullyoo.login.system.entities.role.Role;
import com.thullyoo.login.system.entities.user.User;
import com.thullyoo.login.system.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class AdminConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {


        if (userRepository.findByEmail("admin@gmail.com").isEmpty()){

            User admin  = new User();
            admin.setEmail("admin@gmail.com");
            admin.setName("Admin 1");
            admin.setPassword(passwordEncoder.encode("123"));
            admin.setRole(Role.ADMIN);
            admin.setOrders(null);

            userRepository.save(admin);

        } else {
            System.out.println("Admin já criado!");
        }

    }
}
