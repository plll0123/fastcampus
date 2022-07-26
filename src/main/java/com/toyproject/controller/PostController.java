//package com.toyproject.controller;
//
//import com.toyproject.service.PostService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.*;
//
//@Controller
//@RequestMapping("/post")
//@RequiredArgsConstructor
//public class PostController {
//
//    private final PostService postService;
//
//    @GetMapping
//    public String posts() {
//
//        postService.getPostList();
//
//        return "post";
//    }
//
//    @GetMapping("/{postId}")
//    public String posts(@PathVariable Long postId) {
//
//    }
//
//    @PostMapping("/{postId}")
//    public String savePost(@PathVariable Long postId){
//
//    }
//
//    @PatchMapping("/{postId}")
//    public String editPost(@PathVariable Long postId){
//
//    }
//
//    @DeleteMapping("/{postId}")
//    public String deletePost(@PathVariable Long postId){
//
//    }
//
//}
