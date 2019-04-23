package par.categoria.domain.rest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import par.categoria.domain.rest.*;
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
import par.categoria.domain.model.entity.Categoria;
import par.categoria.domain.repository.JdbcCategoriaRepository;
import par.categoria.domain.service.CategoriaServiceImpl;

/**
 *
 * @author Pablo Aguilar
 */
@Path("/categorias")
@Consumes("application/json")
@Produces("application/json")
public class CategoriaRestService {
    private final CategoriaServiceImpl categoriaService = new CategoriaServiceImpl(new JdbcCategoriaRepository());

    @GET
    @Path("/traer-categorias")
    public Response getCategories() {
        try {
            ArrayList<Categoria> categorias = new ArrayList<>();
            //categorias.add(new Categoria(1,"hola"));
            categorias = (ArrayList) categoriaService.getAll();
            ObjectMapper mapper = new ObjectMapper();
            String resp = mapper.writeValueAsString(categorias);
            return Response.ok(resp).header("Content-Type: aplication/json; charset=utf-8", "*").build();
        } catch (Exception ex) {
            Logger.getLogger(CategoriaRestService.class.getName()).log(Level.SEVERE, null, ex);
            return Response.status(Response.Status.NOT_FOUND).header("Content-Type: text/html; charset=utf-8", "*").build();
        }
    }

    @GET
    @Path("/traer-categoria/{id}")
    public Response getCategory(@PathParam("id") Integer id) {
        Categoria entity = null;
        try {
            entity = (Categoria) categoriaService.findById(id);
            ObjectMapper mapper = new ObjectMapper();
            String resp = mapper.writeValueAsString(entity);
            return Response.ok(resp).header("Content-Type: aplication/json; charset=utf-8", "*").build();
        } catch (Exception ex) {
            Logger.getLogger(CategoriaRestService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Response.ok(entity).build();
    }

    @POST
    @Path("/agregar-categoria")
    public void addCategory(@RequestBody String entity) {
        try {
            System.out.println("Guardando Categoria.");
            ObjectMapper mapper = new ObjectMapper();
            Categoria categoria = mapper.readValue(entity, Categoria.class);
            categoriaService.add(categoria);
        } catch (Exception ex) {
            Logger.getLogger(CategoriaRestService.class.getName()).log(Level.SEVERE, null, ex);
        }
        //return entity;
    }

    @PUT
    @Path("/actualizar-categoria")
    public void updateCategory(@RequestBody String entity) {
        try {
            System.out.println("actualizar Categoria.");
            ObjectMapper mapper = new ObjectMapper();
            Categoria categoria = mapper.readValue(entity, Categoria.class);
            categoriaService.update(categoria);
        } catch (Exception ex) {
            Logger.getLogger(CategoriaRestService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @DELETE
    @Path("/borrar-categoria/{id}")
    public void removeCategory(@PathParam("id") Integer id) {
        try {
            categoriaService.delete(id);
        } catch (Exception ex) {
            Logger.getLogger(CategoriaRestService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
