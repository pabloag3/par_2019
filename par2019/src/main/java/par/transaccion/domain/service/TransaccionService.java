package par.transaccion.domain.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import par.transaccion.domain.model.entity.Entity;
import par.transaccion.domain.model.entity.Transaccion;

/**
 *
 * @author Pablo Aguilar
 */
public interface TransaccionService {

    /**
     *
     * @param transaccion
     * @throws Exception
     */
    public int add(Transaccion transaccion) throws Exception;
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
    public Collection<Transaccion> findByCriteria(Map<String, ArrayList<String>> name) throws Exception;
    
    /**
     * 
     * @param cliente
     * @return
     * @throws Exception 
     */
    public List<Transaccion> findCabecerasPorCliente(int cliente) throws Exception;
}
