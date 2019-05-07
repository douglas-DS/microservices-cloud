package br.com.ds.security.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Douglas Souza on 25/04/2019
 */

@ResponseStatus(
        code = HttpStatus.NOT_FOUND,
        value = HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String message) {
        super(message);
    }
}
