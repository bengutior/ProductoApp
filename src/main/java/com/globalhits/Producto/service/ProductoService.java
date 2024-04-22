package com.globalhits.Producto.service;

import com.globalhits.Producto.dto.request.Request;
import com.globalhits.Producto.persistence.entity.Producto;

import java.util.List;
import java.util.Map;

public interface ProductoService {
    List<?> save(Request producto) throws Exception;
}
