/*
 */
package modelos;

import producto.bean.Producto;
import java.util.ArrayList;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
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
    public ArrayList<Producto> traerProductos() {
        ResteasyClient client = new ResteasyClientBuilder().build();
        ResteasyWebTarget target = client.target(UriBuilder.fromPath(path + "/traer-productos"));
        ArrayList<Producto> cli = target.request().get(ArrayList.class);
        return cli;
    }

    // GET
    public void traerProducto(Integer id) {
        ResteasyClient client = new ResteasyClientBuilder().build();
        ResteasyWebTarget target = client.target(UriBuilder.fromPath(path + "/traer-producto/" + id ));
        Response res = target.request(MediaType.APPLICATION_JSON).get();
        Object prod = res.getEntity();
        //String prod = resp.readEntity(String.class);
        System.out.println("hola" + prod);
        //return prod;
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
