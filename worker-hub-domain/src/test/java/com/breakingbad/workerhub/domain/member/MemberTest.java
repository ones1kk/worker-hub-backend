package com.breakingbad.workerhub.domain.member;

import com.breakingbad.workerhub.core.config.AuditConfig;
import com.breakingbad.workerhub.core.crypto.Crypto;
import com.breakingbad.workerhub.domain.member.repository.MemberRepository;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@Import(value = {AuditConfig.class})
@Disabled
class MemberTest {

    @MockBean
    private Crypto crypto;

    @MockBean
    private PasswordEncoder passwordEncoder;

    @Autowired
    private MemberRepository memberRepository;

    @Test
    void test() {
        memberRepository.save(new Member());

        Member findMember = memberRepository.findById(1L).orElseThrow();

        assertThat(findMember).isNotNull();
    }
}