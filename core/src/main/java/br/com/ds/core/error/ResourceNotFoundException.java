package br.com.ds.core.error;

/**
 * @author Douglas Souza on 25/04/2019
 */


public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String message) {
        super(message);
    }
}
