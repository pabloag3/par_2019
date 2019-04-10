package par.categoria.domain.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import par.categoria.domain.model.entity.Entity;
import par.categoria.domain.model.entity.Categoria;

/**
 *
 * @author Pablo Aguilar
 */
public interface CategoriaService {

    /**
     *
     * @param cliente
     * @throws Exception
     */
    public void add(Categoria cliente) throws Exception;

    /**
     *
     * @param cliente
     * @throws Exception
     */
    public void update(Categoria cliente) throws Exception;

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
    public Collection<Categoria> findByDescripcion(String descripcion) throws Exception;

    /**
     *
     * @param name
     * @return
     * @throws Exception
     */
    public Collection<Categoria> findByCriteria(Map<String, ArrayList<String>> name) throws Exception;
}
