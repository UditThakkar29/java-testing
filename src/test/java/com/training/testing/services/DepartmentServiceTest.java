package com.training.testing.services;

import com.training.testing.entity.Department;
import com.training.testing.repositories.DepartmentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@SpringBootTest
public class DepartmentServiceTest {

  @Autowired
  private DepartmentService departmentService;

  @MockBean
  private DepartmentRepository departmentRepository;

  @BeforeEach
  void setUp() {
    Department department = Department.builder().name("HR").email("hr@gmail.com").id(1L).build();
    Mockito.when(departmentRepository.findById(1L)).thenReturn(Optional.ofNullable(department));
    Mockito.when(departmentRepository.findByName("HR")).thenReturn(department);
  }

  @Test
  @DisplayName("Get data based on valid department Name")
  public void whenValidDepartmentId_thenDepartmentShouldBeFound() {
    long departmentId = 1;
    Department found = departmentService.findById(departmentId);

    assertEquals(departmentId, found.getId());
  }

  @Test
  @DisplayName("Get data based on invalid department Name")
  public void whenInvalidDepartmentName_thenDepartmentShouldNotBeFound() {
    String name = "IT";
    Department found = departmentService.findByName("HR");

    assertNotEquals(name, found.getName());
  }
}
