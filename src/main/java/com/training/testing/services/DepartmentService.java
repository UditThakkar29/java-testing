package com.training.testing.services;

import com.training.testing.entity.Department;
import com.training.testing.repositories.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {

  @Autowired
  private DepartmentRepository departmentRepository;

  public Department save(Department department) {
    Department d = departmentRepository.save(department);
    return d;
  }

  public Department findById(long id) {
    return departmentRepository.findById(id).get();
  }

  public Department findByName(String name) {
    return departmentRepository.findByName(name);
  }
}
