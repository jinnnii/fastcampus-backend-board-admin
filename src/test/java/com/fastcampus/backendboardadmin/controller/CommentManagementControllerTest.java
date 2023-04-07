package com.fastcampus.backendboardadmin.controller;

import com.fastcampus.backendboardadmin.config.SecurityConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.assertj.core.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@DisplayName("View 컨트롤러 - 댓글 관리")
@Import(SecurityConfig.class)
@WebMvcTest
class CommentManagementControllerTest {
    private final MockMvc mvc;

    public CommentManagementControllerTest(@Autowired MockMvc mvc) {
        this.mvc = mvc;
    }

    @DisplayName("[view][GET] 댓글 관리 페이지 - 정상 호출")
    @Test
    void givenNothing_whenRequestingCommentMngView_thenReturnsCommentMngView() throws Exception {
        //given

        //when&then
        mvc.perform(get("/management/comments"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.TEXT_HTML))
                .andExpect(view().name("/management/comments"));
    }
}