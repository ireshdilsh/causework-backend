package com.example.backend.service;

import com.example.backend.entity.UserEntity;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    UserEntity createUser(UserEntity userEntity);
}
