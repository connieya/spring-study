package com.example.springbootjwt.repository;

import com.example.springbootjwt.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo  extends JpaRepository<User ,Long> {
}
