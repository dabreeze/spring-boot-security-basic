package com.foreverchild.spring_boot_rest_crud.dao.dao_using_jpa;

import com.foreverchild.spring_boot_rest_crud.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
}
