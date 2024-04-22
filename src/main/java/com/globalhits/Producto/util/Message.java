package com.globalhits.Producto.util;

import lombok.Getter;

@Getter
public enum Message {
    ERROR_GENERICO("Ocurrió un error.",500),
    OK("OK", 200),
    NOT_FOUND("Recurso no encontrado",404),
    ERROR("Error de servicio",500),
    CASO_ANULADO("El caso fue anulado correctamente",200);

    String message;
    int code;

    private Message(String mensage, int code) {
        this.message = mensage;
        this.code = code;
    }

    public String getMensage() {
        return message;
    }

    public int getCode() {
        return code;
    }
}
