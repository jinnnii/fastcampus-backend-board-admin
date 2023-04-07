package com.fastcampus.backendboardadmin.controller;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/management/comments")
@Controller
public class CommentManagementController {

    @GetMapping
    public String comments(
        @PageableDefault(size = 10, sort = "createdAt",direction = Sort.Direction.DESC) Pageable pageable,
        Model model
    ){
        return "/management/comments";
    }
}
