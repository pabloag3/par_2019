package par.producto.domain.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import org.springframework.web.bind.annotation.RequestBody;
import par.producto.domain.model.entity.Producto;
import par.producto.domain.repository.JdbcProductoRepository;
import par.producto.domain.service.ProductoServiceImpl;

/**
 *
 * @author Pablo Aguilar
 */
@Path("/productos")
@Consumes("application/json")
@Produces("application/json")
public class ProductoRestService {
    private final ProductoServiceImpl productoService = new ProductoServiceImpl(new JdbcProductoRepository());

    @GET
    @Path("/traer-productos")
    public Response getProductos() {
        try {
            List<Producto> productos = (ArrayList) productoService.getAll();
            ObjectMapper mapper = new ObjectMapper();
            String resp = mapper.writeValueAsString(productos);
            return Response.ok(resp).header("Content-Type: aplication/json; charset=utf-8", "*").build();
        } catch (Exception ex) {
            Logger.getLogger(ProductoRestService.class.getName()).log(Level.SEVERE, null, ex);
            return Response.status(Response.Status.NOT_FOUND).header("Content-Type: text/html; charset=utf-8", "*").build();
        }
    }

    @GET
    @Path("/traer-producto")
    public Response getProduct(@DefaultValue("") @QueryParam("des") String descripcion,
                                @DefaultValue("")@QueryParam("cat") String categoria) {
        Producto entity = null;
        try {
            entity = (Producto) productoService.findByDescripcion(descripcion, categoria);
            ObjectMapper mapper = new ObjectMapper();
            String resp = mapper.writeValueAsString(entity);
            return Response.ok(resp).header("Content-Type: aplication/json; charset=utf-8", "*").build();
        } catch (Exception ex) {
            Logger.getLogger(ProductoRestService.class.getName()).log(Level.SEVERE, null, ex);
            return Response.status(Response.Status.NOT_FOUND).header("Content-Type: text/html; charset=utf-8", "*").build();
        }
    }
    
    @GET
    @Path("/traer-producto/{id}")
    public Response getProduct(@PathParam("id") Integer id) {
        Producto entity = null;
        try {
            entity = (Producto) productoService.findById(id);
            ObjectMapper mapper = new ObjectMapper();
            String resp = mapper.writeValueAsString(entity);
            return Response.ok(resp).header("Content-Type: aplication/json; charset=utf-8", "*").build();
        } catch (Exception ex) {
            Logger.getLogger(ProductoRestService.class.getName()).log(Level.SEVERE, null, ex);
            return Response.status(Response.Status.NOT_FOUND).header("Content-Type: text/html; charset=utf-8", "*").build();
        }
    }

    @POST
    @Path("/agregar-producto")
    public void addProduct(@RequestBody String entity) {
        try {
            System.out.println("Guardando Producto.");
            ObjectMapper mapper = new ObjectMapper();
            Producto producto = mapper.readValue(entity, Producto.class);
            productoService.add(producto);
        } catch (Exception ex) {
            Logger.getLogger(ProductoRestService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @PUT
    @Path("/actualizar-producto")
    public void updateProduct(@RequestBody String entity) {
        try {
            System.out.println("actualizar Producto.");
            ObjectMapper mapper = new ObjectMapper();
            Producto producto = mapper.readValue(entity, Producto.class);
            productoService.update(producto);
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
