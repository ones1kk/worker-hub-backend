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
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
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

    @Nested
    class SaveTest {

        @Test
        @DisplayName("CustomMemberService.save() 성공 테스트")
        void save_success() {
            // given
            CustomMember memberA = new CustomMember(1L, "memberA");
            given(memberRepository.save(memberA)).willReturn(memberA);

            // when
            CustomMember savedMember = memberService.save(memberA);

            // then
            assertThat(memberA).isEqualTo(savedMember);
            assertThatNoException().isThrownBy(() -> memberService.save(memberA));
        }

        @Test
        @DisplayName("CustomMemberService.save() 실패 테스트")
        void save_fail() {
            CustomMember savedMember = memberService.save(null);

            assertThat(savedMember).isNull();
            assertThatNoException().isThrownBy(() -> memberService.save(null));
        }
    }

    @Nested
    class FindByIdTest {

        @Test
        @DisplayName("CustomMemberService.findById() 성공 테스트")
        void findById_success() {
            // given
            CustomMember member = new CustomMember(1L, "memberA");
            given(memberRepository.findById(1L)).willReturn(Optional.of(member));

            // when
            CustomMember findMember = memberService.findById(1L);

            // then
            assertThat(findMember).isNotNull()
                    .isEqualTo(member);
        }

        @Test
        @DisplayName("CustomMemberService.findById() 실패 테스트")
        void findById_fail() {
            given(memberRepository.findById(1L)).willReturn(Optional.empty());

            assertThatExceptionOfType(RuntimeException.class)
                    .isThrownBy(() -> memberService.findById(1L));
        }
    }

}