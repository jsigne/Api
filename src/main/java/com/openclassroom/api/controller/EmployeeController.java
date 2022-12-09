package com.openclassroom.api.controller;

import com.openclassroom.api.model.Employee;
import com.openclassroom.api.service.EmployeeService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Data
@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    /**
     * Create - Add a new Employee
     * @param employee An object Employee
     * @return The employee object saved
     */
    @PostMapping("/employee")
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeService.saveEmployee(employee);
    }

    /**
     * Read - Get all employees
     * @return - An Iterable object of Employee full filled
     */
    @GetMapping("/employees")
    public Iterable<Employee> getEmployees() {
        return employeeService.getEmployees();
    }


    /**
     * Read - Get one employee
     * @param id The id of the employee
     * @return An Employee object full filled
     */
    @GetMapping("/employee/{id}")
    public Employee getEmployee(@PathVariable("id") final Long id) {
        Optional<Employee> employee = employeeService.getEmployee(id);
        return employee.orElse(null);
    }

    /**
     * Update - Update an employee
     * @param id The id of the employee to update
     * @return the Employee object updated
     */
    @PutMapping("/employee/{id}")
    public Employee updateEmployee(@PathVariable("id") final Long id, @RequestBody Employee employeeUpdate) {
        Optional<Employee> employee = employeeService.getEmployee(id);

        if (employee.isPresent()) {

            Employee currentEmployee = employee.get();

            String firstName = employeeUpdate.getFirstname();
            if(firstName != null) {
                currentEmployee.setFirstname(firstName);
            }
            String lastName = employeeUpdate.getLastname();
            if(lastName != null) {
                currentEmployee.setLastname(lastName);
            }
            String mail = employeeUpdate.getMail();
            if(mail != null) {
                currentEmployee.setMail(mail);
            }
            String password = employeeUpdate.getPassword();
            if(password != null) {
                currentEmployee.setPassword(password);
            }
            employeeService.saveEmployee(currentEmployee);
            return currentEmployee;
        } else {
            return null;
        }
    }

    /**
     * Delete - Delete an employee
     * @param id The id of the employee to delete
     */
    @DeleteMapping("/employee/{id}")
    public void deleteEmployee(@PathVariable("id") final Long id) {
            employeeService.deleteEmployee(id);
    }

}