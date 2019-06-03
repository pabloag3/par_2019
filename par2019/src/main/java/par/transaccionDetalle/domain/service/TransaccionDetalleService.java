package par.transaccionDetalle.domain.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import par.transaccionDetalle.domain.model.entity.Entity;
import par.transaccionDetalle.domain.model.entity.TransaccionDetalle;

/**
 *
 * @author Pablo Aguilar
 */
public interface TransaccionDetalleService {

    /**
     *
     * @param transaccionDetalle
     * @throws Exception
     */
    public void add(TransaccionDetalle transaccionDetalle) throws Exception;

    /**
     *
     * @param id
     * @return
     * @throws Exception
     */
    public Entity findById(Integer id) throws Exception;

    /**
     *
     * @param name
     * @return
     * @throws Exception
     */
    public Collection<TransaccionDetalle> findByCriteria(Map<String, ArrayList<String>> name) throws Exception;
}
