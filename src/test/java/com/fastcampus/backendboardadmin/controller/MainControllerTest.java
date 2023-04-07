package com.fastcampus.backendboardadmin.controller;

import com.fastcampus.backendboardadmin.config.SecurityConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;

@DisplayName("View - 메인")
@Import(SecurityConfig.class)
@WebMvcTest
class MainControllerTest {
    private final MockMvc mvc;

    public MainControllerTest(@Autowired MockMvc mvc) {
        this.mvc = mvc;
    }

    @DisplayName("[view][GET] 루트 페이지 -> 게시글 관리 페이지 Forwarding")
    @Test
    void givenNothing_whenRequestingRootView_thenForwardsToArticleMngView() throws Exception {
        //given

        //when&then
        mvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("forward:/management/articles"))
                .andExpect(forwardedUrl("/management/articles"));
    }
}