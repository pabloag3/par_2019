/*
 */
package modelos;

import producto.bean.Producto;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;


/**
 *
 * @author Porfirio Perez
 */
public class ProductoModelo {
    final String path = "http://localhost:8084/par2019/parzon/productos"; 
    
    public ProductoModelo() {
    }
    // POST
    public void agregar(Producto nuevoProducto) {
        ResteasyClient client = new ResteasyClientBuilder().build();
        ResteasyWebTarget target = client.target(UriBuilder.fromPath(path + "/agregar-cliente"));
        Response clienteResponse =  target.request().post(Entity.entity(nuevoProducto, "application/json") );
        System.out.println("HTTP code: " + clienteResponse.getStatus());
        clienteResponse.close();
    }

    // GET
    public List<Producto> traerProductos() {
        Client client = ClientBuilder.newClient().register(new JacksonFeature());
        List<Producto> prods = client.target(path + "/traer-productos")
                .request(MediaType.APPLICATION_JSON).get(List.class);
        return prods;
    }

    //GET
    public List<Producto> traerProductos(String des, String cat) throws Exception {
        Client client = ClientBuilder.newClient().register(new JacksonFeature());
        List<Producto> prod = client.target(path + "/traer-producto?des=" + des + "&cat=" + cat)
                .request(MediaType.APPLICATION_JSON).get(ArrayList.class);
        return prod;
    }

    // PUT
    public void actualizarProducto(Producto actualizarProducto) {
        ResteasyClient client = new ResteasyClientBuilder().build();
        ResteasyWebTarget target = client.target(UriBuilder.fromPath(path + "/actualizar-cliente"));
        Response clienteResponse = target.request().put(Entity.entity(actualizarProducto, "application/json"));
        clienteResponse.close();
    }

    // DELETE
    public void borrarProducto(Integer id) {
        ResteasyClient client = new ResteasyClientBuilder().build();
        ResteasyWebTarget target = client.target(UriBuilder.fromPath(path + "/borrar-cliente/" + id));
        Response clienteResponse = target.request().delete();
        clienteResponse.close();
    }

}
