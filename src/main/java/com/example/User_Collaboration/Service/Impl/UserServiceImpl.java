package com.example.User_Collaboration.Service.Impl;

import com.example.User_Collaboration.DTO.ResponseDTO;
import com.example.User_Collaboration.DTO.UserDTO;

import com.example.User_Collaboration.Entity.User;
import com.example.User_Collaboration.Repository.Service.UserRepoService;
import com.example.User_Collaboration.Service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private ModelMapper mapper;
    @Autowired
    private UserRepoService userRepoService;

    @Override
    public ResponseEntity<ResponseDTO> add(UserDTO userDTO) {

        if (userIsPresent(userDTO.getEmailId())) {
            User user1 = mapper.map(userDTO, User.class);
            User newUser = userRepoService.save(user1);
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseDTO(HttpStatus.OK, "user saved", newUser));
        }
        return ResponseEntity.status(HttpStatus.ALREADY_REPORTED).body(new ResponseDTO(HttpStatus.ALREADY_REPORTED, "user already saved", ""));
    }

    @Override
    public boolean userIsPresent(String emailId) {
        return userRepoService.findByEmailId(emailId).isPresent();
    }

    @Override
    public ResponseEntity<ResponseDTO> updateUser(UserDTO userDTO)
    {
        if(userIsPresent(userDTO.getEmailId()))
        {
            User newUser=userRepoService.findByEmailId(userDTO.getEmailId()).get();
            newUser.setMobileNumber(userDTO.getMobileNumber());
            newUser.setName(userDTO.getName());
            userRepoService.save(newUser);
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseDTO(HttpStatus.OK,"user been updated",newUser));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseDTO(HttpStatus.NOT_FOUND,"Email not found or maybe you are trying to modify email which is not allowed",""));
    }

    @Override
    public ResponseEntity<ResponseDTO> getUser(Long userId) {

         Optional<User> user=userRepoService.findById(userId);

//
//        if(user.isPresent())
//            return ResponseEntity.status(HttpStatus.OK).body(new ResponseDTO(HttpStatus.OK,"user Found",user.get()));
//        else
//            return ResponseEntity.status(HttpStatus.OK).body(new ResponseDTO(HttpStatus.OK,"user not found",""));

        return user.map(value -> ResponseEntity.status(HttpStatus.OK).body(new ResponseDTO(HttpStatus.OK, "user Found", value))).orElseGet(() -> ResponseEntity.status(HttpStatus.OK).body(new ResponseDTO(HttpStatus.OK, "user not found", "")));


    }

    @Override
    public ResponseEntity<ResponseDTO> userIsPresentUsingId(Long userId) {

         if(userRepoService.findById(userId).isPresent())
           return ResponseEntity.status(HttpStatus.OK).body(new ResponseDTO(HttpStatus.OK,"user found",true));
         else
          return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseDTO(HttpStatus.NOT_FOUND,"user not found",false));

    }

}
