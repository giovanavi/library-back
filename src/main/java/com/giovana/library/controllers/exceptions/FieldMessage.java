package com.giovana.library.controllers.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@AllArgsConstructor
@Getter @Setter
public class FieldMessage implements Serializable {

    private String fieldName;
    private String message;

}
