package par.categoria.domain.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import par.categoria.domain.model.entity.Entity;
import par.categoria.domain.model.entity.Categoria;
import par.categoria.domain.repository.CategoriaRepository;

/**
 *
 * @author Pablo Aguilar
 */
//@Service("categoriaService")
public class CategoriaServiceImpl extends BaseService<Categoria, Integer>
        implements CategoriaService {

    private CategoriaRepository<Categoria, Integer> categoriaRepository;

    /**
     *
     * @param categoriaRepository
     */
    //@Autowired
    public CategoriaServiceImpl(CategoriaRepository<Categoria, Integer> categoriaRepository) {
        super(categoriaRepository);
        this.categoriaRepository = categoriaRepository;
    }

    @Override
    public void add(Categoria categoria) throws Exception {
        if (categoriaRepository.containsDescripcion(categoria.getDescripcion())) {
            throw new Exception(String.format("Ya existe una categoria con la descripcion %s", categoria.getDescripcion()));
        }
        
        if (categoria.getDescripcion()== null || "".equals(categoria.getDescripcion())) {
            throw new Exception("El nombre del usuario no puede ser nulo o cadena vacia.");
        }
        
        super.add(categoria);
    }

    /**
     *
     * @param descripcion
     * @return
     * @throws Exception
     */
    @Override
    public Collection<Categoria> findByDescripcion(String descripcion) throws Exception {
        return categoriaRepository.findByDescripcion(descripcion);
    }

    /**
     *
     * @param categoria
     * @throws Exception
     */
    @Override
    public void update(Categoria categoria) throws Exception {
        categoriaRepository.update(categoria);
    }

    /**
     *
     * @param id
     * @throws Exception
     */
    @Override
    public void delete(Integer id) throws Exception {
        categoriaRepository.remove(id);
    }

    /**
     *
     * @param id
     * @return
     * @throws Exception
     */
    @Override
    public Entity findById(Integer id) throws Exception {
        return categoriaRepository.get(id);
    }

    /**
     *
     * @param name
     * @return
     * @throws Exception
     */
    @Override
    public Collection<Categoria> findByCriteria(Map<String, ArrayList<String>> name) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
