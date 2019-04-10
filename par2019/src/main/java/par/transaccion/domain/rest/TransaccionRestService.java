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
import par.transaccion.domain.model.entity.Transaccion;
import par.transaccion.domain.repository.JdbcTransaccionRepository;
import par.transaccion.domain.service.TransaccionServiceImpl;

/**
 *
 * @author Pablo Aguilar
 */
@Path("/transacciones")
public class TransaccionRestService {
    private final TransaccionServiceImpl transaccionService = new TransaccionServiceImpl(new JdbcTransaccionRepository());

    @GET
    @Path("/transaccions")
    @Produces("application/json")
    public ArrayList<Transaccion> getUsers() {
        ArrayList<Transaccion> transaccions = (ArrayList) transaccionService.getAll();
        return transaccions;
    }

    @GET
    @Path("/transaccions/{id}")
    @Produces("application/json")
    public Transaccion getUser(@PathParam("id") Integer id) {
        Transaccion entity = null;
        try {
            entity = (Transaccion) transaccionService.findById(id);
        } catch (Exception ex) {
            Logger.getLogger(TransaccionRestService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return entity;
    }

    @POST
    @Path("/transaccions")
    @Consumes("application/json")
    @Produces("application/json")
    public Transaccion addUser(Transaccion entity) {
        try {
            transaccionService.add(entity);
        } catch (Exception ex) {
            Logger.getLogger(TransaccionRestService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return entity;
    }

    @PUT
    @Path("/transaccions")
    @Consumes("application/json")
    public void updateUser(Transaccion entity) {
        try {
            transaccionService.update(entity);
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
