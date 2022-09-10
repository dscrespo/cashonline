package com.example.cashonline.controller;

import com.example.cashonline.pojo.api.user.UserTO;
import com.example.cashonline.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/{id}")
    public UserTO getUserById(@PathVariable final long id) {
    return userService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteUserById(@PathVariable final long id) {
        userService.deleteUserById(id);
    }

    @PostMapping
    public void createUser(@RequestBody final UserTO request) {
        userService.createUSer(request);
    }
}
