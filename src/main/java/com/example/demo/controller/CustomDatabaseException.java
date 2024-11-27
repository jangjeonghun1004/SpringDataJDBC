package com.example.demo.controller;

import org.springframework.dao.DataAccessException;

public class CustomDatabaseException extends DataAccessException {

    public CustomDatabaseException(String msg, Throwable cause) {
        super(msg, cause);
    }

}
