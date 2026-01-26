package org.example.jwt;

import org.example.jwt.entity.User;
import org.example.jwt.repository.UserRepository;
import org.example.jwt.util.PasswordUtil;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JwtApplication {

    public static void main(String[] args) {
        SpringApplication.run(JwtApplication.class, args);
        System.out.println(" JWT Application started successfully!");
    }

    // Tạo user mẫu và in ra màn hình
    @Bean
    CommandLineRunner init(UserRepository userRepository) {
        return args -> {
            User user = new User();
            user.setUsername("admin");
            user.setPassword(PasswordUtil.encode("123456"));
            user.setRole("ROLE_ADMIN");

            userRepository.save(user);

            System.out.println("User created:");
            System.out.println("Username: admin");
            System.out.println("Password: 123456");
        };
    }
}
