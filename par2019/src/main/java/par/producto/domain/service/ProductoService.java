package par.producto.domain.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import par.producto.domain.model.entity.Entity;
import par.producto.domain.model.entity.Producto;

/**
 *
 * @author Pablo Aguilar
 */
public interface ProductoService {

    /**
     *
     * @param cliente
     * @throws Exception
     */
    public void add(Producto cliente) throws Exception;

    /**
     *
     * @param cliente
     * @throws Exception
     */
    public void update(Producto cliente) throws Exception;

    /**
     *
     * @param id
     * @throws Exception
     */
    public void delete(Integer id) throws Exception;

    /**
     *
     * @param id
     * @return
     * @throws Exception
     */
    public Entity findById(Integer id) throws Exception;

    /**
     *
     * @param nombre
     * @param apellido
     * @return
     * @throws Exception
     */
    public Collection<Producto> findByDescripcion(String descripcion, String categoria) throws Exception;

    /**
     *
     * @param name
     * @return
     * @throws Exception
     */
    public Collection<Producto> findByCriteria(Map<String, ArrayList<String>> name) throws Exception;
}
