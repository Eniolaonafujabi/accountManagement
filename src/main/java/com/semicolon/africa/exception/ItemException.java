package com.semicolon.africa.exception;

public class ItemException extends RuntimeException {
    public ItemException(String itemNotFound) {
        super(itemNotFound);
    }
}
