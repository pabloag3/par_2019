package par.categoria.domain.repository;

import java.util.Collection;

/**
 *
 * @author Pablo Aguilar
 * @param <Categoria>
 * @param <Integer>
 */
public interface CategoriaRepository<Categoria, Integer> extends Repository<Categoria, Integer> {

    /**
     *
     * @param descripcion
     * @return
     * @throws Exception
     */
    public Collection<Categoria> findByDescripcion(String descripcion) throws Exception;
    
    /**
     *
     * @param loginName
     * @return
     */
    boolean containsDescripcion(String loginName);
 
}
