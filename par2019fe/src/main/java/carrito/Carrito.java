package carrito;

import java.util.ArrayList;
import producto.bean.Producto;

/**
 *
 * @author Pablo Aguilar
 */
public class Carrito {
    
    private ArrayList<Producto> items = new ArrayList<>();
    
    public ArrayList<Producto> getItems() {
        return items;
    }
    
    public void addItem(Producto p) {
        items.add(p);
    }

    public void setItems(ArrayList<Producto> items) {
        this.items = items;
    }
    
}
