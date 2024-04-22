package com.globalhits.Producto.service.impl;

import com.globalhits.Producto.dto.request.Request;
import com.globalhits.Producto.persistence.entity.Producto;
import com.globalhits.Producto.persistence.repository.ProductoRepository;
import com.globalhits.Producto.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ProductoServiceImpl implements ProductoService {

    @Autowired
    ProductoRepository productoRepository;

    @Override
    public List<?> save(Request producto) throws Exception{
        return productoRepository.save(producto);
    }
}
