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
    void add() {
        // given
        memberRepository.save(new CustomMember(1L, "userA"));

        // when
        CustomMember saved = memberRepository.findById(1L)
                .orElse(null);

        // then
        assertThat(saved).isNotNull();
        assertThat(saved.getId()).isEqualTo(1L);
    }

}