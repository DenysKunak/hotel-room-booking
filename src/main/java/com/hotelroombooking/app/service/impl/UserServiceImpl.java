package com.hotelroombooking.app.service.impl;

import com.hotelroombooking.app.io.entity.UserEntity;
import com.hotelroombooking.app.io.repositories.UserRepository;
import com.hotelroombooking.app.service.UserService;
import com.hotelroombooking.app.shared.dto.UserDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDto createUser (UserDto user){

        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(user, userEntity);

        /*String publicUserId = utils.generateUserId(30);*/
        userEntity.setEncryptedPassword("test");
        userEntity.setUserId("testUserId");
        UserEntity storeUserDetails = userRepository.save(userEntity);

        UserDto returnValue = new UserDto();
        BeanUtils.copyProperties(storeUserDetails, returnValue);
        return returnValue;
    }

}
