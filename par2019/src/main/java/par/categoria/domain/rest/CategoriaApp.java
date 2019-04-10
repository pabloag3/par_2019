package par.categoria.domain.rest;

import java.util.HashSet;
import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author Pablo Aguilar
 */
public class CategoriaApp extends Application {

    private Set<Object> singletons = new HashSet<Object>();

    public CategoriaApp() {
        singletons.add(new CategoriaRestService());
    }

    @Override
    public Set<Object> getSingletons() {
        return singletons;
    }
}
