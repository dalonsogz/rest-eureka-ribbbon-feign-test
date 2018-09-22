package com.test.business.exceptions;

/**
 * @author Samuel Martinez
 * @since 11/05/2017.
 */
public class DatabaseException extends RuntimeException {

    public DatabaseException (String code) {
        super(code);
    }
}
