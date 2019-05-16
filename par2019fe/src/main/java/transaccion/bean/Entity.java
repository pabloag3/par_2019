package transaccion.bean;

/**
 *
 * @author PabloAgHP
 */
public abstract class Entity<T> {

    T id;

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

}