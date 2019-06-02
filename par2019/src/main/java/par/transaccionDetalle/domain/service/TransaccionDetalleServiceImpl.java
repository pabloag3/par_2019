package par.transaccionDetalle.domain.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import par.transaccionDetalle.domain.model.entity.Entity;
import par.transaccionDetalle.domain.model.entity.TransaccionDetalle;
import par.transaccionDetalle.domain.repository.TransaccionDetalleRepository;

/**
 *
 * @author Pablo Aguilar
 */
//@Service("transaccionDetalleService")
public class TransaccionDetalleServiceImpl extends BaseService<TransaccionDetalle, Integer>
        implements TransaccionDetalleService {

    private TransaccionDetalleRepository<TransaccionDetalle, Integer> transaccionDetalleRepository;

    /**
     *
     * @param transaccionDetalleRepository
     */
    //@Autowired
    public TransaccionDetalleServiceImpl(TransaccionDetalleRepository<TransaccionDetalle, Integer> transaccionDetalleRepository) {
        super(transaccionDetalleRepository);
        this.transaccionDetalleRepository = transaccionDetalleRepository;
    }

    @Override
    public void add(TransaccionDetalle transaccionDetalle) throws Exception {        
        super.add(transaccionDetalle);
    }

    /**
     *
     * @param id
     * @return
     * @throws Exception
     */
    @Override
    public Entity findById(Integer id) throws Exception {
        return transaccionDetalleRepository.get(id);
    }

    /**
     *
     * @param name
     * @return
     * @throws Exception
     */
    @Override
    public Collection<TransaccionDetalle> findByCriteria(Map<String, ArrayList<String>> name) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    public List<TransaccionDetalle> traerDetalleDeCabecera(int cabecera) throws Exception {
        return transaccionDetalleRepository.transaccionesDetallePorCabecera(cabecera);
    }

}
