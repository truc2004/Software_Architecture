package org.example.data_partition_horizontal.Controller;

import org.example.data_partition_horizontal.Request.UserRequest;
import org.example.data_partition_horizontal.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/users")
    public String createUser(@RequestBody UserRequest req) {

        System.out.println("Name: " + req.getName());
        System.out.println("Gender: " + req.getGender());
        System.out.println("Age: " + req.getAge());

        userService.saveUser(req.getName(), req.getGender(), req.getAge());

        return "Insert OK!";
    }
}