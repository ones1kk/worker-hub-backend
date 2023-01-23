package com.breakingbad.workerhub.domain.member.repository;

import com.breakingbad.workerhub.domain.member.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
}
