package com.example.User_Collaboration.Controller;

import com.example.User_Collaboration.Api.UserApi;
import com.example.User_Collaboration.DTO.ResponseDTO;
import com.example.User_Collaboration.DTO.UserDTO;

import com.example.User_Collaboration.Repository.Service.Impl.UserRepoServiceImpl;
import com.example.User_Collaboration.Service.Impl.UserServiceImpl;
import com.example.User_Collaboration.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController implements UserApi {

    @Autowired
    private UserService userService;
    @Override
    public ResponseEntity<ResponseDTO> addUser(UserDTO userDTO) {
        return userService.add(userDTO);
    }

    @Override
    public ResponseEntity<ResponseDTO> updateUser(UserDTO userDTO) {
        return userService.updateUser(userDTO);
    }

    @Override
    public ResponseEntity<ResponseDTO> getUser(Long userId) {
        return userService.getUser(userId);
    }

    @Override
    public ResponseEntity<ResponseDTO> userIsPresentUsingId(Long userId) {
        return userService.userIsPresentUsingId(userId);
    }
}
