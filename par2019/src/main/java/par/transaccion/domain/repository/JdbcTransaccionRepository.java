package par.transaccion.domain.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import par.util.DBUtils;
import par.transaccion.domain.model.entity.Entity;
import par.transaccion.domain.model.entity.Transaccion;

/**
 *
 * @author Sourabh Sharma
 */
//@Repository("transaccionRepository")
public class JdbcTransaccionRepository implements TransaccionRepository<Transaccion, Integer> {

    private Map<String, Transaccion> entities;

    /**
     *
     * @param entity
     */
    @Override
    public int add(Transaccion entity) throws Exception {
        Connection c = null;
        PreparedStatement pstmt = null;
        int indice = 0;
        
        try {
            c = DBUtils.getConnection();
            pstmt = c.prepareStatement("INSERT INTO transacciones_cab "
                    + "(fecha, id_cliente, total, direccion_envio, id_medio_pago, "
                    + "nro_tarjeta, estado) "
                    + "values (?, ?, ?, ?, ?, ?, ?) RETURNING id_transaccion");

            pstmt.setDate(1, entity.getFecha());
            pstmt.setInt(2, entity.getIdCliente());
            pstmt.setLong(3, entity.getTotal());
            pstmt.setString(4, entity.getDireccionEnvio());
            pstmt.setInt(5, entity.getIdMedioPago());
            pstmt.setLong(6, entity.getNroTarjeta());
            pstmt.setString(7, entity.getEstado());

            ResultSet rs = pstmt.executeQuery();
            rs.next();
            indice = rs.getInt(1);
                    
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
        return indice;
    }

    /**
     *
     * @param id
     * @return
     */
    @Override
    public boolean contains(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     *
     * @param id
     * @return
     */
    @Override
    public Entity get(Integer id) throws Exception {
        Entity retValue = null;

        Connection c = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            c = DBUtils.getConnection();
            pstmt = c.prepareStatement("SELECT * FROM transacciones_cab WHERE id_transaccion = ?");

            pstmt.setInt(1, id);

            rs = pstmt.executeQuery();

            if (rs.next()) {
                retValue = new Transaccion(rs.getInt("id_transaccion"), 
                        rs.getDate("fecha"), 
                        rs.getInt("id_cliente"), 
                        rs.getLong("total"), 
                        rs.getString("direccion_envio"), 
                        rs.getInt("id_medio_pago"), 
                        rs.getLong("nro_tarjeta"), 
                        rs.getString("estado"));
            } else {
                retValue = new Transaccion(0,null,0,0,null,0,(long) 0,null);
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

        return retValue;
    }

    /**
     *
     * @return
     */
    @Override
    public Collection<Transaccion> getAll() throws Exception {
        Collection<Transaccion> retValue = new ArrayList();

        Connection c = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            c = DBUtils.getConnection();
            pstmt = c.prepareStatement("SELECT * FROM transacciones_cab");

            rs = pstmt.executeQuery();

            while (rs.next()) {
                retValue.add(new Transaccion(rs.getInt("id_transaccion"), 
                        rs.getDate("fecha"), 
                        rs.getInt("id_cliente"), 
                        rs.getLong("total"), 
                        rs.getString("direccion_envio"), 
                        rs.getInt("id_medio_pago"), 
                        rs.getLong("nro_tarjeta"), 
                        rs.getString("estado")));
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

        return retValue;
    }

    @Override
    public List<Transaccion> findCabeceras(int idCliente) throws Exception {
        List<Transaccion> lista = new ArrayList();
        
        Connection c = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        
        try {
            c = DBUtils.getConnection();
            pstmt = c.prepareStatement("SELECT * FROM transacciones_cab "
                                    + "WHERE id_cliente = ?"
                                    + "AND estado = 'P'");
            pstmt.setInt(1, idCliente);
            rs = pstmt.executeQuery();
            
            while (rs.next()) {
                lista.add(new Transaccion(rs.getInt("id_transaccion"), 
                        rs.getDate("fecha"), 
                        rs.getInt("id_cliente"), 
                        rs.getLong("total"), 
                        rs.getString("direccion_envio"), 
                        rs.getInt("id_medio_pago"), 
                        rs.getLong("nro_tarjeta"), 
                        rs.getString("estado")));
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
