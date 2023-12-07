
package com.tienda.service;

import java.io.IOException;
import java.util.Map;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;


public interface ReporteService {

    public ResponseEntity<Resource> generaReporte(
            String reporte, //Nombre archivo llamado .jasper (usuarios.jasper o ventas.jasper)
            Map<String, Object> parametros, //Se pasan los parametros del archivo jasper  (Los selecciondos en jasper como nombre , etc
            String tipo) throws IOException;//El tipo de reporte que el usuario va a ver o descargar
            
    

}
