package com.breakingbad.workerhub.controller;

import com.breakingbad.workerhub.domain.CustomMember;
import com.breakingbad.workerhub.service.CustomMemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
public class CustomMemberController {

    private final CustomMemberService memberService;

    @GetMapping("1.0")
    public List<CustomMember> getAllMember() {
        return memberService.findAll();
    }
}
