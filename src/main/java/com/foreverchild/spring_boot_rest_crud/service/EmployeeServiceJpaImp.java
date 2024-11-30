package com.foreverchild.spring_boot_rest_crud.service;

import com.foreverchild.spring_boot_rest_crud.dao.dao_using_jpa.EmployeeRepository;
import com.foreverchild.spring_boot_rest_crud.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceJpaImp implements EmployeeService{

    private EmployeeRepository employeeRepository;

    public EmployeeServiceJpaImp(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee findById(int id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        if(employee.isEmpty()){
            throw new NullPointerException("Cannot find any employee with id:"+id);
        }
        return employee.get();
    }

    @Override
    public String deleteEmployee(int id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        if(employee.isEmpty()){
            throw new NullPointerException("Cannot find any employee with id:"+id);
        }
        employeeRepository.deleteById(id);
        return "Employee deleted";
    }
}
