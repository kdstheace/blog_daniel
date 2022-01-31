package com.danielsoo.blog_daniel.service.posts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

import com.danielsoo.blog_daniel.domain.posts.Posts;
import com.danielsoo.blog_daniel.domain.posts.PostsRepository;
import com.danielsoo.blog_daniel.web.dto.PostsSaveRequestDto;
import com.danielsoo.blog_daniel.web.dto.PostsUpdateRequestDto;

@RequiredArgsConstructor
@Service
public class PostsService {
    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto){
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto){
        Posts posts = postsRepository.findById(id)
            .orElseThrow(()->new IllegalArgumentException("해당 게시글 없음 id=" + id));
        posts.update(requestDto.getTitle(), requestDto.getContent());

        return id;
    }

}
