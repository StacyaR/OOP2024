package ru.vsu.cs.sem3.oop.practice.exceptions;

public class MyNullPointerVideoException extends NullPointerException {
    private String s;

    public MyNullPointerVideoException() {
    }

    public MyNullPointerVideoException(String s) {
        this.s = s;
    }

    public String getMessage() {
        return s;
    }
}
