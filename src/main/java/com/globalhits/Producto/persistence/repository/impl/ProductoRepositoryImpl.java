package com.globalhits.Producto.persistence.repository.impl;

import com.globalhits.Producto.dto.request.Request;
import com.globalhits.Producto.persistence.entity.Producto;
import com.globalhits.Producto.persistence.repository.ProductoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import java.sql.Types;
import java.util.*;

@Repository
@Slf4j
@RequiredArgsConstructor
public class ProductoRepositoryImpl implements ProductoRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<?> save(Request producto) {
        SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withoutProcedureColumnMetaDataAccess()
                .withSchemaName("TESTDBA")
                .withProcedureName("INSERT_PRODUCTO")
                .declareParameters(
                        new SqlParameter("P_NOMBRE", Types.VARCHAR),
                        new SqlParameter("P_FEC_REGISTRO", Types.DATE),
                        new SqlOutParameter("P_LISTA", Types.REF_CURSOR),
                        new SqlOutParameter("P_CODIGO_RESPUESTA", Types.INTEGER),
                        new SqlOutParameter("P_MENSAJE_RESPUESTA", Types.VARCHAR)
                );
        Map<String, Object> inParams = new HashMap<>();
        inParams.put("P_NOMBRE", producto.nombre());
        inParams.put("P_FEC_REGISTRO", producto.fec_registro());
        var outResult = simpleJdbcCall.execute(inParams);
        log.info("Result" + outResult);
        return Optional.ofNullable((List<?>) outResult.get("P_LISTA")).orElseGet(ArrayList::new);
    }

}
