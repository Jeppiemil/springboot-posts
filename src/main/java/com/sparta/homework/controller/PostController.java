package com.sparta.homework.controller;

import com.sparta.homework.domain.Post;
import com.sparta.homework.domain.PostRepository;
import com.sparta.homework.models.PostRequestDto;
import com.sparta.homework.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class PostController {

    private final PostService postService;
    private final PostRepository postRepository;

    @GetMapping("/api/posts") // 2. 전체 게시글 조회
    public List<Post> getPosts(){
        return postService.findAll();
    }

    @GetMapping("/api/posts/{id}") // 4. 게시글 조회
    public Post getOnePost(@PathVariable Long id){
        return postService.findOnePost(id);
    }

    @PostMapping("/api/posts") // 3. 게시글 작성
    public Post createPost(@RequestBody PostRequestDto requestDto){
        Post post = new Post(requestDto);
        return postService.savePost(post);
    }

    @PostMapping("/api/posts/{id}") // 5. 게시글 비밀번호 확인
    public String checkPassword(@PathVariable Long id, @RequestBody PostRequestDto requestDto){
        String original_password = postService.findOnePost(id).getPassword();
        if (original_password.equals(requestDto.getPassword())){
            return "True";
        } else {return "False";}
    }

    @PutMapping("/api/posts/{id}") // 6. 게시글 수정
    public Post updatePost(@PathVariable Long id, @RequestBody PostRequestDto requestDto){
        return postService.update(id, requestDto);
    }

    @DeleteMapping("/api/posts/{id}") // 7. 게시글 삭제
    public Long deletePost(@PathVariable Long id){
        return postService.delete(id);
    }
}
