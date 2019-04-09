package par.categoria.domain.model.entity;

/**
 *
 * @author PabloAgHP
 */
public class Categoria extends BaseEntity<Integer> {
    
    public Categoria() {
        super(0, "");
    }
    
    public Categoria(Integer id, String descripcion) {
        super(id, descripcion);
    }

      /**
     * Overridden toString() method that return String presentation of the
     * Object
     *
     * @return
     */
    @Override
    public String toString() {
        return new StringBuilder("{id: ").append(id).append(", descripcion: ")
                .append(descripcion).append("}").toString();
    }
}