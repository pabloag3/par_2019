package par.categoria.domain.repository;

import java.util.Collection;
import par.categoria.domain.model.entity.Entity;

/**
 *
 * @author Pablo Aguilar
 * @param <TE>
 * @param <T>
 */
public interface ReadOnlyRepository<TE, T> {

    //long Count;
    /**
     *
     * @param id
     * @return
     */
    boolean contains(T id) throws Exception;

    /**
     *
     * @param id
     * @return
     * @throws java.lang.Exception
     */
    Entity get(T id) throws Exception;

    /**
     *
     * @return
     * @throws java.lang.Exception
     */
    Collection<TE> getAll() throws Exception;
}
