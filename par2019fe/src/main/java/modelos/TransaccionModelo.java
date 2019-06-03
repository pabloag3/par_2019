package modelos;

import java.sql.Date;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import org.glassfish.jersey.jackson.JacksonFeature;
import transaccion.bean.Transaccion;
import transaccionDetalle.bean.TransaccionDetalle;

/**
 *
 * @author tatoa
 */
public class TransaccionModelo {
    
    final String path = "http://localhost:8084/par2019/parzon/transaccion";
    
    
    // GET
    public List<Transaccion> traerTransacciones(int cliente) { // traer las transacciones de un cliente
        Client client = ClientBuilder.newClient().register(new JacksonFeature());
        List<LinkedHashMap> transac = client.target(path + "/traer-transacciones-cliente/" + cliente)
                .request(MediaType.APPLICATION_JSON).get(List.class);
        List<Transaccion> listProduct = castearTransacciones(transac);
        return listProduct;
    }

    // POST
    public void agregarTransaccion(Transaccion nuevaTransaccion) {
//        int id = 0;
        Client client = ClientBuilder.newClient().register(new JacksonFeature());
        client.target(path + "/agregar-transaccion").
                request(MediaType.APPLICATION_JSON).
                post(Entity.entity(nuevaTransaccion, MediaType.APPLICATION_JSON));
//        return id;
    }

    private List<Transaccion> castearTransacciones(List<LinkedHashMap> transac) {
        List<Transaccion> transacciones = new ArrayList<>();
        for(LinkedHashMap trans : transac) {
            Transaccion transaccion = new Transaccion();
            transaccion.setId(Integer.valueOf(trans.get("id").toString()));
            transaccion.setFecha(Date.valueOf(trans.get("fecha").toString()));
            transaccion.setIdCliente(Integer.valueOf(trans.get("idCliente").toString()));
            transaccion.setTotal(Long.valueOf(trans.get("total").toString()));
            transaccion.setDireccionEnvio((String)trans.get("direccionEnvio"));
            transaccion.setIdMedioPago(Integer.valueOf(trans.get("idMedioPago").toString()));
            transaccion.setNroTarjeta(Long.valueOf(trans.get("nroTarjeta").toString()));
            transaccion.setEstado((String)trans.get("estado"));
            transacciones.add(transaccion);
        }
        return transacciones;
    }
    
    // POST
    public void agregarTransaccionDetalle(TransaccionDetalle nuevaTransaccionDetalle) {
//        int id = 0;
        Client client = ClientBuilder.newClient().register(new JacksonFeature());
        client.target(path + "/agregar-transaccion").
                request(MediaType.APPLICATION_JSON).
                post(Entity.entity(nuevaTransaccionDetalle, MediaType.APPLICATION_JSON));
//        return id;
    }
    
}
