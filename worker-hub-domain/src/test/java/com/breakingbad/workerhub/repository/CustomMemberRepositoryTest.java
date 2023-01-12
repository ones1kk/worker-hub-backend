package com.breakingbad.workerhub.repository;

import com.breakingbad.workerhub.domain.CustomMember;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class CustomMemberRepositoryTest {

    @Autowired
    private CustomMemberRepository memberRepository;

    @Test
    void save() {
        // given
        memberRepository.save(new CustomMember(1L, "userA"));

        // when
        CustomMember member = memberRepository.findById(1L)
                .orElse(null);

        // then
        assertThat(member).isNotNull();
        assertThat(member.getId()).isEqualTo(1L);
        assertThat(member.getName()).isEqualTo("userA");
    }

}