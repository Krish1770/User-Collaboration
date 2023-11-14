package com.example.User_Collaboration.Repository.Service;

import com.example.User_Collaboration.Entity.User;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public interface UserRepoService {

    User save(User user);

    Optional<User> findByEmailId(String emailId);

    Optional<User> findById(Long userId);
}
