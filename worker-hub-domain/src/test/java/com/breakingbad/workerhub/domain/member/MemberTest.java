package com.breakingbad.workerhub.domain.member;

import com.breakingbad.workerhub.common.component.Email;
import com.breakingbad.workerhub.domain.member.repository.MemberRepository;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@Disabled
class MemberTest {

    @Autowired
    private MemberRepository memberRepository;

    @Test
    void test() {
        Member member = Member.builder()
                .email(new Email("ones1k95@gmail.com"))
                .build();
        memberRepository.save(member);
    }
}