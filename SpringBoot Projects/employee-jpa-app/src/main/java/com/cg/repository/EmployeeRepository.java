package com.cg.repository;

import com.cg.entity.Employee;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
   //findByFieldName is a derived query method, where field name is empName.
    List<Employee> findByAddress(String address);
}
