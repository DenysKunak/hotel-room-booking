package com.hotelroombooking.app.service.impl;

import com.hotelroombooking.app.io.entity.UserEntity;
import com.hotelroombooking.app.io.repositories.UserRepository;
import com.hotelroombooking.app.service.UserService;
import com.hotelroombooking.app.shared.Utils;
import com.hotelroombooking.app.shared.dto.UserDto;
import org.springframework.beans.BeanUtils;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final Utils utils;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, Utils utils, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.utils = utils;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDto createUser (UserDto user){

        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(user, userEntity);

        String publicUserId = utils.generateUserId(30);
        userEntity.setEncryptedPassword(passwordEncoder.encode(user.getPassword()));
        userEntity.setUserId(publicUserId);
        UserEntity storeUserDetails = userRepository.save(userEntity);

        UserDto returnValue = new UserDto();
        BeanUtils.copyProperties(storeUserDetails, returnValue);
        return returnValue;
    }

}
