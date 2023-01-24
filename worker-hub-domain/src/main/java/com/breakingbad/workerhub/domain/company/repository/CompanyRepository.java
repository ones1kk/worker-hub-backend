package com.breakingbad.workerhub.domain.company.repository;

import com.breakingbad.workerhub.domain.company.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {
}
