package com.example.User_Collaboration.Service;

import com.example.User_Collaboration.DTO.ResponseDTO;
import com.example.User_Collaboration.DTO.UserDTO;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
public interface UserService {
    ResponseEntity<ResponseDTO> add(UserDTO userDTO);

    boolean userIsPresent(String email);

    ResponseEntity<ResponseDTO> updateUser(UserDTO userDTO);

    ResponseEntity<ResponseDTO> getUser(Long userId);

    ResponseEntity<ResponseDTO> userIsPresentUsingId(Long userId);
}
