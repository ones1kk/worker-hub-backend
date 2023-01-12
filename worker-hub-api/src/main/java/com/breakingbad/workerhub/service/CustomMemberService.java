package com.breakingbad.workerhub.service;

import com.breakingbad.workerhub.domain.CustomMember;
import com.breakingbad.workerhub.repository.CustomMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CustomMemberService {

    private final CustomMemberRepository memberRepository;

    public List<CustomMember> findAll() {
        return memberRepository.findAll();
    }

    @Transactional
    public void save(CustomMember member) {
        memberRepository.save(member);
    }

    public CustomMember findById(Long id) {
        return memberRepository.findById(id)
                .orElseThrow(RuntimeException::new);
    }
}
