package com.gitpher.week03.controller;

import com.gitpher.week03.domain.Post;
import com.gitpher.week03.domain.PostRepository;
import com.gitpher.week03.domain.PostRequestDto;
import com.gitpher.week03.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class PostController {

    private final PostRepository postRepository;
    private final PostService postService;

    @PostMapping("/posts")
    public Post createPost(@RequestBody PostRequestDto requestDto) {
        Post post = new Post(requestDto);
        return postRepository.save(post);
    }

    @GetMapping("/posts")
    public List<com.gitpher.week03.domain.PostMapping> readPost() {
        LocalDateTime start = LocalDateTime.now().minusDays(1);
        LocalDateTime end = LocalDateTime.now();
        return postRepository.findAllByModifiedAtBetweenOrderByModifiedAtDesc(start, end);
    }

    @PutMapping("/posts/{id}")
    public String updatePost(@PathVariable Long id, @RequestBody PostRequestDto requestDto) {
        return postService.update(id, requestDto);
    }

    @DeleteMapping("/posts/{id}")
    public String deletePost(@PathVariable Long id, @RequestBody PostRequestDto requestDto) {
        return postService.delete(id, requestDto);
    }

    @GetMapping("/posts/{id}")
    public Post readOnePost(@PathVariable Long id) {
        return postRepository.findById(id).orElse(null);
    }

}
