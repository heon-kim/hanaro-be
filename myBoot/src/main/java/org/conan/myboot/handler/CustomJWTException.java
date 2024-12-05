package org.conan.myboot.handler;

public class CustomJWTException extends RuntimeException {
    public CustomJWTException(String msg){
        super(msg);
    }
}
