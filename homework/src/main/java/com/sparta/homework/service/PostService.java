package com.sparta.homework.service;

import com.sparta.homework.domain.Post;
import com.sparta.homework.domain.PostRepository;
import com.sparta.homework.models.PostRequestDto;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


@Service
public class PostService{
    private final PostRepository postRepository;

    public PostService(PostRepository postRepository){
        this.postRepository = postRepository;
    }

    @Transactional
    public Post savePost(Post post){
        postRepository.save(post);
        return post;
    }

    @Transactional
    public Post findOnePost(Long id){
        return postRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 게시글이 존재하지 않습니다.")
        );
    }

    @Transactional
    public Post update(Long id, PostRequestDto requestDto){
        Post post = postRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 게시글이 존재하지 않습니다.")
        );
        post.update(requestDto);
        return post;
    }

    @Transactional
    public Long delete(Long id){
        postRepository.deleteById(id);
        return id;
    }
}

