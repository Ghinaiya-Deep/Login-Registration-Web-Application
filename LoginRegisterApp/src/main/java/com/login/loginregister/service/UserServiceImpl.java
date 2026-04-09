package com.login.loginregister.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.login.loginregister.dto.LoginDto;
import com.login.loginregister.dto.UserDto;
import com.login.loginregister.entity.User;
import com.login.loginregister.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
    
    @Autowired
    private UserRepository userRepository;
    
    @Override
    public User registerUser(UserDto userDto) {
        User user = new User();
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setRole("USER");
        
        return userRepository.save(user);
    }
    
    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email).orElse(null);
    }
    
    @Override
    public boolean checkIfUserExists(String email) {
        return userRepository.existsByEmail(email);
    }
    
    @Override
    public User authenticateUser(LoginDto loginDto) {
        return userRepository.findByEmailAndPassword(
            loginDto.getEmail(), 
            loginDto.getPassword()
        ).orElse(null);
    }
}