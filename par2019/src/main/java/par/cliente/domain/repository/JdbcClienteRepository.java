package par.cliente.domain.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import par.util.DBUtils;
import par.cliente.domain.model.entity.Entity;
import par.cliente.domain.model.entity.Cliente;

/**
 *
 * @author Pablo Aguilar
 */
//@Repository("clienteRepository")
public class JdbcClienteRepository implements ClienteRepository<Cliente, Integer> {

    private Map<String, Cliente> entities;

    /**
     * Check if given user name already exist.
     *
     * @param nombre
     * @param apellido
     * @return true if already exist, else false
     */
    @Override
    public boolean containsNombreApellido(String nombre, String apellido) {
        try {
            return this.findByNombreApellido(nombre, apellido).size() > 0;
        } catch (Exception ex) {
            //Exception Handler
        }
        return false;
    }

    /**
     *
     * @param entity
     */
    @Override
    public void add(Cliente entity) throws Exception {
        Connection c = null;
        PreparedStatement pstmt = null;

        try {
            c = DBUtils.getConnection();
            pstmt = c.prepareStatement("INSERT INTO cliente "
                    + "(nombre, apellido, email, login_name, passwd, "
                    + "tipo_cliente) "
                    + "values (?, ?, ?, ?, ?, ?)");

            pstmt.setString(1, entity.getNombre());
            pstmt.setString(2, entity.getApellido());
            pstmt.setString(3, entity.getEmail());
            pstmt.setString(4, entity.getLoginName());
            pstmt.setString(5, entity.getPasswd());
            pstmt.setInt(6, entity.getTipoCliente());

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
     */
    @Override
    public void remove(Integer id) throws Exception {
        Connection c = null;
        PreparedStatement pstmt = null;

        try {
            c = DBUtils.getConnection();
            pstmt = c.prepareStatement("DELETE FROM cliente WHERE id_cliente = ?");

            pstmt.setInt(1, id);

            pstmt.executeUpdate();
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
     * @param entity
     */
    @Override
    public void update(Cliente entity) throws Exception  {
        Connection c = null;
        PreparedStatement pstmt = null;

        try {
            c = DBUtils.getConnection();
            pstmt = c.prepareStatement("UPDATE cliente "
                    + "SET nombre = ?, apellido = ?, email = ?, login_name = ?, "
                    + "passwd = ?, tipo_cliente = ? "
                    + "WHERE id_cliente = ?");

            pstmt.setString(1, entity.getNombre());
            pstmt.setString(2, entity.getApellido());
            pstmt.setString(3, entity.getEmail());
            pstmt.setString(4, entity.getLoginName());
            pstmt.setString(5, entity.getPasswd());
            pstmt.setInt(6, entity.getTipoCliente());
            pstmt.setInt(7, entity.getId());

            pstmt.executeUpdate();
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
            pstmt = c.prepareStatement("SELECT * FROM cliente WHERE id_cliente = ?");

            pstmt.setInt(1, id);

            rs = pstmt.executeQuery();

            if (rs.next()) {
                retValue = new Cliente(rs.getInt("id_cliente"), 
                        rs.getString("nombre"), 
                        rs.getString("apellido"), 
                        rs.getString("email"), 
                        rs.getString("login_name"), 
                        rs.getString("passwd"), 
                        rs.getInt("tipo_cliente"));
            } else {
                retValue = new Cliente(null,null,null,null,null,null,0);
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
    public Collection<Cliente> getAll() throws Exception {
        Collection<Cliente> retValue = new ArrayList();

        Connection c = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            c = DBUtils.getConnection();
            pstmt = c.prepareStatement("SELECT * FROM cliente");

            rs = pstmt.executeQuery();

            while (rs.next()) {
                retValue.add(new Cliente(rs.getInt("id_cliente"), 
                        rs.getString("nombre"), 
                        rs.getString("apellido"), 
                        rs.getString("email"), 
                        rs.getString("login_name"), 
                        rs.getString("passwd"), 
                        rs.getInt("tipo_cliente")));
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
     * @param nombre
     * @param apellido
     * @return
     * @throws Exception
     */
    @Override
    public Collection<Cliente> findByNombreApellido(String nombre, String apellido) 
            throws Exception { Collection<Cliente> retValue = new ArrayList();

        Connection c = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            c = DBUtils.getConnection();
            pstmt = c.prepareStatement("SELECT * FROM cliente WHERE nombre = ? and apellido = ?");

            pstmt.setString(1, nombre);
            pstmt.setString(2, apellido);

            rs = pstmt.executeQuery();

            if (rs.next()) {
                retValue.add(new Cliente(rs.getInt("id_cliente"), 
                        rs.getString("nombre"), 
                        rs.getString("apellido"), 
                        rs.getString("email"), 
                        rs.getString("login_name"), 
                        rs.getString("passwd"), 
                        rs.getInt("tipo_cliente")));
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
    public boolean containsLoginName(String loginName) {
        try {
            return this.findByLoginName(loginName).size() > 0;
        } catch (Exception ex) {
            //Exception Handler
        }
        return false;
    }

    @Override
    public Collection<Cliente> findByLoginName(String loginName) throws Exception {
        Collection<Cliente> retValue = new ArrayList();

        Connection c = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            c = DBUtils.getConnection();
            pstmt = c.prepareStatement("SELECT * FROM cliente WHERE login_name = ?");

            pstmt.setString(1, loginName);

            rs = pstmt.executeQuery();

            if (rs.next()) {
                retValue.add(new Cliente(rs.getInt("id_cliente"), 
                        rs.getString("nombre"), 
                        rs.getString("apellido"), 
                        rs.getString("email"), 
                        rs.getString("login_name"), 
                        rs.getString("passwd"), 
                        rs.getInt("tipo_cliente")));
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
    public Cliente findByLoginNamePass(String loginName, String pass) throws Exception {
        Cliente retValue = new Cliente();
        Connection c = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            c = DBUtils.getConnection();
            pstmt = c.prepareStatement("SELECT * FROM cliente WHERE login_name = ? and passwd = ?");
            pstmt.setString(1, loginName);
            pstmt.setString(2, pass);
            rs = pstmt.executeQuery();
            int cont = 0;
            if (rs.next()) {
                if(++cont > 1) throw new Exception("Existe mas de un Cliente");
                retValue = new Cliente(rs.getInt("id_cliente"), 
                        rs.getString("nombre"), 
                        rs.getString("apellido"), 
                        rs.getString("email"), 
                        rs.getString("login_name"), 
                        rs.getString("passwd"), 
                        rs.getInt("tipo_cliente"));
            }                
        } catch (Exception e) {
            throw new Exception(e);
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
}
