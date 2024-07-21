package com.designpatterns.usersservice.infrastructure.messaging;

import com.designpatterns.usersservice.model.dto.Post;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "posts-service")
public interface PostFeignClient {
    @GetMapping("/posts/{user_id}")
    List<Post> getPostByUserId(@PathVariable Integer user_id);
}
