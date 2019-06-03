package par.transaccionDetalle.domain.model.entity;

/**
 *
 * @author PabloAgHP
 */
public class TransaccionDetalle extends BaseEntity<Integer> {

    private int idProducto;
    private int cantidad;
    private Long precio;
    private Long subTotal;
    
    public TransaccionDetalle() {
        super(0, 0);
    }

    public TransaccionDetalle(Integer idCabecera, Integer item, int idProducto, int cantidad, Long precio, Long subTotal) {
        super(idCabecera, item);
        this.idProducto = idProducto;
        this.cantidad = cantidad;
        this.precio = precio;
        this.subTotal = subTotal;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Long getPrecio() {
        return precio;
    }

    public void setPrecio(Long precio) {
        this.precio = precio;
    }

    public Long getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(Long subTotal) {
        this.subTotal = subTotal;
    }
    
    /**
     * Overridden toString() method that return String presentation of the
     * Object
     *
     * @return
     */
    @Override
    public String toString() {
        return new StringBuilder("{idTransaccion: ").append(super.idCabecera)
                .append(", item: ").append(super.item)
                .append(", idProducto: ").append(idProducto)
                .append(", cantidad: ").append(cantidad)
                .append(", precio: ").append(precio)
                .append(", subTotal: ").append(subTotal)
                .append("}").toString();
    }
    
}