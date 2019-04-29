package par.producto.domain.repository;

import java.util.Collection;
import par.producto.domain.model.entity.Entity;

/**
 *
 * @author Sourabh Sharma
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
     */
    Entity get(T id) throws Exception;

    /**
     *
     * @return
     */
    Collection<TE> getAll() throws Exception;
}
