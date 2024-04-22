package com.globalhits.Producto.persistence.repository;

import com.globalhits.Producto.dto.request.Request;
import com.globalhits.Producto.persistence.entity.Producto;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface ProductoRepository {
    List<?> save(Request producto) throws Exception;
}
