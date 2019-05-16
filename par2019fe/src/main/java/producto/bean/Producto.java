package producto.bean;

/**
 *
 * @author Pablo Aguilar
 * @author Porfirio Perez
 */
public class Producto extends BaseEntity<Integer> {

    private int idCategoria;
    private Long precioUnit;
    private Long cantidad;
    
    public Producto() {
        super(0, "");
    }
    
    /**
     *
     * @param id
     * @param descripcion
     * @param idCategoria
     * @param precioUnit
     * @param cantidad
     */
    public Producto(Integer id, String descripcion, int idCategoria, Long precioUnit, Long cantidad) {
        super(id, descripcion);
        this.idCategoria = idCategoria;
        this.precioUnit = precioUnit;
        this.cantidad = cantidad;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public Long getPrecioUnit() {
        return precioUnit;
    }

    public void setPrecioUnit(Long precioUnit) {
        this.precioUnit = precioUnit;
    }

    public Long getCantidad() {
        return cantidad;
    }

    public void setCantidad(Long cantidad) {
        this.cantidad = cantidad;
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
                .append(descripcion).append(", idCategoria: ").append(idCategoria)
                .append(", precioUnit: ").append(precioUnit)
                .append(", cantidad: ").append(cantidad)
                .append("}").toString();
    }
}