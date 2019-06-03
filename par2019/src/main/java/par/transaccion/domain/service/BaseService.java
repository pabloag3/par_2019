package par.transaccion.domain.service;

import java.util.Collection;
import par.transaccion.domain.repository.Repository;

/**
 *
 * @author Pablo Aguilar
 * @param <TE>
 * @param <T>
 */
public abstract class BaseService<TE, T> extends ReadOnlyBaseService<TE, T> {

    private Repository<TE, T> _repository;

    BaseService(Repository<TE, T> repository) {
        super(repository);
        _repository = repository;
    }

    /**
     *
     * @param entity
     * @throws Exception
     */
    public int add(TE entity) throws Exception {
        return _repository.add(entity);
    }

    /**
     *
     * @return
     */
    public Collection<TE> getAll() throws Exception {
        return _repository.getAll();
    }
}
