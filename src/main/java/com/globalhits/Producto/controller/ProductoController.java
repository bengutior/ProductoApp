package com.globalhits.Producto.controller;

import com.globalhits.Producto.dto.request.Request;
import com.globalhits.Producto.dto.response.Response;
import com.globalhits.Producto.persistence.entity.Producto;
import com.globalhits.Producto.service.ProductoService;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("globalhits/e/producto/controller")
public class ProductoController {
    @Autowired
    ProductoService productoservice;
        @RequestMapping(value = "/save", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
        public Response<List<?>> save(@RequestBody Request producto) throws Exception {
            var result = productoservice.save(producto);
            var response = new Response<List<?>>();
            response.setData(result);
            return response;
        }

}
