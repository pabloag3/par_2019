package par.producto.domain.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import par.producto.domain.model.entity.Entity;
import par.producto.domain.model.entity.Producto;
import par.producto.domain.repository.ProductoRepository;

/**
 *
 * @author Pablo Aguilar
 */
//@Service("productoService")
public class ProductoServiceImpl extends BaseService<Producto, Integer>
        implements ProductoService {

    private ProductoRepository<Producto, Integer> productoRepository;

    /**
     *
     * @param productoRepository
     */
    //@Autowired
    public ProductoServiceImpl(ProductoRepository<Producto, Integer> productoRepository) {
        super(productoRepository);
        this.productoRepository = productoRepository;
    }

    @Override
    public void add(Producto producto) throws Exception {
        if (producto.getDescripcion() == null || "".equals(producto.getDescripcion())) {
            throw new Exception("El nombre del producto no puede ser nulo o cadena vacia.");
        }
                
        super.add(producto);
    }

    /**
     *
     * @param descripcion
     * @return
     * @throws Exception
     */
    @Override
    public Collection<Producto> findByDescripcion(String descripcion) throws Exception {
        return productoRepository.findByDescripcion(descripcion);
    }

    /**
     *
     * @param producto
     * @throws Exception
     */
    @Override
    public void update(Producto producto) throws Exception {
        productoRepository.update(producto);
    }

    /**
     *
     * @param id
     * @throws Exception
     */
    @Override
    public void delete(Integer id) throws Exception {
        productoRepository.remove(id);
    }

    /**
     *
     * @param id
     * @return
     * @throws Exception
     */
    @Override
    public Entity findById(Integer id) throws Exception {
        return productoRepository.get(id);
    }

    /**
     *
     * @param name
     * @return
     * @throws Exception
     */
    @Override
    public Collection<Producto> findByCriteria(Map<String, ArrayList<String>> name) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
