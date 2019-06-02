package par.transaccionDetalle.domain.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import par.util.DBUtils;
import par.transaccionDetalle.domain.model.entity.TransaccionDetalle;

/**
 *
 * @author Pablo Aguilar
 */
//@Repository("transaccionDetalleRepository")
public class JdbcTransaccionDetalleRepository implements TransaccionDetalleRepository<TransaccionDetalle, Integer> {

    private Map<String, TransaccionDetalle> entities;

    /**
     *
     * @param entity
     */
    @Override
    public void add(TransaccionDetalle entity) throws Exception {
        Connection c = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        int indice = 0;

        try {
            c = DBUtils.getConnection();
            pstmt = c.prepareStatement("INSERT INTO transacciones_det "
                    + "(id_transaccion, item, id_producto, cantidad, precio, sub_total) "
                    + "values (?, ?, ?, ?, ?, ?, ?)");
            pstmt.setInt(1, entity.getIdcabecera());
            pstmt.setInt(2, entity.getItem());
            pstmt.setInt(3, entity.getIdProducto());
            pstmt.setInt(4, entity.getCantidad());
            pstmt.setLong(5, entity.getPrecio());
            pstmt.setLong(6, entity.getSubTotal());
            pstmt.execute();
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
                DBUtils.closeConnection(c);
            } catch (SQLException ex) {
                //Logger.getLogger(UsuarioManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /**
     *
     * @param id
     * @return
     */
    @Override
    public boolean contains(Integer id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public par.transaccionDetalle.domain.model.entity.Entity get(Integer id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
        
    /**
     *
     * @return
     */
    @Override
    public Collection<TransaccionDetalle> getAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<TransaccionDetalle> transaccionesDetallePorCabecera(int cabecera) throws Exception {
        
        List<TransaccionDetalle> lista = new ArrayList();
        
        Connection c = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        
        try {
            c = DBUtils.getConnection();
            pstmt = c.prepareStatement("SELECT * FROM transacciones_det "
                                    + "WHERE id_transaccion = ?");
            pstmt.setInt(1, cabecera);
            rs = pstmt.executeQuery();
            
            while (rs.next()) {
                lista.add(new TransaccionDetalle(rs.getInt("id_transaccion"),
                        rs.getInt("item"),
                        rs.getInt("id_producto"),
                        rs.getInt("cantidad"),
                        rs.getLong("precio"),
                        rs.getLong("sub_total")));
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pstmt != null) {
                    pstmt.close();
                }
                DBUtils.closeConnection(c);
            } catch (SQLException ex) {
                //Logger.getLogger(UsuarioManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return lista;
        
    }

    

}
