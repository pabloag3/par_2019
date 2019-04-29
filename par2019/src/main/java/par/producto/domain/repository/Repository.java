package par.producto.domain.repository;

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
     */
    void add(TE entity) throws Exception;

    /**
     *
     * @param id
     */
    void remove(T id) throws Exception;

    /**
     *
     * @param entity
     */
    void update(TE entity) throws Exception;
}
