package transaccionDetalle.bean;

/**
 *
 * @author PabloAgHP
 */
public abstract class Entity<T> {

    T idCabecera;
    T item;

    public T getIdcabecera() {
        return idCabecera;
    }

    public void setIdCabecera(T idCabecera) {
        this.idCabecera = idCabecera;
    }

    public T getItem() {
        return item;
    }

    public void setItem(T item) {
        this.item = item;
    }

}