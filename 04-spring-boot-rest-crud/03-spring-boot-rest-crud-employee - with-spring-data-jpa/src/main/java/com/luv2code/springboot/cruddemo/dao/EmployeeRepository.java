package com.luv2code.springboot.cruddemo.dao;

import com.luv2code.springboot.cruddemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
                                                        //entity, primary key
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
}
