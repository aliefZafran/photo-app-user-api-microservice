package com.udemyspringboot.photoapp.api.users.ui.controllers;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.udemyspringboot.photoapp.api.users.service.UsersService;
import com.udemyspringboot.photoapp.api.users.shared.UserDto;
import com.udemyspringboot.photoapp.api.users.ui.model.CreateUserRequestModel;
import com.udemyspringboot.photoapp.api.users.ui.model.CreateUserResponseModel;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    UsersService usersService;

    @GetMapping("/status/check")
    public String checkServer() {
        return "Working...";
    }


    //this controller will accept the input entered by user and is mapped  into CreateUserRequestModel class first
    //then we convert the CreateUserRequestModel class into userDTO class
    @PostMapping
    public ResponseEntity<CreateUserResponseModel> createUser(@Valid @RequestBody CreateUserRequestModel userDetails){
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        //map from CreateUserRequestModel to userDto, userDto is what sent to db
        UserDto userDto = modelMapper.map(userDetails, UserDto.class);

        //userDto object is then passed to createUser method in service to encrypt pw and set uid
        UserDto createdUser = usersService.createUser(userDto);
        //now we have a createdUser object, we then want to structure the response to be sent hence we map it again
        CreateUserResponseModel responseModel = modelMapper.map(createdUser, CreateUserResponseModel.class);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseModel);
    }

}
