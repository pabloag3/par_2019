/*
 */
package modelos;

import categoria.bean.Categoria;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import producto.bean.Producto;
import java.util.ArrayList;
import java.util.LinkedHashMap;
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
    final String pathCategoria = "http://localhost:8084/par2019/parzon/categorias";

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
        List<LinkedHashMap> prods = client.target(path + "/traer-productos")
                .request(MediaType.APPLICATION_JSON).get(List.class);

        List<Producto> listProduct = castearProducto(prods);
        return listProduct;
    }

    //GET
    public List<Producto> traerProductos(String des, String cat) throws Exception {
        Client client = ClientBuilder.newClient().register(new JacksonFeature());
        List<LinkedHashMap> prods = client.target(path + "/traer-producto?des=" + des + "&cat=" + cat)
                .request(MediaType.APPLICATION_JSON).get(List.class);
        List<Producto> listProduct = castearProducto(prods);
        return listProduct;
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

    //Bloque Categoria
    public List<Categoria> traerCategorias() {
        Client client = ClientBuilder.newClient().register(new JacksonFeature());
        List<LinkedHashMap> cate = client.target(pathCategoria + "/traer-categorias")
                .request(MediaType.APPLICATION_JSON).get(List.class);

        List<Categoria> listCate = castearCategoria(cate);
        return listCate;
    }

    private List<Producto> castearProducto(List<LinkedHashMap> prods) {
        List<Producto> product = new ArrayList<>();
        for(LinkedHashMap prod : prods) {
            Producto producto = new Producto();
            producto.setId(Integer.valueOf( prod.get("id").toString()));
            producto.setDescripcion((String)prod.get("descripcion"));
            producto.setIdCategoria(Integer.valueOf( prod.get("idCategoria").toString()));
            producto.setPrecioUnit(Long.valueOf( prod.get("precioUnit").toString()));
            producto.setCantidad(Long.valueOf( prod.get("cantidad").toString()));
            product.add(producto);
        }
        return product;
    }

    private List<Categoria> castearCategoria(List<LinkedHashMap> cate) {
        List<Categoria> categorias = new ArrayList<>();
        for(LinkedHashMap categoria : cate) {
            Categoria categor = new Categoria();
            categor.setId(Integer.valueOf(categoria.get("id").toString()));
            categor.setDescripcion((String)categoria.get("descripcion"));
            categorias.add(categor);
        }
        return categorias;
    }
}
