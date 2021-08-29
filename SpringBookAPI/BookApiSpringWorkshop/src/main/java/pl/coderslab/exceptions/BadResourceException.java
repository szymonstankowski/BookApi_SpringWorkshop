package pl.coderslab.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class BadResourceException extends RuntimeException{
    public BadResourceException() {}

    public  BadResourceException(String message){
        super (message);
    };
}
