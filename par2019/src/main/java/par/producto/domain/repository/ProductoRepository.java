package par.producto.domain.repository;

import java.util.Collection;

/**
 *
 * @author Pablo Aguilar
 * @param <Producto>
 * @param <Integer>
 */
public interface ProductoRepository<Producto, Integer> extends Repository<Producto, Integer> {

    /**
     *
     * @param descripcion
     * @return
     */
    boolean containsDescripcion(String descripcion);

    /**
     *
     * @param descripcion
     * @return
     * @throws Exception
     */
    public Collection<Producto> findByDescripcion(String descripcion) throws Exception;
    
}
