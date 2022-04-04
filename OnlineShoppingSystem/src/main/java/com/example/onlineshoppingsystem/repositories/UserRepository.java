package com.example.onlineshoppingsystem.repositories;

import com.example.onlineshoppingsystem.entities.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
