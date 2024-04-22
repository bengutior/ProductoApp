package com.globalhits.Producto.dto.request;

import java.time.LocalDate;
import java.util.Date;

public record Request (
    String nombre,
    Date fec_registro

) {

}

