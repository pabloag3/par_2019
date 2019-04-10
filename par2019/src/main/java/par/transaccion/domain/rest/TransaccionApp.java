package par.transaccion.domain.rest;

import java.util.HashSet;
import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author Pablo Aguilar
 */
public class TransaccionApp extends Application {

    private Set<Object> singletons = new HashSet<Object>();

    public TransaccionApp() {
        singletons.add(new TransaccionRestService());
    }

    @Override
    public Set<Object> getSingletons() {
        return singletons;
    }
}
