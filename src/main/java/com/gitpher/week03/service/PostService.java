package com.gitpher.week03.service;

import com.gitpher.week03.domain.Post;
import com.gitpher.week03.domain.PostRepository;
import com.gitpher.week03.domain.PostRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    @Transactional
    public String update(Long id, PostRequestDto requestDto) {
        Post post = postRepository.findById(id).orElseThrow(
                () -> new NullPointerException("해당 id가 존재하지 않습니다")
        );
        if (post.getPassword().equals(requestDto.getPassword())) {
            post.update(requestDto);
            return post.getId() + "번 게시물이 정상적으로 업데이트 되었습니다";
        }
        return "ERROR 404";
    }

    @Transactional
    public String delete(Long id, PostRequestDto requestDto) {
        Post post = postRepository.findById(id).orElseThrow(
                () -> new NullPointerException("해당 id가 존재하지 않습니다")
        );
        if (post.getPassword().equals(requestDto.getPassword())) {
            postRepository.deleteById(id);
            return post.getId() + "번 게시물이 정상적으로 삭제 되었습니다";
        }
        return "ERROR 404";
    }

}
