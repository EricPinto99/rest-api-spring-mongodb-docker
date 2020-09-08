package com.ericpinto.posts.controllers;

import com.ericpinto.posts.domain.model.Post;
import com.ericpinto.posts.domain.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/posts")
public class PostController {

    @Autowired
    private PostService userService;

    @GetMapping(value ="/{id}")
    public ResponseEntity<Post> findById(@PathVariable String id){
        Post post = userService.findById(id);
        return ResponseEntity.ok().body(post);
    }

}
