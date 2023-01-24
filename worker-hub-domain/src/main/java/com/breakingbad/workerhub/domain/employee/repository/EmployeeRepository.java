package com.breakingbad.workerhub.domain.employee.repository;

import com.breakingbad.workerhub.domain.employee.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
