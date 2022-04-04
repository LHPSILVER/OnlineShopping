package com.example.onlineshoppingsystem.repositories;

import com.example.onlineshoppingsystem.entities.file.File;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileRepository extends JpaRepository<File, String> {
}
