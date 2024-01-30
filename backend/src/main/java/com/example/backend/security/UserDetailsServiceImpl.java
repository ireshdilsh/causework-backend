package com.example.backend.security;

import com.example.backend.entity.UserEntity;
import com.example.backend.reposiory.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity=userRepository.findByUsername(username).orElse(null);

        if (userEntity==null){
           throw new UsernameNotFoundException("User not found");
        }else {
            return User.builder()
                    .username(userEntity.getUsername())
                    .password(userEntity.getPassword())
                    .build();
        }
    }
}
