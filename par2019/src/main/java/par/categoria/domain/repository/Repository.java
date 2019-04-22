package par.categoria.domain.repository;

import par.cliente.domain.repository.*;

/**
 *
 * @author Pablo Aguilar
 * @param <TE>
 * @param <T>
 */
public interface Repository<TE, T> extends ReadOnlyRepository<TE, T> {

    /**
     *
     * @param entity
     * @throws java.lang.Exception
     */
    void add(TE entity) throws Exception;

    /**
     *
     * @param id
     * @throws java.lang.Exception
     */
    void remove(T id) throws Exception;

    /**
     *
     * @param entity
     * @throws java.lang.Exception
     */
    void update(TE entity) throws Exception;
}
