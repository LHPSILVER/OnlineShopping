package com.example.onlineshoppingsystem.repositories;

import com.example.onlineshoppingsystem.entities.user.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
}
