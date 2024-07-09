package com.zolusca.Exceptions;

import java.text.Format;
import java.util.Formatter;

public class NotFoundExceptions extends RuntimeException{
    public NotFoundExceptions(String message) {
        super(message);
    }
}
