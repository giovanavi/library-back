package com.giovana.library.controllers.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter @Setter
public class StandartError {

    private long timeStamp;
    private Integer status;
    private String message;



}
