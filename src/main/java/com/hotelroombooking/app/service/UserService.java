package com.hotelroombooking.app.service;

import com.hotelroombooking.app.shared.dto.UserDto;


public interface UserService {
    UserDto createUser(UserDto user);
}
