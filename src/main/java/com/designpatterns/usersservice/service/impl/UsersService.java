package com.designpatterns.usersservice.service.impl;

import com.designpatterns.usersservice.infrastructure.messaging.PostFeignClient;
import com.designpatterns.usersservice.model.dto.Post;
import com.designpatterns.usersservice.model.dto.UserResponseDTO;
import com.designpatterns.usersservice.model.entity.User;
import com.designpatterns.usersservice.repository.UsersRepository;
import com.designpatterns.usersservice.service.IUsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersService implements IUsersService {
    @Autowired
    private UsersRepository repository;
    @Autowired
    private PostFeignClient postClient;

    @Override
    public UserResponseDTO enrichUserPost(String name){

        User user = repository.findByName(name);
        List<Post> userPosts = postClient.getPostByUserId(user.getUser_id());

        UserResponseDTO response = new UserResponseDTO();
        response.setName(user.getName());
        response.setUser_id(user.getUser_id());
        response.setCellphone(user.getCellphone());
        response.setLastname(user.getLastname());
        response.setPosts(userPosts);
        return response;
    }
}
