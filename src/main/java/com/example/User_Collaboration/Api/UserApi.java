package com.example.User_Collaboration.Api;

import ch.qos.logback.core.pattern.util.RegularEscapeUtil;
import com.example.User_Collaboration.DTO.ResponseDTO;
import com.example.User_Collaboration.DTO.UserDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@CrossOrigin
@RequestMapping("/User")
public interface UserApi {

    @PostMapping("/add")
    ResponseEntity<ResponseDTO> addUser(@RequestBody UserDTO userDTO);

   @PutMapping("/update")
    ResponseEntity<ResponseDTO> updateUser(@RequestBody UserDTO userDTO);

   @GetMapping("/get/{userId}")
    ResponseEntity<ResponseDTO> getUser(@PathVariable Long userId);

   @GetMapping("/isUser/{userId}")
    ResponseEntity<ResponseDTO> userIsPresentUsingId(@PathVariable Long userId);
}
