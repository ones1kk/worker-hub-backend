package com.breakingbad.workerhub.domain.employeerank.repository;

import com.breakingbad.workerhub.domain.employeerank.EmployeeRank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRankRepository extends JpaRepository<EmployeeRank, Long> {
}
