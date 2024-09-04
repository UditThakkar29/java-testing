package com.training.testing.controllers;

import com.training.testing.entity.Department;
import com.training.testing.services.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/department")
@Slf4j
public class DepartmentController {

  @Autowired
  private DepartmentService departmentService;

  @PostMapping
  public Department add(@RequestBody Department department) {
    return departmentService.save(department);
  };

  @GetMapping("/{id}")
  public Department findById(@PathVariable Long id) {
    return departmentService.findById(id);
  }

}
