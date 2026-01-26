package org.example.jwt.service;
import org.example.jwt.entity.User;
import org.example.jwt.repository.UserRepository;
import org.example.jwt.util.PasswordUtil;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository repo;

    public UserService(UserRepository repo) {
        this.repo = repo;
    }

    public User login(String username, String password) {
        User user = repo.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!PasswordUtil.match(password, user.getPassword())) {
            throw new RuntimeException("Wrong password");
        }
        return user;
    }
}
