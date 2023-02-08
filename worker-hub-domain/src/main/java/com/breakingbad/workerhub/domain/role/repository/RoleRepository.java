package com.breakingbad.workerhub.domain.role.repository;

import com.breakingbad.workerhub.domain.role.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

}
