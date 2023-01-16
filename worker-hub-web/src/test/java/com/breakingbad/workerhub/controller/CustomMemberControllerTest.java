package com.breakingbad.workerhub.controller;

import com.breakingbad.workerhub.service.CustomMemberService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static java.util.Collections.emptyList;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
class CustomMemberControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CustomMemberService memberService;

    @Test
    @WithMockUser
    void controllerTest() throws Exception {
        // given
        given(memberService.findAll()).willReturn(emptyList());

        // when
        var action = mockMvc.perform(get("/members/1.0"));

        // then
        action.andExpect(status().isOk());
    }
}