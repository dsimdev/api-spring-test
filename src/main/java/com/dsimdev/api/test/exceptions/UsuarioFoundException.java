package com.dsimdev.api.test.exceptions;

public class UsuarioFoundException extends Exception {

    public UsuarioFoundException(){
        super("An user with that username already exists");
    }

    public UsuarioFoundException(String mensaje) {
        super(mensaje);
    }
}
