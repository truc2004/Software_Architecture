package org.example.jwt.controller;


import org.example.jwt.authen.JwtProvider;
import org.example.jwt.entity.User;
import org.example.jwt.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;
    private final JwtProvider jwtProvider;

    public AuthController(UserService userService, JwtProvider jwtProvider) {
        this.userService = userService;
        this.jwtProvider = jwtProvider;
    }

    @PostMapping("/login")
    public String login(@RequestParam String username,
                        @RequestParam String password) {
        User user = userService.login(username, password);
        return jwtProvider.generateToken(user.getUsername());
    }
}
