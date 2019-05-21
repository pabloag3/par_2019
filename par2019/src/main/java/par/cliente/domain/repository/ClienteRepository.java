package par.cliente.domain.repository;

import java.util.Collection;

/**
 *
 * @author Pablo Aguilar
 * @param <Cliente>
 * @param <Integer>
 */
public interface ClienteRepository<Cliente, Integer> extends Repository<Cliente, Integer> {

    /**
     *
     * @param nombre
     * @param apellido
     * @return
     */
    boolean containsNombreApellido(String nombre, String apellido);

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
     * @param loginName
     * @return
     */
    boolean containsLoginName(String loginName);

    /**
     *
     * @param loginName
     * @return
     * @throws Exception
     */
    public Collection<Cliente> findByLoginName(String loginName) throws Exception;

    /**
     * 
     * @param loginName
     * @param pass
     * @return
     * @throws Exception 
     */
    public Cliente findByLoginNamePass(String loginName, String pass) throws Exception;
}
