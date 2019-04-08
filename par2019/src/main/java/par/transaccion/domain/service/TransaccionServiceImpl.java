package par.transaccion.domain.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import par.transaccion.domain.model.entity.Entity;
import par.transaccion.domain.model.entity.Transaccion;
import par.transaccion.domain.repository.TransaccionRepository;

/**
 *
 * @author Pablo Aguilar
 */
//@Service("transaccionService")
public class TransaccionServiceImpl extends BaseService<Transaccion, Integer>
        implements TransaccionService {

    private TransaccionRepository<Transaccion, Integer> transaccionRepository;

    /**
     *
     * @param transaccionRepository
     */
    //@Autowired
    public TransaccionServiceImpl(TransaccionRepository<Transaccion, Integer> transaccionRepository) {
        super(transaccionRepository);
        this.transaccionRepository = transaccionRepository;
    }

    @Override
    public void add(Transaccion transaccion) throws Exception {        
        super.add(transaccion);
    }

    /**
     *
     * @param transaccion
     * @throws Exception
     */
    @Override
    public void update(Transaccion transaccion) throws Exception {
        transaccionRepository.update(transaccion);
    }

    /**
     *
     * @param id
     * @throws Exception
     */
    @Override
    public void delete(Integer id) throws Exception {
        transaccionRepository.remove(id);
    }

    /**
     *
     * @param id
     * @return
     * @throws Exception
     */
    @Override
    public Entity findById(Integer id) throws Exception {
        return transaccionRepository.get(id);
    }

    /**
     *
     * @param name
     * @return
     * @throws Exception
     */
    @Override
    public Collection<Transaccion> findByCriteria(Map<String, ArrayList<String>> name) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
