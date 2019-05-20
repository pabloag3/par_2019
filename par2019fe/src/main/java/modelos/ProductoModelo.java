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
import org.glassfish.jersey.jackson.JacksonFeature;

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
        
        Client client = ClientBuilder.newClient().register(new JacksonFeature());
        client.target(path + "/agregar-producto").
                request(MediaType.APPLICATION_JSON).
                post(Entity.entity(nuevoProducto, MediaType.APPLICATION_JSON));
        
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
    public void actualizarProducto(Producto producto) {
        
        Client client = ClientBuilder.newClient().register(new JacksonFeature());
        client.target(path + "/actualizar-producto").request(MediaType.APPLICATION_JSON).put(Entity.entity(producto, MediaType.APPLICATION_JSON));
        
    }

    // DELETE
    public void borrarProducto(Integer id) {
        
        Client client = ClientBuilder.newClient().register(new JacksonFeature());
        client.target(path + "/borrar-producto/{" + id + "}").request(MediaType.APPLICATION_JSON).delete();
        
    }

}
