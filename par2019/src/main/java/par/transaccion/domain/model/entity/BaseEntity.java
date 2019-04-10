package par.transaccion.domain.model.entity;

/**
 *
 * @author PabloAgHP
 */
public abstract class BaseEntity<T> extends Entity<T> {

    private boolean isModified;

    /**
     *
     * @param id
     */
    public BaseEntity(T id) {
        super.id = id;
        isModified = false;
    }

    /**
     *
     * @return
     */
    public boolean isIsModified() {
        return isModified;
    }

}