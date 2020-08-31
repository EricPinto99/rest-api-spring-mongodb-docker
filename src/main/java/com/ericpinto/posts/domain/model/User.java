package com.ericpinto.posts.domain.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document

@AllArgsConstructor
@Getter @Setter
@ToString
@EqualsAndHashCode(exclude = {"name", "email"})

public class User {

    @Id
    private String id;
    private String name;
    private String email;

    public User(){}

}
