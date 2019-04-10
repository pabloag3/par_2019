package par.cliente.domain.rest;

import java.util.HashSet;
import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author Pablo Aguilar
 */
public class ClienteApp extends Application {

    private Set<Object> singletons = new HashSet<Object>();

    public ClienteApp() {
        singletons.add(new ClienteRestService());
    }

    @Override
    public Set<Object> getSingletons() {
        return singletons;
    }
}
