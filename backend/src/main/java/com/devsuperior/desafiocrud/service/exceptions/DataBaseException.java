package com.devsuperior.desafiocrud.service.exceptions;

public class DataBaseException extends RuntimeException {

    public DataBaseException(String mensagem) {
        super(mensagem);
    }
}
