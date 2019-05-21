package par.cliente.domain.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import par.cliente.domain.model.entity.Entity;
import par.cliente.domain.model.entity.Cliente;
import par.cliente.domain.repository.ClienteRepository;

/**
 *
 * @author Pablo Aguilar
 */
//@Service("clienteService")
public class ClienteServiceImpl extends BaseService<Cliente, Integer>
        implements ClienteService {

    private ClienteRepository<Cliente, Integer> clienteRepository;

    /**
     *
     * @param clienteRepository
     */
    //@Autowired
    public ClienteServiceImpl(ClienteRepository<Cliente, Integer> clienteRepository) {
        super(clienteRepository);
        this.clienteRepository = clienteRepository;
    }

    @Override
    public void add(Cliente cliente) throws Exception {
        if (clienteRepository.containsNombreApellido(cliente.getNombre(), cliente.getApellido())) {
            throw new Exception(String.format("Ya existe un usuario con el nombre %s y el apellido %s", cliente.getNombre(), cliente.getApellido()));
        }
        
        if (clienteRepository.containsLoginName(cliente.getLoginName())) {
            throw new Exception(String.format("Ya existe un usuario con el login name %s", cliente.getLoginName()));
        }

        if (cliente.getNombre() == null || "".equals(cliente.getNombre())) {
            throw new Exception("El nombre del usuario no puede ser nulo o cadena vacia.");
        }
        
        if (cliente.getApellido() == null || "".equals(cliente.getApellido())) {
            throw new Exception("El apellido del usuario no puede ser nulo o cadena vacia.");
        }
        
        super.add(cliente);
    }

    /**
     *
     * @param nombre
     * @param apellido
     * @return
     * @throws Exception
     */
    @Override
    public Collection<Cliente> findByNombreApellido(String nombre, String apellido) throws Exception {
        return clienteRepository.findByNombreApellido(nombre, apellido);
    }

    /**
     *
     * @param cliente
     * @throws Exception
     */
    @Override
    public void update(Cliente cliente) throws Exception {
        clienteRepository.update(cliente);
    }

    /**
     *
     * @param id
     * @throws Exception
     */
    @Override
    public void delete(Integer id) throws Exception {
        clienteRepository.remove(id);
    }

    /**
     *
     * @param id
     * @return
     * @throws Exception
     */
    @Override
    public Entity findById(Integer id) throws Exception {
        return clienteRepository.get(id);
    }

    /**
     *
     * @param name
     * @return
     * @throws Exception
     */
    @Override
    public Collection<Cliente> findByCriteria(Map<String, ArrayList<String>> name) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Cliente findByLoginNamePass(String loginName, String pass)  throws Exception {
        return clienteRepository.findByLoginNamePass(loginName, pass);
    }
}
