package com.breakingbad.workerhub.domain.member;

import com.breakingbad.workerhub.TestIntegrationConfig;
import com.breakingbad.workerhub.domain.member.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * {@code @DataJpaTest} Sample
 */
@DataJpaTest
@Import(TestIntegrationConfig.class)
@ActiveProfiles("test")
class MemberTest {

    @Autowired
    private MemberRepository memberRepository;

    @Test
    void test() {
        memberRepository.save(new Member());

        Member findMember = memberRepository.findById(1L).orElseThrow();

        assertThat(findMember).isNotNull();
    }
}