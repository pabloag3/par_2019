package par.transaccion.domain.rest;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import org.springframework.web.bind.annotation.RequestBody;
import par.transaccion.domain.model.entity.Transaccion;
import par.transaccion.domain.repository.JdbcTransaccionRepository;
import par.transaccion.domain.service.TransaccionServiceImpl;

/**
 *
 * @author Pablo Aguilar
 */
@Path("/transacciones")
@Consumes("application/json")
@Produces("application/json")
public class TransaccionRestService {
    private final TransaccionServiceImpl transaccionService = new TransaccionServiceImpl(new JdbcTransaccionRepository());

    @GET
    @Path("/transaccions")
    public Response getUsers() {
        try {
            ArrayList<Transaccion> transaccion = new ArrayList<>();
            transaccion = (ArrayList) transaccionService.getAll();
            ObjectMapper mapper = new ObjectMapper();
            String resp = mapper.writeValueAsString(transaccion);
            return Response.ok(resp).header("Content-Type: aplication/json; charset=utf-8", "*").build();
        } catch (Exception ex) {
            Logger.getLogger(TransaccionRestService.class.getName()).log(Level.SEVERE, null, ex);
            return Response.status(Response.Status.NOT_FOUND).header("Content-Type: text/html; charset=utf-8", "*").build();
        }
    }

    @GET
    @Path("/transaccions/{id}")
    public Response getUser(@PathParam("id") Integer id) {
        Transaccion entity = null;
        try {
            entity = (Transaccion) transaccionService.findById(id);
            ObjectMapper mapper = new ObjectMapper();
            String resp = mapper.writeValueAsString(entity);
            return Response.ok(resp).header("Content-Type: aplication/json; charset=utf-8", "*").build();
        } catch (Exception ex) {
            Logger.getLogger(TransaccionRestService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Response.ok(entity).build();
    }

    @POST
    @Path("/transaccions")
    public void addUser(@RequestBody String entity) {
        try {
            System.out.println("Guardando Transaccion.");
            ObjectMapper mapper = new ObjectMapper();
            Transaccion categoria = mapper.readValue(entity, Transaccion.class);
            transaccionService.add(categoria);
        } catch (Exception ex) {
            Logger.getLogger(TransaccionRestService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @PUT
    @Path("/transaccions")
    public void updateUser(@RequestBody String entity) {
        try {
            System.out.println("actualizar Categoria.");
            ObjectMapper mapper = new Transaccion();
            Transaccion transaccion = mapper.readValue(entity, Transaccion.class);
            transaccionService.update(transaccion);
        } catch (Exception ex) {
            Logger.getLogger(TransaccionRestService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @DELETE
    @Path("/transaccions/{id}")
    public void removeTransaccion(@PathParam("id") Integer id) {
        try {
            transaccionService.delete(id);
        } catch (Exception ex) {
            Logger.getLogger(TransaccionRestService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
