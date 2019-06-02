package par.transaccion.domain.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import org.springframework.web.bind.annotation.RequestBody;
import par.dtos.Transacciones;
import par.transaccion.domain.model.entity.Transaccion;
import par.transaccion.domain.repository.JdbcTransaccionRepository;
import par.transaccion.domain.service.TransaccionServiceImpl;
import par.transaccionDetalle.domain.model.entity.TransaccionDetalle;
import par.transaccionDetalle.domain.repository.JdbcTransaccionDetalleRepository;
import par.transaccionDetalle.domain.service.TransaccionDetalleServiceImpl;

/**
 *
 * @author Pablo Aguilar
 */
@Path("/transacciones")
@Consumes("application/json")
@Produces("application/json")
public class TransaccionRestService {
    private final TransaccionServiceImpl transaccionService = new TransaccionServiceImpl(new JdbcTransaccionRepository());
    private final TransaccionDetalleServiceImpl transaccionDetalleService = new TransaccionDetalleServiceImpl(new JdbcTransaccionDetalleRepository());
    
    @GET
    @Path("/traer-transacciones-cliente")
    public Response getTransaccionesPorCliente(@QueryParam("idCliente") int cliente) {
        List<Transacciones> entity = null; // lista de transacciones con sus detalles, lista de DTOs
        List<Transaccion> cabeceras = null; // lista de transaccionesCabecera de un cliente
        try {
            cabeceras = (List<Transaccion>) transaccionService.findCabecerasPorCliente(cliente);
            for (Transaccion t: cabeceras) {
                Transacciones aux = new Transacciones(); //DTO cabecera con detalle
                List<TransaccionDetalle> td = transaccionDetalleService.traerDetalleDeCabecera(t.getId());
                aux.setCabecera(t);
                aux.setDetalles(td);
                entity.add(aux);                
            }
            ObjectMapper mapper = new ObjectMapper();
            String resp = mapper.writeValueAsString(entity);
            return Response.ok(resp).header("Content-Type: aplication/json; charset=utf-8", "*").build();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return Response.ok(entity).build();
    }
    
    

}
