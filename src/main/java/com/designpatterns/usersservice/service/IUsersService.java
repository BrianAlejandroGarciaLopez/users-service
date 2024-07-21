package com.designpatterns.usersservice.service;

import com.designpatterns.usersservice.model.dto.UserResponseDTO;

public interface IUsersService {
    UserResponseDTO enrichUserPost(String name);
}
