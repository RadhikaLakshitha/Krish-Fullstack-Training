package com.example.rentcar.repository;

import com.example.rentcar.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;

import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student,Integer> {


}
