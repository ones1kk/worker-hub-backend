package com.breakingbad.workerhub.service;

import com.breakingbad.workerhub.domain.CustomMember;
import com.breakingbad.workerhub.repository.CustomMemberRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class CustomMemberServiceTest {

    @InjectMocks
    private CustomMemberService memberService;

    @Mock
    private CustomMemberRepository memberRepository;

    private final List<CustomMember> customMemberList = new ArrayList<>();

    @BeforeEach
    void beforeEach() {
        customMemberList.add(new CustomMember(1L, "memberA"));
        customMemberList.add(new CustomMember(2L, "memberB"));
        customMemberList.add(new CustomMember(3L, "memberC"));
        customMemberList.add(new CustomMember(4L, "memberD"));
        customMemberList.add(new CustomMember(5L, "memberE"));
    }

    @Nested
    class findAllTest {

        @Test
        @DisplayName("CustomMemberService.findAll() 테스트")
        void findAll() {
            // given
            given(memberRepository.findAll()).willReturn(customMemberList);

            // when
            List<CustomMember> members = memberService.findAll();

            // then
            assertThat(members.size()).isEqualTo(5);
            assertThat(members).extracting("name")
                    .containsExactly("memberA", "memberB",
                            "memberC", "memberD", "memberE");
        }
    }

    @Nested
    class saveTest {

        @Test
        @DisplayName("CustomMemberService.save() 테스트")
        void save() throws Exception {
            CustomMember memberA = new CustomMember(1L, "memberA");

            assertThatNoException().isThrownBy(() -> memberService.save(memberA));
        }
    }

}