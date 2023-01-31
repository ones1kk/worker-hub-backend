package com.breakingbad.workerhub.domain.member;

import com.breakingbad.workerhub.common.component.Email;
import com.breakingbad.workerhub.core.crypto.Crypto;
import com.breakingbad.workerhub.domain.member.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DataJpaTest
class MemberTest {

    @MockBean
    private Crypto crpyto;

    @Autowired
    private MemberRepository memberRepository;

    @Test
    void test() {
        Member member = Member.builder()
                .email(new Email("ones1k95@gmail.com"))
                .build();
        assertThatThrownBy(() -> memberRepository.save(member));
    }
}