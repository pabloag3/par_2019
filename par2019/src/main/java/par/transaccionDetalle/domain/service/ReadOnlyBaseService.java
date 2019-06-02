package par.transaccionDetalle.domain.service;

import par.transaccionDetalle.domain.repository.Repository;

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
