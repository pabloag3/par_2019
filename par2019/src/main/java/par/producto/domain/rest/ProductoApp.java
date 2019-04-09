package par.producto.domain.rest;

import java.util.HashSet;
import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author Pablo Aguilar
 */
public class ProductoApp extends Application {

    private Set<Object> singletons = new HashSet<Object>();

    public ProductoApp() {
        singletons.add(new ProductoRestService());
    }

    @Override
    public Set<Object> getSingletons() {
        return singletons;
    }
}
