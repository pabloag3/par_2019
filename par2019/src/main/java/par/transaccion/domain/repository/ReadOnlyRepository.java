package par.transaccion.domain.repository;

import java.util.Collection;
import java.util.List;
import par.transaccion.domain.model.entity.Entity;
import par.transaccion.domain.model.entity.Transaccion;

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
     */
    Entity get(T id) throws Exception;

    /**
     *
     * @return
     */
    Collection<TE> getAll() throws Exception;
    
    /**
     * 
     * @param idCliente
     * @return
     * @throws Exception 
     */
    List<Transaccion> findCabeceras(int idCliente) throws Exception;
}
