package com.breakingbad.workerhub.domain.member;

import com.breakingbad.workerhub.IntegrationTestConfig;
import com.breakingbad.workerhub.constant.Profiles;
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
@Import(IntegrationTestConfig.class)
@ActiveProfiles(Profiles.test)
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