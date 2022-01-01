package io.agileintellingence.ppmtool.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ProjectIdExeption extends RuntimeException{

    public ProjectIdExeption(String message) {
        super(message);
    }
}
