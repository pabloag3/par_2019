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
import org.glassfish.jersey.jackson.JacksonFeature;

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
        
        Client client = ClientBuilder.newClient().register(new JacksonFeature());
        client.target(path + "/agregar-producto").
                request(MediaType.APPLICATION_JSON).
                post(Entity.entity(nuevoProducto, MediaType.APPLICATION_JSON));
        
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
    public Producto traerProducto(Integer id) {
        Client client = ClientBuilder.newClient().register(new JacksonFeature());
        Producto producto = client.target(path + "/traer-productos/{" + id + "}")
                .request(MediaType.APPLICATION_JSON).get(Producto.class);
        return producto;
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
    public void actualizarProducto(Producto producto) {
        Client client = ClientBuilder.newClient().register(new JacksonFeature());
        client.target(path + "/actualizar-producto").request(MediaType.APPLICATION_JSON).put(Entity.entity(producto, MediaType.APPLICATION_JSON));
    }

    // DELETE
    public void borrarProducto(Integer id) {
        
        Client client = ClientBuilder.newClient().register(new JacksonFeature());
        client.target(path + "/borrar-producto/{" + id + "}").request(MediaType.APPLICATION_JSON).delete();
        
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
