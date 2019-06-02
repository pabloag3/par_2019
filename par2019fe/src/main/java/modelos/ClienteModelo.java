package modelos;

import cliente.bean.Cliente;
import java.util.List;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import org.glassfish.jersey.jackson.JacksonFeature;

/**
 *
 * @author Perez
 */
public class ClienteModelo {
    final String path = "http://localhost:8084/par2019/parzon/clientes";
    
    // POST
    public void agregar(Cliente nuevoCliente) {
        Client client = ClientBuilder.newClient().register(new JacksonFeature());
        client.target(path + "/agregar-cliente").
                request(MediaType.APPLICATION_JSON).
                post(Entity.entity(nuevoCliente, MediaType.APPLICATION_JSON));
    }

    // GET
    public Cliente traerCliente(String usu, String pass) {
        Client client = ClientBuilder.newClient().register(new JacksonFeature());
        Cliente cliente = client.target(path + "/traer-cliente?usuario=" + usu + "&contra=" + pass)
                .request(MediaType.APPLICATION_JSON).get(Cliente.class);
        return cliente;
    }

    // GET
    public List<Cliente> traerClientes() {
        Client client = ClientBuilder.newClient().register(new JacksonFeature());
        List<Cliente> prods = client.target(path + "/traer-clientes")
                .request(MediaType.APPLICATION_JSON).get(List.class);
        return prods;
    }

    // PUT
    public void actualizarCliente(Cliente cliente) {
        Client client = ClientBuilder.newClient().register(new JacksonFeature());
        client.target(path + "/actualizar-cliente").request(MediaType.APPLICATION_JSON).put(Entity.entity(cliente, MediaType.APPLICATION_JSON));
    }

    // DELETE
    public void borrarCliente(Integer id) {
        Client client = ClientBuilder.newClient().register(new JacksonFeature());
        client.target(path + "/borrar-cliente/{" + id + "}").request(MediaType.APPLICATION_JSON).delete();
    }
}
