package com.favour.linktree_backend.user;

import org.springframework.stereotype.Service;

@Service
@SuppressWarnings("null")
public class UserService {
    
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }
}
