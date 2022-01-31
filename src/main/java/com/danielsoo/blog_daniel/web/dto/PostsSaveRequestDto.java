package com.danielsoo.blog_daniel.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import com.danielsoo.blog_daniel.domain.posts.Posts;

@Getter
@NoArgsConstructor
public class PostsSaveRequestDto {
    private String title;
    private String content;

    @Builder
    public PostsSaveRequestDto(String title, String content, String author){
        this.title = title;
        this.content = content;
    }

    public Posts toEntity(){
        return Posts.builder().title(title).content(content).build();
    }
}
