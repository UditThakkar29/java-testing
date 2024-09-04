package com.training.testing.controllers;

import com.training.testing.entity.Department;
import com.training.testing.services.DepartmentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(DepartmentController.class)
public class DepartmentControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private DepartmentService departmentService;

  private Department departmentTest;

  @BeforeEach
  void setUp() {
    Department departmentTest = Department.builder().name("Sales").build();

  }

  @Test
  void saveDepartmentTest() throws Exception {
    Department inputDepartment = Department.builder().name("Sales").build();
    Mockito.when(departmentService.save(inputDepartment)).thenReturn(departmentTest);
    mockMvc.perform(MockMvcRequestBuilders.post("/department")
            .contentType(MediaType.APPLICATION_JSON)
            .content("{\n" +
                    "    \"name\": \"HR\"\n" +
                    "}"))
            .andExpect(MockMvcResultMatchers.status().isOk());
  }
}
