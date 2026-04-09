package com.login.loginregister.service;

import com.login.loginregister.dto.LoginDto;
import com.login.loginregister.dto.UserDto;
import com.login.loginregister.entity.User;

public interface UserService {
    User registerUser(UserDto userDto);
    User findByEmail(String email);
    boolean checkIfUserExists(String email);
    User authenticateUser(LoginDto loginDto);
}