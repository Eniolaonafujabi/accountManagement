package com.semicolon.africa.data.repositories;

import com.semicolon.africa.data.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
