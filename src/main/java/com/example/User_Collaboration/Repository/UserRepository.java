package com.example.User_Collaboration.Repository;

import com.example.User_Collaboration.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long>
{

    Optional<User> findByEmailId(String emailId);
}