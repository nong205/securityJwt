package com.example.Security.repository;

import com.example.Security.modal.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
//       User findByUsername(String username);
       User findByEmail(String email);
}
