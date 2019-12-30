package com.bridgelabz;

import javax.swing.*;

public class MoodException extends RuntimeException {
    public enum ExceptionType {
        ENTERED_NULL, ENTERED_EMPTY, NO_CLASS_FOUND, NO_METHOD_FOUND, NO_FIELD_FOUND
    }
    ExceptionType type;
    public MoodException(ExceptionType type, String message) {
        super(message);
        this.type=type;
    }
}