package par.cliente.domain.rest;

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
import par.cliente.domain.model.entity.Cliente;
import par.cliente.domain.repository.JdbcClienteRepository;
import par.cliente.domain.service.ClienteServiceImpl;

/**
 *
 * @author Pablo Aguilar
 */
@Path("/clienteapi")
public class ClienteRestService {

    private final ClienteServiceImpl userService = new ClienteServiceImpl(new JdbcClienteRepository());

    @GET
    @Path("/clientes")
    @Produces("application/json")
    public ArrayList<Cliente> getUsers() {
        ArrayList<Cliente> clientes = (ArrayList) userService.getAll();
        return clientes;
    }

    @GET
    @Path("/clientes/{id}")
    @Produces("application/json")
    public Cliente getUser(@PathParam("id") Integer id) {
        Cliente entity = null;
        try {
            entity = (Cliente) userService.findById(id);
        } catch (Exception ex) {
            Logger.getLogger(ClienteRestService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return entity;
    }

    @POST
    @Path("/clientes")
    @Consumes("application/json")
    @Produces("application/json")
    public Cliente addUser(Cliente entity) {
        try {
            userService.add(entity);
        } catch (Exception ex) {
            Logger.getLogger(ClienteRestService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return entity;
    }

    @PUT
    @Path("/clientes")
    @Consumes("application/json")
    public void updateUser(Cliente entity) {
        try {
            userService.update(entity);
        } catch (Exception ex) {
            Logger.getLogger(ClienteRestService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @DELETE
    @Path("/clientes/{id}")
    public void removeUser(@PathParam("id") Integer id) {
        try {
            userService.delete(id);
        } catch (Exception ex) {
            Logger.getLogger(ClienteRestService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
