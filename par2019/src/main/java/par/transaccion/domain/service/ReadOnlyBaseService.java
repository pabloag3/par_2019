package par.transaccion.domain.service;

import par.transaccion.domain.repository.Repository;

/**
 *
 * @author Pablo Aguilar
 * @param <TE>
 * @param <T>
 */
public abstract class ReadOnlyBaseService<TE, T> {

    private Repository<TE, T> repository;

    ReadOnlyBaseService(Repository<TE, T> repository) {
        this.repository = repository;
    }
}
