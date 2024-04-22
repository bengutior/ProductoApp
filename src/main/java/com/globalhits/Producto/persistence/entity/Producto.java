package com.globalhits.Producto.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor @AllArgsConstructor
public class Producto {
    private String nombre;
    private Date fec_registro;
}
