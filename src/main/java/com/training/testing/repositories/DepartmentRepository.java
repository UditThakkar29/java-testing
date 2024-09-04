package com.training.testing.repositories;

import com.training.testing.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
  Department findByName(String name);
}
