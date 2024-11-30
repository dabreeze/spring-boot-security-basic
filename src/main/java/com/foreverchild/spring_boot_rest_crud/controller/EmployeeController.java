package com.foreverchild.spring_boot_rest_crud.controller;

import com.foreverchild.spring_boot_rest_crud.entity.Employee;
import com.foreverchild.spring_boot_rest_crud.service.EmployeeService;
import com.foreverchild.spring_boot_rest_crud.service.EmployeeServiceJpaImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {
    private EmployeeServiceJpaImp employeeService;

    @Autowired
    public void setEmployeeDao(EmployeeServiceJpaImp employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<Employee> getAllEmployees(){
        return employeeService.findAll();
    }

    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId){
        Employee employee = employeeService.findById(employeeId);
        return employee;
    }

    @PostMapping("/employees")
    public Employee saveEmployee(@RequestBody Employee employeeBody){
        employeeBody.setId(null);
        Employee employee = employeeService.save(employeeBody);
        return employee;
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employeeBody){
        Employee employee = employeeService.save(employeeBody);
        return employee;
    }

    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId){
         String response = employeeService.deleteEmployee(employeeId);
         return response;
    }
}
