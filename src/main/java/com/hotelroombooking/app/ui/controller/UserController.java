package com.hotelroombooking.app.ui.controller;


import com.hotelroombooking.app.service.UserService;
import com.hotelroombooking.app.shared.dto.UserDto;
import com.hotelroombooking.app.ui.model.request.UserDetailsRequestModel;
import com.hotelroombooking.app.ui.model.response.UserRest;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.MediaType;

@RestController
@RequestMapping("/users") // http://localhost:8080/users
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping
    public UserRest getUser(){
        return null;
    }

    @PostMapping (consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE},
    produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public UserRest createUser(@RequestBody UserDetailsRequestModel userDetails) {

        UserRest returnValue = new UserRest();

        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(userDetails, userDto);

        UserDto createdUser = userService.createUser(userDto);
        BeanUtils.copyProperties(createdUser, returnValue);

        return returnValue;
    }

    @PutMapping
    public UserRest updateUser(){
        return null;
    }

    @DeleteMapping
    public UserRest deleteUser(){
        return null;
    }
}
