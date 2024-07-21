package com.designpatterns.usersservice.controller;

import com.designpatterns.usersservice.model.dto.UserResponseDTO;
import com.designpatterns.usersservice.service.IUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UsersController {
    @Autowired
    private IUsersService service;
    @GetMapping("/{name}")
    private UserResponseDTO getPostByUserName(@PathVariable String name){
        return service.enrichUserPost(name);
    }
}
