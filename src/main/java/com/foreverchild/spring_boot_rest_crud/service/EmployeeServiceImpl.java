package com.foreverchild.spring_boot_rest_crud.service;

import com.foreverchild.spring_boot_rest_crud.dao.EmployeeDao;
import com.foreverchild.spring_boot_rest_crud.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeDao employeeDao;

    @Autowired
    public EmployeeServiceImpl(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    @Override
    public List<Employee> findAll() {
        return employeeDao.findAll();
    }

    @Override
    @Transactional
    public Employee save(Employee employee) {
        return employeeDao.save(employee);
    }

    @Override
    public Employee findById(int id) {
        return employeeDao.findById(id);
    }

    @Override
    @Transactional
    public String deleteEmployee(int id) {
        Employee employee = employeeDao.findById(id);
        if(employee == null){
            throw new NullPointerException("No data found");
        }
        employeeDao.deleteEmployee(id);
        return "Employee with id "+id+" deleted";

    }
}
