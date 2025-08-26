package com.giovana.library.controllers.exceptions;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class ValidationError extends StandartError{

    private List<FieldMessage> errors = new ArrayList<>();

    public ValidationError(long timeStamp, Integer status, String message) {
        super(timeStamp, status, message);
    }

    public void addErros(String fieldName, String fieldError){
        this.errors.add(new FieldMessage(fieldName, fieldError));
    }
}
