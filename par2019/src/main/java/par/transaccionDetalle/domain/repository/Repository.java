package par.transaccionDetalle.domain.repository;

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

}
