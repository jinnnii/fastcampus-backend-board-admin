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

@DisplayName("View 컨트롤러 - 어드민 회원")
@Import(SecurityConfig.class)
@WebMvcTest(AdminUserAccountController.class)
class AdminUserAccountControllerTest {
    private final MockMvc mvc;

    public AdminUserAccountControllerTest(@Autowired MockMvc mvc) {
        this.mvc = mvc;
    }

    @DisplayName("[view][GET] 관리자 - 사용자 관리 페이지 - 정상 호출")
    @Test
    void givenNothing_whenRequestingAdminUserAccountView_thenReturnsAdminUserAccountView() throws Exception {
        //given

        //when&then
        mvc.perform(get("/admin/members"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.TEXT_HTML))
                .andExpect(view().name("/admin/members"));
    }
}