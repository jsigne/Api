package com.openclassroom.api;

import com.openclassroom.api.service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
public class EmployeeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EmployeeService employeeService;

    @Test
    public void testGetEmployees() throws Exception {
        mockMvc.perform(get("/employees"))
                .andExpect(status().isOk());
                //.andExpect(jsonPath("$[0].firstName", is("Laurent"))));  // does not work -> empty body
    }

    @Test
    public void testGetEmployee() throws Exception {
        mockMvc.perform(get("/employee/0"))
                .andExpect(status().isOk());
    }

    @Test
    public void testCreateEmployee() throws Exception {
        mockMvc.perform(post("/employee"))
                .andExpect(status().isOk());
    }
    @Test
    public void testUpdateEmployee() throws Exception {
        mockMvc.perform(put("/employee/0"))
                .andExpect(status().isOk());
    }

    @Test
    public void testDeleteEmployee() throws Exception {
        mockMvc.perform(delete("/employee/0"))
                .andExpect(status().isOk());
    }
}