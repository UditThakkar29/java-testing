package com.training.testing.repositories;

import com.training.testing.entity.Department;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;


@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class DepartmentRepositoryTest {
  @Autowired
  private DepartmentRepository departmentRepository;

  @Autowired
  private TestEntityManager entityManager; // this will act as a database for us

  @BeforeEach
  void setUp() {
    Department department = Department.builder().name("Engineering").email("engineering@gmail.com").build();
    entityManager.persist(department); // this will help us save this department in database
  }

  @Test
  @DisplayName("Find department by Valid Name")
  void whenFindDepartmentByName_thenReturnDepartment() {
    String name = "Engineering";
    Department department = departmentRepository.findByName("Engineering");

    assertEquals(name, department.getName());
  }

  @Test
  @DisplayName("Find department by Invalid Name")
  void whenFindDepartmentByInvalidName_thenDoNotReturnDepartment() {
    String name = "HR";
    Department department = departmentRepository.findByName("Engineering");

    assertNotEquals(name, department.getName());
  }

}
