package transaccionDetalle.bean;

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
    public BaseEntity(T idCabecera, T item) {
        super.idCabecera = idCabecera;
        super.item = item;
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