package com.globalhits.Producto.dto.response;

import com.globalhits.Producto.util.Message;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class Response<T> {
    String message;
    int code;
    Long id;
    T data;

    public Response() {
    }

    public Response(String message, int code) {
        this.message = message;
        this.code = code;
    }

    public Response(String message, int code, T data) {
        this.message = message;
        this.code = code;
        this.data =data;
    }

    public Response(String message) {
        this.message = message;
    }

    public Response(Message m) {
        this.message = m.getMessage();
        this.code = m.getCode();
    }

    public int getCode() {
        if ( code == 1 ) {
            return HttpStatus.INTERNAL_SERVER_ERROR.value();
        }
        return code;
    }
}
