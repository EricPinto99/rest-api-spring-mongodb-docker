package com.ericpinto.posts.controllers.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@AllArgsConstructor
@Setter @Getter
public class StandartError implements Serializable {

    private static final long serialVersionUID = 1l;

    private Long timestamp;
    private Integer status;
    private String error;
    private String message;
    private String path;

    public StandartError(){}

}
