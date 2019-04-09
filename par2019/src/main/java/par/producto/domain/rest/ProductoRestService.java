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
@Path("/productos")
public class ProductoRestService {
    private final ProductoServiceImpl productoService = new ProductoServiceImpl(new JdbcProductoRepository());

    @GET
    @Path("/traer-productos")
    @Produces("application/json")
    public ArrayList<Producto> getProducts() {
        ArrayList<Producto> productos = (ArrayList) productoService.getAll();
        return productos;
    }

    @GET
    @Path("/traer-producto/{id}")
    @Produces("application/json")
    public Producto getProduct(@PathParam("id") Integer id) {
        Producto entity = null;
        try {
            entity = (Producto) productoService.findById(id);
        } catch (Exception ex) {
            Logger.getLogger(ProductoRestService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return entity;
    }

    @POST
    @Path("/agregar-producto")
    @Consumes("application/json")
    @Produces("application/json")
    public Producto addProduct(Producto entity) {
        try {
            productoService.add(entity);
        } catch (Exception ex) {
            Logger.getLogger(ProductoRestService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return entity;
    }

    @PUT
    @Path("/actualizar-producto")
    @Consumes("application/json")
    public void updateProduct(Producto entity) {
        try {
            productoService.update(entity);
        } catch (Exception ex) {
            Logger.getLogger(ProductoRestService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @DELETE
    @Path("/borrar-producto/{id}")
    public void removeProduct(@PathParam("id") Integer id) {
        try {
            productoService.delete(id);
        } catch (Exception ex) {
            Logger.getLogger(ProductoRestService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
