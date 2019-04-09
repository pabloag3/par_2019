package par.categoria.domain.rest;

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
import par.categoria.domain.model.entity.Categoria;
import par.categoria.domain.repository.JdbcCategoriaRepository;
import par.categoria.domain.service.CategoriaServiceImpl;

/**
 *
 * @author Pablo Aguilar
 */
@Path("/categorias")
public class CategoriaRestService {
    private final CategoriaServiceImpl categoriaService = new CategoriaServiceImpl(new JdbcCategoriaRepository());

    @GET
    @Path("/traer-categorias")
    @Produces("application/json")
    public ArrayList<Categoria> getCategories() {
        ArrayList<Categoria> categorias = (ArrayList) categoriaService.getAll();
        return categorias;
    }

    @GET
    @Path("/traer-categoria/{id}")
    @Produces("application/json")
    public Categoria getCategory(@PathParam("id") Integer id) {
        Categoria entity = null;
        try {
            entity = (Categoria) categoriaService.findById(id);
        } catch (Exception ex) {
            Logger.getLogger(CategoriaRestService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return entity;
    }

    @POST
    @Path("/agregar-categoria")
    @Consumes("application/json")
    @Produces("application/json")
    public Categoria addCategory(Categoria entity) {
        try {
            categoriaService.add(entity);
        } catch (Exception ex) {
            Logger.getLogger(CategoriaRestService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return entity;
    }

    @PUT
    @Path("/actualizar-categoria")
    @Consumes("application/json")
    public void updateCategory(Categoria entity) {
        try {
            categoriaService.update(entity);
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
