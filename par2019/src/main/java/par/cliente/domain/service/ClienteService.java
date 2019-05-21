package par.cliente.domain.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import par.cliente.domain.model.entity.Entity;
import par.cliente.domain.model.entity.Cliente;

/**
 *
 * @author Pablo Aguilar
 */
public interface ClienteService {

    /**
     *
     * @param cliente
     * @throws Exception
     */
    public void add(Cliente cliente) throws Exception;

    /**
     *
     * @param cliente
     * @throws Exception
     */
    public void update(Cliente cliente) throws Exception;

    /**
     *
     * @param id
     * @throws Exception
     */
    public void delete(Integer id) throws Exception;

    /**
     *
     * @param id
     * @return
     * @throws Exception
     */
    public Entity findById(Integer id) throws Exception;

    /**
     *
     * @param nombre
     * @param apellido
     * @return
     * @throws Exception
     */
    public Collection<Cliente> findByNombreApellido(String nombre, String apellido) throws Exception;

    /**
     *
     * @param name
     * @return
     * @throws Exception
     */
    public Collection<Cliente> findByCriteria(Map<String, ArrayList<String>> name) throws Exception;

    /**
     * 
     * @param loginName
     * @param pass
     * @return
     * @throws Exception 
     */
    public Cliente findByLoginNamePass(String loginName, String pass) throws Exception;
}
