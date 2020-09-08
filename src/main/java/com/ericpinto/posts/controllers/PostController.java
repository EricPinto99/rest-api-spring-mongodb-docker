package com.ericpinto.posts.controllers;

import com.ericpinto.posts.domain.model.Post;
import com.ericpinto.posts.domain.model.User;
import com.ericpinto.posts.domain.model.dto.UserDTO;
import com.ericpinto.posts.domain.services.PostService;
import com.ericpinto.posts.domain.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

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
