package bean.producto.domain.model.entity;

/**
 *
 * @author PabloAgHP
 */
public abstract class Entity<T> {

    T id;
    String descripcion;

    /**
     *
     * @return
     */
    public T getId() {
        return id;
    }

    /**
     *
     * @param id
     */
    public void setId(T id) {
        this.id = id;
    }

    /**
     *
     * @return
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     *
     * @param nombre
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

}