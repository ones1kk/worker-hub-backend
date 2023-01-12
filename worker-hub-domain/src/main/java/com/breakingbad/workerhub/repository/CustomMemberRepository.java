package com.breakingbad.workerhub.repository;

import com.breakingbad.workerhub.domain.CustomMember;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomMemberRepository extends JpaRepository<CustomMember, Long> {
}
