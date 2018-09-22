package com.test.business.exceptions;

/**
 * @author Samuel Martinez
 * @since 11/05/2017.
 */
public class FileException extends RuntimeException {

    public FileException(String code) {
        super(code);
    }
}
