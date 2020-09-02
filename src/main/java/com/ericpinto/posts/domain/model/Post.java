package com.ericpinto.posts.domain.model;

import com.ericpinto.posts.domain.model.dto.AuthorDTO;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Date;

@Document

@AllArgsConstructor
@Getter @Setter
@EqualsAndHashCode(exclude = {"date", "title", "body", "author"})
@ToString

public class Post implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private String id;
    private Date date;
    private String title;
    private String body;
    private AuthorDTO author;

}
