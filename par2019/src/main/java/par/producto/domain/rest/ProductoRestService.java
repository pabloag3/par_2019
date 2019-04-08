package par.producto.domain.rest;

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
import par.producto.domain.model.entity.Producto;
import par.producto.domain.repository.JdbcProductoRepository;
import par.producto.domain.service.ProductoServiceImpl;

/**
 *
 * @author Pablo Aguilar
 */
@Path("/productoapi")
public class ProductoRestService {

    private final ProductoServiceImpl productoService = new ProductoServiceImpl(new JdbcProductoRepository());

    @GET
    @Path("/productos")
    @Produces("application/json")
    public ArrayList<Producto> getUsers() {
        ArrayList<Producto> productos = (ArrayList) productoService.getAll();
        return productos;
    }

    @GET
    @Path("/productos/{id}")
    @Produces("application/json")
    public Producto getUser(@PathParam("id") Integer id) {
        Producto entity = null;
        try {
            entity = (Producto) productoService.findById(id);
        } catch (Exception ex) {
            Logger.getLogger(ProductoRestService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return entity;
    }

    @POST
    @Path("/productos")
    @Consumes("application/json")
    @Produces("application/json")
    public Producto addUser(Producto entity) {
        try {
            productoService.add(entity);
        } catch (Exception ex) {
            Logger.getLogger(ProductoRestService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return entity;
    }

    @PUT
    @Path("/productos")
    @Consumes("application/json")
    public void updateUser(Producto entity) {
        try {
            productoService.update(entity);
        } catch (Exception ex) {
            Logger.getLogger(ProductoRestService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @DELETE
    @Path("/productos/{id}")
    public void removeProducto(@PathParam("id") Integer id) {
        try {
            productoService.delete(id);
        } catch (Exception ex) {
            Logger.getLogger(ProductoRestService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
