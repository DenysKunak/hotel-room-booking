package com.hotelroombooking.app.user.service;

import com.hotelroombooking.app.user.shared.dto.UserDto;
import org.springframework.security.core.userdetails.UserDetailsService;


public interface UserService extends UserDetailsService {
    UserDto createUser(UserDto user);
}
