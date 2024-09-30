package com.semicolon.africa.data.models;

import com.semicolon.africa.data.models.enums.Industry;
import com.semicolon.africa.data.models.enums.Role;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    @Enumerated(EnumType.STRING)
    private Industry industry;
    @Enumerated(EnumType.STRING)
    private Role role;


}
