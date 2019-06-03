package par.transaccionDetalle.domain.repository;

import java.util.Collection;
import java.util.List;
import par.transaccionDetalle.domain.model.entity.Entity;

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
     * @param cabecera
     * @return
     * @throws Exception 
     */
    List<TE> transaccionesDetallePorCabecera(int cabecera) throws Exception;
    
}
