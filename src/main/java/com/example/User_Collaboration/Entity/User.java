package com.example.User_Collaboration.Entity;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "user_info")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(name = "user_name")
    private String name;

    @Column(name = "emailId")
    private String emailId;

    @Column(name = "mobileNumber")
    private String mobileNumber;

    @Column(name = "role")
    private String role;

    @Column(name ="isActive")
    private Boolean isActive;

}
