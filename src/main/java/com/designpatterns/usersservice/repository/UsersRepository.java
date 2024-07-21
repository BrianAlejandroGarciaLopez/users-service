package com.designpatterns.usersservice.repository;

import com.designpatterns.usersservice.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository <User, Integer> {
    User findByName(String name);
}
