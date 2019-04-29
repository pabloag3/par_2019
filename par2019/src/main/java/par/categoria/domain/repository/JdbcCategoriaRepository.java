package par.categoria.domain.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import par.util.DBUtils;
import par.categoria.domain.model.entity.Entity;
import par.categoria.domain.model.entity.Categoria;

/**
 *
 * @author Pablo Aguilar
 */
//@Repository("categoriaRepository")
public class JdbcCategoriaRepository implements CategoriaRepository<Categoria, Integer> {

    private Map<String, Categoria> entities;

    /**
     *
     * @param entity
     * @throws java.lang.Exception
     */
    @Override
    public void add(Categoria entity) throws Exception {
        Connection c = null;
        PreparedStatement pstmt = null;

        try {
            c = DBUtils.getConnection();
            pstmt = c.prepareStatement("INSERT INTO categoria (descripcion) "
                    + "values (?)");

            pstmt.setString(1, entity.getDescripcion());

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
     * @throws java.lang.Exception
     */
    @Override
    public void remove(Integer id) throws Exception {
        Connection c = null;
        PreparedStatement pstmt = null;

        try {
            c = DBUtils.getConnection();
            pstmt = c.prepareStatement("DELETE FROM public.categoria WHERE id_categoria = ?");

            pstmt.setInt(1, id);

            pstmt.executeUpdate();
        } catch (Exception e) {
            throw e;
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
    public void update(Categoria entity) throws Exception {
        Connection c = null;
        PreparedStatement pstmt = null;

        try {
            c = DBUtils.getConnection();
            pstmt = c.prepareStatement("UPDATE categoria SET descripcion = ? "
                    + "WHERE id_categoria = ?");

            pstmt.setString(1, entity.getDescripcion());
            pstmt.setInt(2, entity.getId());
            pstmt.executeUpdate();
        } catch (Exception e) {
            throw e;
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
            pstmt = c.prepareStatement("SELECT * FROM categoria WHERE id_categoria = ?");
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                retValue = new Categoria(rs.getInt("id_categoria"), rs.getString("descripcion"));
            } else {
                retValue = new Categoria(null, "");
            }
        } catch (Exception e) {
            throw e;
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
     * @throws java.lang.Exception
     */
    @Override
    public Collection<Categoria> getAll() throws Exception {
        Collection<Categoria> retValue = new ArrayList();
        Connection c = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            c = DBUtils.getConnection();
            pstmt = c.prepareStatement("SELECT * FROM categoria");
            rs = pstmt.executeQuery();
            while (rs.next()) {
                retValue.add(new Categoria(rs.getInt("id_categoria"), rs.getString("descripcion")));
            }
        } catch (Exception e) {
            throw e;
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
                throw ex;
            }
        }
        return retValue;
    }

    /**
     *
     * @param descripcion
     * @return
     * @throws Exception
     */
    @Override
    public Collection<Categoria> findByDescripcion(String descripcion) 
            throws Exception { Collection<Categoria> retValue = new ArrayList();
        
            Connection c = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            c = DBUtils.getConnection();
            pstmt = c.prepareStatement("SELECT * FROM categoria WHERE descripcion = ? ");
            pstmt.setString(1, descripcion);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                retValue.add(new Categoria(rs.getInt("id_categoria"), rs.getString("descripcion")));
            }
        } catch (Exception e) {
            throw e;
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
    public boolean containsDescripcion(String descripcion) {
        try {
            return this.findByDescripcion(descripcion).size() > 0;
        } catch (Exception ex) {
            //Exception Handler
        }
        return false;
    }

}
