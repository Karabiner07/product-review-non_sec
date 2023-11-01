package com.tarun.productreview.service;

public class ReviewAlreadyExistsExeption extends RuntimeException {
    public ReviewAlreadyExistsExeption(String message) {
        super(message);
    }
}
