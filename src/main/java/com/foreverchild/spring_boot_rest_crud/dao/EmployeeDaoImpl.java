package com.foreverchild.spring_boot_rest_crud.dao;

import com.foreverchild.spring_boot_rest_crud.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDaoImpl implements EmployeeDao{

    private EntityManager entityManager;

    @Autowired
    public EmployeeDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findAll() {
        TypedQuery<Employee> theQuery = entityManager.createQuery("FROM Employee",Employee.class);
        return theQuery.getResultList();
    }

    @Override
    public Employee save(Employee employee) {

        Employee singleEmployee = entityManager.merge(employee);
        return singleEmployee;
    }

    @Override
    public Employee findById(int id) {
        return entityManager.find(Employee.class,id);
    }

    @Override
    public void deleteEmployee(int id) {
        Employee theEmployee = entityManager.find(Employee.class,id);
        entityManager.remove(theEmployee);
    }
}
