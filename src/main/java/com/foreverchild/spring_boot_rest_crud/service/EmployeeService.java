package com.foreverchild.spring_boot_rest_crud.service;

import com.foreverchild.spring_boot_rest_crud.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();

    Employee save(Employee employee);

    Employee findById(int id);

    String deleteEmployee(int id);
}
