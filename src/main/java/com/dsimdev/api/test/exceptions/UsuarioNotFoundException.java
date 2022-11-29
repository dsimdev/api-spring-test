package com.dsimdev.api.test.exceptions;

public class UsuarioNotFoundException extends Exception {


    public UsuarioNotFoundException(){
        super("An user with that username doesn't exists");
    }

    public UsuarioNotFoundException(String mensaje) {
        super(mensaje);
    }

}
