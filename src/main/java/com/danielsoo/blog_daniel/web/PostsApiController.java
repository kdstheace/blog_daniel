package com.danielsoo.blog_daniel.web;

import org.springframework.web.bind.annotation.*;

import lombok.RequiredArgsConstructor;

import com.danielsoo.blog_daniel.service.posts.PostsService;
import com.danielsoo.blog_daniel.web.dto.PostsResponseDto;
import com.danielsoo.blog_daniel.web.dto.PostsSaveRequestDto;
import com.danielsoo.blog_daniel.web.dto.PostsUpdateRequestDto;

@RestController
@RequiredArgsConstructor
public class PostsApiController {
    private final PostsService postsService;

    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostsSaveRequestDto requestDto){
        return postsService.save(requestDto);
    }

    @PutMapping("/api/v1/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto){
        return postsService.update(id, requestDto);
    }

    @GetMapping("/api/v1/posts/{id}")
    public PostsResponseDto findById(@PathVariable Long id){
        return postsService.findById(id);
    }

    @DeleteMapping("/api/v1/posts/{id}")
    public Long delete(@PathVariable Long id){
        postsService.delete(id);
        return id;
    }

}
