package carrito;

import producto.bean.Producto;

/**
 *
 * @author tatoa
 */
public class Item {
    
    private Producto producto;
    private int cantidad;

    public Item() {
    }

    public Item(Producto producto, int cantidad) {
            this.producto = producto;
            this.cantidad = cantidad;
    }

    public Producto getProduct() {
            return producto;
    }

    public void setProduct(Producto producto) {
            this.producto = producto;
    }

    public int getQuantity() {
            return cantidad;
    }

    public void setQuantity(int cantidad) {
            this.cantidad = cantidad;
    }
    
}
