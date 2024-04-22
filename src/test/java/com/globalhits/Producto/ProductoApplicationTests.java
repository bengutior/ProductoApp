package com.globalhits.Producto;

import com.globalhits.Producto.dto.request.Request;
import com.globalhits.Producto.persistence.entity.Producto;
import com.globalhits.Producto.persistence.repository.ProductoRepository;
import com.globalhits.Producto.persistence.repository.impl.ProductoRepositoryImpl;
import com.globalhits.Producto.service.ProductoService;
import com.globalhits.Producto.service.impl.ProductoServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

import java.sql.Types;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
class ProductoApplicationTests {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Test
	void contextLoads() {
	}

	@Test
	void insertarProductoTest() throws Exception {
		int esperado = 0;
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
		inParams.put("P_NOMBRE", "Nayelli");
		inParams.put("P_FEC_REGISTRO", new Date());
		var outResult = simpleJdbcCall.execute(inParams);
		if(outResult.get("P_CODIGO_RESPUESTA").equals(esperado)){
			System.out.println("INFO: Registro exitoso - Código: " + outResult.get("P_CODIGO_RESPUESTA"));
		}else {
			System.out.println("ERROR: Registro fallido - Código: " + outResult.get("P_CODIGO_RESPUESTA"));
		}
	}

	@Test
	void listarProductoTest() throws Exception {
		String esperado = "Success";
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
		inParams.put("P_NOMBRE", "Cesar");
		inParams.put("P_FEC_REGISTRO", new Date());
		var outResult = simpleJdbcCall.execute(inParams);
		if(outResult.get("P_MENSAJE_RESPUESTA").equals(esperado)){
			System.out.println("INFO: Lista existente - Código: " + outResult.get("P_CODIGO_RESPUESTA"));
		}else {
			System.out.println("ERROR: No se hallaron registros - Código: " + outResult.get("P_CODIGO_RESPUESTA"));
		}
	}
}
