package com.ericpinto.posts.controllers;

import com.ericpinto.posts.domain.model.User;
import com.ericpinto.posts.domain.model.dto.UserDTO;
import com.ericpinto.posts.domain.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<UserDTO>> findAll(){
        List<User> list = userService.findAll();
        List<UserDTO> listDto = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto);
    }

    @GetMapping(value ="/{id}")
    public ResponseEntity<User> findById(@PathVariable String id){
        User obj = userService.findById(id);
        return ResponseEntity.ok().body(obj);
    }

}
