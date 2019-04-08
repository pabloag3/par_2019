package par.transaccion.domain.model.entity;

import java.util.Date;

/**
 *
 * @author PabloAgHP
 */
public class Transaccion extends BaseEntity<Integer> {

    private Date fecha;
    private int idCliente;
    private long total;
    private String direccionEnvio;
    private int idMedioPago;
    private Long nroTarjeta;
    private String estado;
    
    public Transaccion() {
        super(0);
    }
    
    /**
     *
     * @param fecha
     * @param idCliente
     * @param total
     * @param direccionEnvio
     * @param idMedioPago
     * @param nroTarjeta
     * @param estado
     */
    public Transaccion(Integer id, Date fecha, int idCliente, long total,
            String direccionEnvio, int idMedioPago, Long nroTarjeta, String estado) {
        super(id);
        this.fecha = fecha;
        this.idCliente = idCliente;
        this.total = total;
        this.direccionEnvio = direccionEnvio;
        this.idMedioPago = idMedioPago;
        this.nroTarjeta = nroTarjeta;
        this.estado = estado;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public String getDireccionEnvio() {
        return direccionEnvio;
    }

    public void setDireccionEnvio(String direccionEnvio) {
        this.direccionEnvio = direccionEnvio;
    }

    public int getIdMedioPago() {
        return idMedioPago;
    }

    public void setIdMedioPago(int idMedioPago) {
        this.idMedioPago = idMedioPago;
    }

    public Long getNroTarjeta() {
        return nroTarjeta;
    }

    public void setNroTarjeta(Long nroTarjeta) {
        this.nroTarjeta = nroTarjeta;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

   /**
     * Overridden toString() method that return String presentation of the
     * Object
     *
     * @return
     */
    @Override
    public String toString() {
        return new StringBuilder("{id: ").append(id).append(", fecha: ")
                .append(fecha).append(", idCliente: ").append(idCliente)
                .append(", total: ").append(total)
                .append(", direccionEnvio: ").append(direccionEnvio)
                .append(", idMedioPago: ").append(idMedioPago)
                .append(", nroTarjeta: ").append(nroTarjeta)
                .append(", estado: ").append(estado).append("}").toString();
    }
    
}