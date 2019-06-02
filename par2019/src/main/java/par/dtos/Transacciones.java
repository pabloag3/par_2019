package par.dtos;

import java.util.List;
import par.transaccion.domain.model.entity.Transaccion;
import par.transaccionDetalle.domain.model.entity.TransaccionDetalle;

/**
 *
 * @author Perez
 */
public class Transacciones {
    
    public Transaccion cabecera;
    public List<TransaccionDetalle> detalles;

    public Transacciones() {
    }

    public Transaccion getCabecera() {
        return cabecera;
    }

    public void setCabecera(Transaccion cabecera) {
        this.cabecera = cabecera;
    }

    public List<TransaccionDetalle> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<TransaccionDetalle> detalles) {
        this.detalles = detalles;
    }

}
