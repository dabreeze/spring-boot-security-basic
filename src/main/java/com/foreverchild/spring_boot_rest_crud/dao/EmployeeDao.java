package com.foreverchild.spring_boot_rest_crud.dao;

import com.foreverchild.spring_boot_rest_crud.entity.Employee;

import java.util.List;

public interface EmployeeDao {
    List<Employee> findAll();

    Employee save(Employee employee);

    Employee findById(int id);

    void deleteEmployee(int id);
}
