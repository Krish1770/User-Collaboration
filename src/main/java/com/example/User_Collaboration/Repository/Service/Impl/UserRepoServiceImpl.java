package com.example.User_Collaboration.Repository.Service.Impl;

import com.example.User_Collaboration.Entity.User;
import com.example.User_Collaboration.Repository.Service.UserRepoService;
import com.example.User_Collaboration.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserRepoServiceImpl implements UserRepoService {

 @Autowired
 private UserRepository userRepository;
 @Override
 public User save(User user) {
  userRepository.save(user);
  return user;
 }

 @Override
 public Optional<User> findByEmailId(String emailId) {
  return userRepository.findByEmailId(emailId);
 }

 @Override
 public Optional<User> findById(Long userId) {
  return userRepository.findById(userId);
 }

 ;
}
