package par.cliente.domain.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
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
import par.cliente.domain.model.entity.Cliente;
import par.cliente.domain.repository.JdbcClienteRepository;
import par.cliente.domain.service.ClienteServiceImpl;

/**
 *
 * @author Pablo Aguilar
 */
@Path("/clientes")
@Consumes("application/json")
@Produces("application/json")
public class ClienteRestService {
    private final ClienteServiceImpl clienteService = new ClienteServiceImpl(new JdbcClienteRepository());

    @GET
    @Path("/traer-clientes")
    public Response getUsers() {
        try {
            ArrayList<Cliente> clientes = (ArrayList) clienteService.getAll();
            ObjectMapper mapper = new ObjectMapper();
            String resp = mapper.writeValueAsString(clientes);
            return Response.ok(resp).header("Content-Type: aplication/json; charset=utf-8", "*").build();
        } catch (Exception ex) {
            Logger.getLogger(ClienteRestService.class.getName()).log(Level.SEVERE, null, ex);
            return Response.status(Response.Status.NOT_FOUND).header("Content-Type: text/html; charset=utf-8", "*").build();
        }
    }

    @GET
    @Path("/traer-cliente/{id}")
    public Response getUser(@PathParam("id") Integer id) {
        Cliente entity = null;
        try {
            entity = (Cliente) clienteService.findById(id);
            ObjectMapper mapper = new ObjectMapper();
            String resp = mapper.writeValueAsString(entity);
            return Response.ok(resp).header("Content-Type: aplication/json; charset=utf-8", "*").build();
        } catch (Exception ex) {
            Logger.getLogger(ClienteRestService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Response.ok(entity).build();
    }

    @POST
    @Path("/agregar-cliente")
    public void addUser(@RequestBody String entity) {
        try {
            System.out.println("Guardando Cliente.");
            ObjectMapper mapper = new ObjectMapper();
            Cliente categoria = mapper.readValue(entity, Cliente.class);
            clienteService.add(categoria);
        } catch (Exception ex) {
            Logger.getLogger(ClienteRestService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @PUT
    @Path("/actualizar-cliente")
    public void updateUser(@RequestBody String entity) {
        try {
            System.out.println("actualizar Cliente.");
            ObjectMapper mapper = new ObjectMapper();
            Cliente cliente = mapper.readValue(entity, Cliente.class);
            clienteService.update(cliente);
        } catch (Exception ex) {
            Logger.getLogger(ClienteRestService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @DELETE
    @Path("/borrar-cliente/{id}")
    public void removeUser(@PathParam("id") Integer id) {
        try {
            clienteService.delete(id);
        } catch (Exception ex) {
            Logger.getLogger(ClienteRestService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
