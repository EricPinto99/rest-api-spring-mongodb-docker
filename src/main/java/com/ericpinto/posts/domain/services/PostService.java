package com.ericpinto.posts.domain.services;

import com.ericpinto.posts.domain.model.Post;
import com.ericpinto.posts.domain.model.User;
import com.ericpinto.posts.domain.services.exception.ObjectNotFoundException;
import com.ericpinto.posts.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public List<Post> findAll() {
        return postRepository.findAll();
    }

    public Post findById(String id) {
        return postRepository.findById(id).orElseThrow(()-> new ObjectNotFoundException("Publicação não encontrada"));
    }
}
