/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import cliente.bean.Cliente;
import java.util.ArrayList;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;



/**
 *
 * @author Perez
 */
public class ClienteModelo {
    final String path = "http://localhost:8080/parzon/clientes"; 

    ResteasyClient client = new ResteasyClientBuilder().build();
    ResteasyWebTarget target;
    Response clienteResponse;
    
    // POST
    public void agregar(Cliente nuevoCliente) {
        target = client.target(UriBuilder.fromPath(path + "/agregar-cliente"));
        clienteResponse =  target.request().post(Entity.entity(nuevoCliente, "application/json") );
        System.out.println("HTTP code: " + clienteResponse.getStatus());
        clienteResponse.close();
    }

 
    // GET
    public Cliente traerCliene(Integer id) {
        target = client.target(UriBuilder.fromPath(path + "/traer-cliente/" + id ));
        Cliente cli = (Cliente) target.request().get().getEntity();
        return cli;
    }

    // GET
    public ArrayList<Cliente> traerClienes() {
        ArrayList<Cliente> cli = target.request().get(ArrayList.class);
        return cli;
    }

    // PUT
    public void actualizarCliente(Cliente actualizarCliente) {
        target = client.target(UriBuilder.fromPath(path + "/actualizar-cliente"));
        clienteResponse = target.request().put(Entity.entity(actualizarCliente, "application/json"));
        clienteResponse.close();
    }

    // DELETE
    public void borrarCliente(Integer id) {
        target = client.target(UriBuilder.fromPath(path + "/borrar-cliente/" + id));
        clienteResponse = target.request().delete();
        clienteResponse.close();
    }

}
