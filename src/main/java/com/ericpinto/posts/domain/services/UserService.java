package com.ericpinto.posts.domain.services;

import com.ericpinto.posts.domain.model.User;
import com.ericpinto.posts.domain.model.dto.UserDTO;
import com.ericpinto.posts.domain.services.exception.ObjectNotFoundException;
import com.ericpinto.posts.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(String id) {
        return userRepository.findById(id).orElseThrow(()-> new ObjectNotFoundException("User não encontrado"));
    }

    public User insert(User obj){
        return userRepository.insert(obj);
    }

    public User fromDTO(UserDTO objDto){
        return new User(objDto.getId(),objDto.getName(), objDto.getEmail());
    }

}
