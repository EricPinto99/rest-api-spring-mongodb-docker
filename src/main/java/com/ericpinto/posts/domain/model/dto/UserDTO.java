package com.ericpinto.posts.domain.model.dto;

import com.ericpinto.posts.domain.model.User;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter @Setter
public class UserDTO implements Serializable {

    private static final long serialVersionUID = 1l;

    private String id;
    private String name;
    private String email;

    public UserDTO(){

    }

    public UserDTO(User obj){
        id = obj.getId();
        name = obj.getName();
        email = obj.getEmail();
    }

}
