package com.test.business.exceptions;

import org.springframework.stereotype.Component;

import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @author Samuel Martinez
 * @since 11/05/2017.
 */
@Component
public class ExceptionSupplier {

    public <T, R>Supplier<R> bind(Function<T,R> fn, T value){
        return () -> fn.apply(value);
    }

}
