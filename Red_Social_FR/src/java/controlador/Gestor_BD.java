package controlador;

import DTO.DTOArticulo;
import DTO.DTOComentario_Comercio;
import DTO.DTOConsulta_Oferta;
import DTO.DTOReportes;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Comercio;
import modelo.Oferta;
import modelo.Rubro;

/**
 *
 * @author fabian
 */
public class Gestor_BD {

    private String CadenaBD = "jdbc:sqlserver://DESKTOP-LG0JF6C:1433;databaseName=RED_SOCIAL_FR";
    private String User = "sa";
    private String Pass = "prueba123";
    private Connection conexion;

    public Gestor_BD() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Gestor_BD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void abrirConexion() {
        try {

            conexion = DriverManager.getConnection(CadenaBD, User, Pass);
        } catch (SQLException ex) {
            Logger.getLogger(Gestor_BD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void cerrarConexion() {
        try {
            if (conexion != null && conexion.isClosed()) {
                conexion.close();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void agregarRubro(Rubro rubro) {
        try {
            abrirConexion();
            PreparedStatement ps = conexion.prepareStatement("INSERT INTO rubros (descripcion_rubro, vigente_rubro) VALUES (?, ?)");
            ps.setString(1, rubro.getDescripcion_rubro());
            ps.setBoolean(2, rubro.isVigente_rubro());
            ps.executeUpdate();

        } catch (Exception exc) {
            exc.printStackTrace();
        } finally {
            cerrarConexion();
        }
    }

    public ArrayList<Rubro> getObtenerRubros() {

        ArrayList<Rubro> lista = new ArrayList<>();

        try {
            abrirConexion();
            Statement st = conexion.createStatement();
            ResultSet resultado = st.executeQuery("SELECT * FROM rubros");
            while (resultado.next()) {

                int id_rubro = resultado.getInt("id_rubro");
                String descripcion_rubro = resultado.getString("descripcion_rubro");
                boolean vigente_rubro = resultado.getBoolean("vigente_rubro");

                Rubro rubros = new Rubro(id_rubro, descripcion_rubro, vigente_rubro);
                lista.add(rubros);
            }
            st.close();

            cerrarConexion();

        } catch (SQLException ex) {
            Logger.getLogger(Gestor_BD.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lista;
    }

    public Rubro getObtenerRubroPorId(int id) {
        Rubro r = null;
        try {
            abrirConexion();
            PreparedStatement st = conexion.prepareStatement("SELECT * FROM rubros WHERE id_rubro = ?");
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                int id_rubro = rs.getInt("id_rubro");
                String descripcion_rubro = rs.getString("descripcion_rubro");
                boolean vigente_rubro = rs.getBoolean("vigente_rubro");

                r = new Rubro(descripcion_rubro, vigente_rubro);
                r.setId_rubro(id_rubro);
            }
            rs.close();
        } catch (Exception exc) {
            exc.printStackTrace();
        } finally {
            cerrarConexion();
        }

        return r;
    }

    public void modificarRubro(Rubro rubro) {
        try {
            abrirConexion();
            PreparedStatement ps = conexion.prepareStatement("UPDATE rubros SET descripcion_rubro = ? where id_rubro = ?");

            ps.setString(1, rubro.getDescripcion_rubro());
            ps.setInt(2, rubro.getId_rubro());
            ps.executeUpdate();

        } catch (Exception exc) {
            exc.printStackTrace();
        } finally {
            cerrarConexion();
        }
    }

    public void eliminarRubro(int id) {
        try {
            Rubro rubro = getObtenerRubroPorId(id);
            abrirConexion();
            if (rubro.isVigente_rubro()) {
                PreparedStatement ps = conexion.prepareStatement("UPDATE rubros SET vigente_rubro = 0 WHERE id_rubro = ?");
                ps.setInt(1, id);
                ps.executeUpdate();

            } else {
                PreparedStatement ps = conexion.prepareStatement("UPDATE rubros SET vigente_rubro = 1 WHERE id_rubro = ?");
                ps.setInt(1, id);
                ps.executeUpdate();
            }

        } catch (Exception exc) {
            exc.printStackTrace();
        } finally {
            cerrarConexion();
        }
    }

    public void agregarComercio(Comercio comercio) {
        try {
            abrirConexion();
            PreparedStatement ps = conexion.prepareStatement("INSERT INTO comercios (nombre_comercio, telefono_comercio,direccion_comercio,email_comercio,id_rubro,vigente_comercio) VALUES (?,?,?,?,?,?)");
            ps.setString(1, comercio.getNombre_comercio());
            ps.setString(2, comercio.getTelefono_comercio());
            ps.setString(3, comercio.getDireccion_comercio());
            ps.setString(4, comercio.getEmail_comercio());
            ps.setInt(5, comercio.getRubro().getId_rubro());
            ps.setBoolean(6, comercio.isVigente_comercio());
            ps.executeUpdate();

        } catch (Exception exc) {
            exc.printStackTrace();
        } finally {
            cerrarConexion();
        }
    }

    public ArrayList<Comercio> getObtenerComercios() {

        ArrayList<Comercio> lista = new ArrayList<>();

        try {
            abrirConexion();
            Statement st = conexion.createStatement();
            ResultSet resultado = st.executeQuery("select c.id_comercio,c.nombre_comercio,c.telefono_comercio,c.direccion_comercio,c.email_comercio,r.descripcion_rubro,c.vigente_comercio\n"
                    + "from comercios c, rubros r\n"
                    + "where c.id_rubro = r.id_rubro;");
            while (resultado.next()) {

                int id_comercio = resultado.getInt("id_comercio");
                String nombre_comercio = resultado.getString("nombre_comercio");
                String telefono_comercio = resultado.getString("telefono_comercio");
                String direccion_comercio = resultado.getString("direccion_comercio");
                String email_comercio = resultado.getString("email_comercio");
                String descripcion_rubro = resultado.getString("descripcion_rubro");
                boolean vigente_comercio = resultado.getBoolean("vigente_comercio");

                Rubro rubro = new Rubro();
                rubro.setDescripcion_rubro(descripcion_rubro);

                Comercio comercio = new Comercio(id_comercio, nombre_comercio, telefono_comercio, direccion_comercio, email_comercio, rubro, vigente_comercio);
                lista.add(comercio);
            }
            st.close();

            cerrarConexion();

        } catch (SQLException ex) {
            Logger.getLogger(Gestor_BD.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lista;
    }

    public void modificarComercio(Comercio comercio) {
        try {
            abrirConexion();
            PreparedStatement ps = conexion.prepareStatement("UPDATE comercios SET nombre_comercio = ?, telefono_comercio = ?, direccion_comercio = ?, email_comercio = ?, id_rubro = ? where id_comercio = ?");

            ps.setString(1, comercio.getNombre_comercio());
            ps.setString(2, comercio.getTelefono_comercio());
            ps.setString(3, comercio.getDireccion_comercio());
            ps.setString(4, comercio.getEmail_comercio());
            ps.setInt(5, comercio.getRubro().getId_rubro());
            ps.setInt(6, comercio.getId_comercio());
            ps.executeUpdate();

        } catch (Exception exc) {
            exc.printStackTrace();
        } finally {
            cerrarConexion();
        }
    }

    public Comercio getObtenerComercioPorId(int id) {
        Comercio c = null;
        try {
            abrirConexion();
            PreparedStatement st = conexion.prepareStatement("SELECT * FROM comercios WHERE id_comercio = ?");
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                int id_comercio = rs.getInt("id_comercio");
                String nombre_comercio = rs.getString("nombre_comercio");
                String telefono_comercio = rs.getString("telefono_comercio");
                String direccion_comercio = rs.getString("direccion_comercio");
                String email_comercio = rs.getString("email_comercio");
                int id_rubro = rs.getInt("id_rubro");
                boolean vigente_comercio = rs.getBoolean("vigente_comercio");

                Rubro rubro = new Rubro();
                rubro.setId_rubro(id_rubro);

                c = new Comercio(nombre_comercio, telefono_comercio, direccion_comercio, email_comercio, rubro, vigente_comercio);
                c.setId_comercio(id_comercio);
            }
            rs.close();
        } catch (Exception exc) {
            exc.printStackTrace();
        } finally {
            cerrarConexion();
        }

        return c;
    }

    public void eliminarComercio(int id) {
        try {
            Comercio comercio = getObtenerComercioPorId(id);
            abrirConexion();
            if (comercio.isVigente_comercio()) {
                PreparedStatement ps = conexion.prepareStatement("UPDATE comercios SET vigente_comercio = 0 WHERE id_comercio = ?");
                ps.setInt(1, id);
                ps.executeUpdate();
            } else {
                PreparedStatement ps = conexion.prepareStatement("UPDATE comercios SET vigente_comercio = 1 WHERE id_comercio = ?");
                ps.setInt(1, id);
                ps.executeUpdate();
            }

        } catch (Exception exc) {
            exc.printStackTrace();
        } finally {
            cerrarConexion();
        }
    }

    public void agregarOferta(Oferta oferta) {
        try {
            abrirConexion();
            PreparedStatement ps = conexion.prepareStatement("INSERT INTO ofertas (id_comercio, codigo_articulo,fecha_inicio_oferta,fecha_finalizacion_oferta,descripcion_oferta,precio_oferta,vigente_oferta) VALUES (?,?,?,?,?,?,?)");
            ps.setInt(1, oferta.getComercio().getId_comercio());
            ps.setInt(2, oferta.getArticulo().getCodigo_articulo());
            ps.setString(3, oferta.getFecha_inicio_oferta());
            ps.setString(4, oferta.getFecha_finalizacion_oferta());
            ps.setString(5, oferta.getDescripcion_oferta());
            ps.setDouble(6, oferta.getPrecio_oferta());
            ps.setBoolean(7, oferta.isVigente_oferta());
            ps.executeUpdate();

        } catch (Exception exc) {
            exc.printStackTrace();
        } finally {
            cerrarConexion();
        }
    }

    public ArrayList<Oferta> getObtenerOfertas() {

        ArrayList<Oferta> lista = new ArrayList<>();

        try {
            abrirConexion();
            Statement st = conexion.createStatement();
            ResultSet resultado = st.executeQuery("select o.id_oferta,a.nombre_articulo,c.nombre_comercio,o.fecha_inicio_oferta,o.fecha_finalizacion_oferta,o.descripcion_oferta,o.precio_oferta,o.vigente_oferta\n"
                    + "from OFERTAS o, ARTICULOS a , COMERCIOS c\n"
                    + "where o.codigo_articulo = a.codigo_articulo\n"
                    + "and o.id_comercio = c.id_comercio");

            while (resultado.next()) {
                int id_oferta = resultado.getInt("id_oferta");
                String nombre_articulo = resultado.getString("nombre_articulo");
                String nombre_comercio = resultado.getString("nombre_comercio");
                String fecha_inicio_oferta = resultado.getString("fecha_inicio_oferta");
                String fecha_finalizacion_oferta = resultado.getString("fecha_finalizacion_oferta");
                String descripcion_oferta = resultado.getString("descripcion_oferta");
                float precio_oferta = resultado.getFloat("precio_oferta");
                boolean vigente_oferta = resultado.getBoolean("vigente_oferta");

                DTOArticulo articulo = new DTOArticulo();
                articulo.setNombre_articulo(nombre_articulo);

                Comercio comercio = new Comercio();
                comercio.setNombre_comercio(nombre_comercio);

                Oferta oferta = new Oferta(id_oferta, comercio, articulo, fecha_inicio_oferta, fecha_finalizacion_oferta, descripcion_oferta, precio_oferta, vigente_oferta);
                lista.add(oferta);
            }
            st.close();

            cerrarConexion();

        } catch (SQLException ex) {
            Logger.getLogger(Gestor_BD.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

        return lista;
    }

    public void modificarOferta(Oferta oferta) {
        try {
            abrirConexion();
            PreparedStatement ps = conexion.prepareStatement("UPDATE ofertas SET id_comercio = ?, codigo_articulo = ?, fecha_inicio_oferta = ?, fecha_finalizacion_oferta = ?, descripcion_oferta = ?, precio_oferta = ? where id_oferta = ?");

            ps.setInt(1, oferta.getComercio().getId_comercio());
            ps.setInt(2, oferta.getArticulo().getCodigo_articulo());
            ps.setString(3, oferta.getFecha_inicio_oferta());
            ps.setString(4, oferta.getFecha_finalizacion_oferta());
            ps.setString(5, oferta.getDescripcion_oferta());
            ps.setDouble(6, oferta.getPrecio_oferta());
            ps.setInt(7, oferta.getId_oferta());
            ps.executeUpdate();

        } catch (Exception exc) {
            exc.printStackTrace();
        } finally {
            cerrarConexion();
        }
    }

    public Oferta getObtenerOfertaPorId(int id) {
        Oferta o = null;
        try {
            abrirConexion();
            PreparedStatement st = conexion.prepareStatement("SELECT * FROM ofertas WHERE id_oferta = ?");
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                int id_oferta = rs.getInt("id_oferta");
                int id_comercio = rs.getInt("id_comercio");
                int codigo_articulo = rs.getInt("codigo_articulo");
                String fecha_inicio_oferta = rs.getString("fecha_inicio_oferta");
                String fecha_finalizacion_oferta = rs.getString("fecha_finalizacion_oferta");
                String descripcion_oferta = rs.getString("descripcion_oferta");
                float precio_oferta = rs.getFloat("precio_oferta");
                boolean vigente_oferta = rs.getBoolean("vigente_oferta");

                DTOArticulo articulo = new DTOArticulo();
                articulo.setCodigo_articulo(codigo_articulo);

                Comercio comercio = new Comercio();
                comercio.setId_comercio(id_comercio);

                o = new Oferta(comercio, articulo, fecha_inicio_oferta, fecha_finalizacion_oferta, descripcion_oferta, precio_oferta, vigente_oferta);
                o.setId_oferta(id_oferta);
            }
            rs.close();
        } catch (Exception exc) {
            exc.printStackTrace();
        } finally {
            cerrarConexion();
        }

        return o;
    }

    public ArrayList<Oferta> getObtenerLista_OfertasPorId(int id) {
        ArrayList<Oferta> lista = new ArrayList<>();
        try {
            abrirConexion();
            PreparedStatement st = conexion.prepareStatement("SELECT o.id_oferta,o.id_comercio,a.nombre_articulo,o.fecha_inicio_oferta,o.fecha_finalizacion_oferta,o.descripcion_oferta,o.precio_oferta  \n"
                    + "FROM ofertas o, articulos a WHERE o.codigo_articulo = a.codigo_articulo \n"
                    + "and o.id_comercio = ? and o.vigente_oferta = 1;");
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                int id_oferta = rs.getInt("id_oferta");
                String nombre_articulo = rs.getString("nombre_articulo");
                int id_comercio = rs.getInt("id_comercio");
                String fecha_inicio_oferta = rs.getString("fecha_inicio_oferta");
                String fecha_finalizacion_oferta = rs.getString("fecha_finalizacion_oferta");
                String descripcion_oferta = rs.getString("descripcion_oferta");
                float precio_oferta = rs.getFloat("precio_oferta");

                DTOArticulo articulo = new DTOArticulo();
                articulo.setNombre_articulo(nombre_articulo);

                Comercio comercio = new Comercio();
                comercio.setId_comercio(id_comercio);

                Oferta oferta = new Oferta(id_oferta, comercio, articulo, fecha_inicio_oferta, fecha_finalizacion_oferta, descripcion_oferta, precio_oferta);
                lista.add(oferta);

            }
            rs.close();
        } catch (Exception exc) {
            exc.printStackTrace();
        } finally {
            cerrarConexion();
        }

        return lista;
    }

    public Oferta getObtenerOfertaComercioPorId(int id) {
        Oferta o = null;
        try {
            abrirConexion();
            PreparedStatement st = conexion.prepareStatement("SELECT * FROM ofertas WHERE id_comercio = ?");
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                int id_oferta = rs.getInt("id_oferta");
                int id_comercio = rs.getInt("id_comercio");
                int codigo_articulo = rs.getInt("codigo_articulo");
                String fecha_inicio_oferta = rs.getString("fecha_inicio_oferta");
                String fecha_finalizacion_oferta = rs.getString("fecha_finalizacion_oferta");
                String descripcion_oferta = rs.getString("descripcion_oferta");
                float precio_oferta = rs.getFloat("precio_oferta");
                boolean vigente_oferta = rs.getBoolean("vigente_oferta");

                DTOArticulo articulo = new DTOArticulo();
                articulo.setCodigo_articulo(codigo_articulo);

                Comercio comercio = new Comercio();
                comercio.setId_comercio(id_comercio);

                o = new Oferta(comercio, articulo, fecha_inicio_oferta, fecha_finalizacion_oferta, descripcion_oferta, precio_oferta, vigente_oferta);
                o.setId_oferta(id_oferta);
            }
            rs.close();
        } catch (Exception exc) {
            exc.printStackTrace();
        } finally {
            cerrarConexion();
        }

        return o;
    }

    public void eliminarOferta(int id) {
        try {
            Oferta oferta = getObtenerOfertaPorId(id);
            abrirConexion();
            if (oferta.isVigente_oferta()) {
                PreparedStatement ps = conexion.prepareStatement("UPDATE ofertas SET vigente_oferta = 0 WHERE id_oferta = ?");
                ps.setInt(1, id);
                ps.executeUpdate();

            } else {
                PreparedStatement ps = conexion.prepareStatement("UPDATE ofertas SET vigente_oferta = 1 WHERE id_oferta = ?");
                ps.setInt(1, id);
                ps.executeUpdate();
            }

        } catch (Exception exc) {
            exc.printStackTrace();
        } finally {
            cerrarConexion();
        }
    }

    public ArrayList<DTOArticulo> getObtenerArticulos() {

        ArrayList<DTOArticulo> lista = new ArrayList<>();

        try {
            abrirConexion();
            Statement st = conexion.createStatement();
            ResultSet resultado = st.executeQuery("SELECT * FROM articulos");
            while (resultado.next()) {

                int codigo_articulo = resultado.getInt("codigo_articulo");
                String nombre_articulo = resultado.getString("nombre_articulo");
                double precio_articulo = resultado.getDouble("precio_articulo");
                int stock_articulo = resultado.getInt("stock_articulo");

                DTOArticulo articulo = new DTOArticulo(codigo_articulo, nombre_articulo, precio_articulo, stock_articulo);
                lista.add(articulo);
            }
            st.close();

            cerrarConexion();

        } catch (SQLException ex) {
            Logger.getLogger(Gestor_BD.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

        return lista;
    }

    public void agregarConsulta(DTOConsulta_Oferta consulta) {
        try {
            abrirConexion();
            PreparedStatement ps = conexion.prepareStatement("INSERT INTO consultas_ofertas (id_oferta,vecino_comentario,descripcion_consulta_oferta,aprobada_consulta_oferta) VALUES (?,?,?,?)");
            ps.setInt(1, consulta.getOferta().getId_oferta());
            ps.setString(2, consulta.getVecino_comentario());
            ps.setString(3, consulta.getDescripcion_consulta_oferta());
            ps.setBoolean(4, consulta.isAprobada_consulta_oferta());
            ps.executeUpdate();

        } catch (Exception exc) {
            exc.printStackTrace();
        } finally {
            cerrarConexion();
        }
    }

    public ArrayList<DTOConsulta_Oferta> getObtenerConsulta_Ofertas() {

        ArrayList<DTOConsulta_Oferta> lista = new ArrayList<>();

        try {
            abrirConexion();
            Statement st = conexion.createStatement();
            ResultSet resultado = st.executeQuery("select o.descripcion_oferta,co.id_consulta_oferta,co.vecino_comentario,co.descripcion_consulta_oferta,co.aprobada_consulta_oferta, co.respuesta_consulta_vecino \n"
                    + "from CONSULTAS_OFERTAS CO, OFERTAS O\n"
                    + "WHERE CO.id_oferta = O.id_oferta;");
            while (resultado.next()) {

                String descripcion_oferta = resultado.getString("descripcion_oferta");
                int id_consulta_oferta = resultado.getInt("id_consulta_oferta");
                String descripcion_consulta_oferta = resultado.getString("descripcion_consulta_oferta");
                String vecino_comentario = resultado.getString("vecino_comentario");
                boolean aprobada_consulta_oferta = resultado.getBoolean("aprobada_consulta_oferta");
                String respuesta_consulta_vecino = resultado.getString("respuesta_consulta_vecino");

                Oferta oferta = new Oferta();
                oferta.setDescripcion_oferta(descripcion_oferta);

                DTOConsulta_Oferta consulta = new DTOConsulta_Oferta(oferta, id_consulta_oferta, vecino_comentario, descripcion_consulta_oferta, aprobada_consulta_oferta, respuesta_consulta_vecino);
                lista.add(consulta);
            }
            st.close();

            cerrarConexion();

        } catch (SQLException ex) {
            Logger.getLogger(Gestor_BD.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

        return lista;
    }

    public ArrayList<DTOConsulta_Oferta> getObtenerConsulta_OfertasPorComercio(int id_comercio) {

        ArrayList<DTOConsulta_Oferta> lista = new ArrayList<>();

        try {
            abrirConexion();
            PreparedStatement st = conexion.prepareStatement("select o.descripcion_oferta,co.id_consulta_oferta,co.vecino_comentario,co.descripcion_consulta_oferta,co.aprobada_consulta_oferta, co.respuesta_consulta_vecino\n"
                    + "from CONSULTAS_OFERTAS CO, OFERTAS O\n"
                    + "WHERE CO.id_oferta = O.id_oferta\n"
                    + "and co.aprobada_consulta_oferta = 1\n"
                    + "and o.id_comercio = ? ");
            st.setInt(1, id_comercio);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {

                String descripcion_oferta = rs.getString("descripcion_oferta");
                int id_consulta_oferta = rs.getInt("id_consulta_oferta");
                String descripcion_consulta_oferta = rs.getString("descripcion_consulta_oferta");
                String vecino_comentario = rs.getString("vecino_comentario");
                boolean aprobada_consulta_oferta = rs.getBoolean("aprobada_consulta_oferta");
                String respuesta_consulta_vecino = rs.getString("respuesta_consulta_vecino");

                Oferta oferta = new Oferta();
                oferta.setDescripcion_oferta(descripcion_oferta);

                DTOConsulta_Oferta consulta = new DTOConsulta_Oferta(oferta, id_consulta_oferta, vecino_comentario, descripcion_consulta_oferta, aprobada_consulta_oferta, respuesta_consulta_vecino);
                lista.add(consulta);
            }
            st.close();

            cerrarConexion();

        } catch (SQLException ex) {
            Logger.getLogger(Gestor_BD.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

        return lista;
    }

    public DTOConsulta_Oferta getObtenerConsulta_OfertasPorId(int id) {
        DTOConsulta_Oferta d = null;
        try {
            abrirConexion();
            PreparedStatement st = conexion.prepareStatement("SELECT * FROM Consultas_Ofertas WHERE id_consulta_oferta = ?");
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                int id_oferta = rs.getInt("id_oferta");

                int id_consulta_oferta = rs.getInt("id_consulta_oferta");
                String descripcion_consulta_oferta = rs.getString("descripcion_consulta_oferta");
                boolean aprobada_consulta_oferta = rs.getBoolean("aprobada_consulta_oferta");

                Oferta oferta = new Oferta();
                oferta.setId_oferta(id_oferta);

                d = new DTOConsulta_Oferta(oferta, descripcion_consulta_oferta, aprobada_consulta_oferta);
                d.setId_consulta_oferta(id_consulta_oferta);
            }
            rs.close();
        } catch (Exception exc) {
            exc.printStackTrace();
        } finally {
            cerrarConexion();
        }

        return d;
    }

    public ArrayList<Oferta> getObtenerOfertasPorString(String palabra) {
        ArrayList<Oferta> lista = new ArrayList<>();
        try {
            abrirConexion();
            PreparedStatement st = conexion.prepareStatement("select o.id_oferta,a.nombre_articulo,c.nombre_comercio,o.fecha_inicio_oferta,o.fecha_finalizacion_oferta,o.descripcion_oferta,o.precio_oferta\n"
                    + "	from OFERTAS o, ARTICULOS a , COMERCIOS c\n"
                    + "	where o.codigo_articulo = a.codigo_articulo\n"
                    + "	and o.id_comercio = c.id_comercio\n"
                    + "	and o.vigente_oferta = 1\n"
                    + "	and o.descripcion_oferta LIKE CONCAT('%', ? ,'%')");
            st.setString(1, palabra);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                int id_oferta = rs.getInt("id_oferta");
                String nombre_articulo = rs.getString("nombre_articulo");
                String nombre_comercio = rs.getString("nombre_comercio");
                String fecha_inicio_oferta = rs.getString("fecha_inicio_oferta");
                String fecha_finalizacion_oferta = rs.getString("fecha_finalizacion_oferta");
                String descripcion_oferta = rs.getString("descripcion_oferta");
                float precio_oferta = rs.getFloat("precio_oferta");

                DTOArticulo articulo = new DTOArticulo();
                articulo.setNombre_articulo(nombre_articulo);

                Comercio comercio = new Comercio();
                comercio.setNombre_comercio(nombre_comercio);

                Oferta oferta = new Oferta(id_oferta, comercio, articulo, fecha_inicio_oferta, fecha_finalizacion_oferta, descripcion_oferta, precio_oferta);
                lista.add(oferta);

            }
            rs.close();
        } catch (Exception exc) {
            exc.printStackTrace();
        } finally {
            cerrarConexion();
        }

        return lista;
    }

    public void moderarConsulta(int id) {
        try {
            DTOConsulta_Oferta consulta = getObtenerConsulta_OfertasPorId(id);
            abrirConexion();
            if (consulta.isAprobada_consulta_oferta() == true) {
                PreparedStatement ps = conexion.prepareStatement("UPDATE consultas_ofertas SET aprobada_consulta_oferta = 0 WHERE id_consulta_oferta = ?");
                ps.setInt(1, id);
                ps.executeUpdate();

            } else {
                PreparedStatement ps = conexion.prepareStatement("UPDATE consultas_ofertas SET aprobada_consulta_oferta = 1 WHERE id_consulta_oferta = ?");
                ps.setInt(1, id);
                ps.executeUpdate();
            }

        } catch (Exception exc) {
            exc.printStackTrace();
        } finally {
            cerrarConexion();
        }
    }

    public void agregarComentario(DTOComentario_Comercio comentario) {
        try {
            abrirConexion();
            PreparedStatement ps = conexion.prepareStatement("INSERT INTO COMENTARIOS_COMERCIOS (id_comercio, vecino_comentario,descripcion_comentario,valoracion_comercio_comentario) VALUES (?,?,?,?)");
            ps.setInt(1, comentario.getComercio().getId_comercio());
            ps.setString(2, comentario.getVecino_comentario());
            ps.setString(3, comentario.getDescripcion_comentario());
            ps.setInt(4, comentario.getValoracion_comercio_comentario());
            ps.executeUpdate();

        } catch (Exception exc) {
            exc.printStackTrace();
        } finally {
            cerrarConexion();
        }
    }

    public void modificarComentario(DTOComentario_Comercio comentario) {
        try {
            abrirConexion();
            PreparedStatement ps = conexion.prepareStatement("UPDATE COMENTARIOS_COMERCIOS SET respuesta_comercio_comentario = ? where id_comentario = ?");
            ps.setString(1, comentario.getRespuesta_comercio_comentario());
            ps.setInt(2, comentario.getId_comentario());
            ps.executeUpdate();

        } catch (Exception exc) {
            exc.printStackTrace();
        } finally {
            cerrarConexion();
        }
    }

    public ArrayList<DTOComentario_Comercio> getObtenerComentarioPorComercio(int id) {
        ArrayList<DTOComentario_Comercio> lista = new ArrayList<>();
        try {
            abrirConexion();
            PreparedStatement st = conexion.prepareStatement("SELECT * FROM COMENTARIOS_COMERCIOS WHERE id_comercio = ?;");
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                int id_comentario = rs.getInt("id_comentario");
                int id_comercio = rs.getInt("id_comercio");
                String vecino_comentario = rs.getString("vecino_comentario");
                String descripcion_comentario = rs.getString("descripcion_comentario");
                int valoracion_comercio_comentario = rs.getInt("valoracion_comercio_comentario");

                Comercio comercio = new Comercio();
                comercio.setId_comercio(id_comercio);

                DTOComentario_Comercio comentario = new DTOComentario_Comercio(id_comentario, comercio, vecino_comentario, descripcion_comentario, valoracion_comercio_comentario);
                lista.add(comentario);

            }
            rs.close();
        } catch (Exception exc) {
            exc.printStackTrace();
        } finally {
            cerrarConexion();
        }

        return lista;
    }

    public ArrayList<DTOComentario_Comercio> getObtenerComentarios_comercios() {

        ArrayList<DTOComentario_Comercio> lista = new ArrayList<>();

        try {
            abrirConexion();
            Statement st = conexion.createStatement();
            ResultSet resultado = st.executeQuery("SELECT * FROM COMENTARIOS_COMERCIOS");
            while (resultado.next()) {
                int id_comentario = resultado.getInt("id_comentario");
                int id_comercio = resultado.getInt("id_comercio");
                String vecino_comentario = resultado.getString("vecino_comentario");
                String descripcion_comentario = resultado.getString("descripcion_comentario");
                int valoracion_comercio_comentario = resultado.getInt("valoracion_comercio_comentario");
                String respuesta_comercio_comentario = resultado.getString("respuesta_comercio_comentario");

                Comercio comercio = new Comercio();
                comercio.setId_comercio(id_comercio);

                DTOComentario_Comercio comentario = new DTOComentario_Comercio(id_comentario, comercio, vecino_comentario, descripcion_comentario, valoracion_comercio_comentario, respuesta_comercio_comentario);
                lista.add(comentario);

            }
            st.close();

            cerrarConexion();

        } catch (SQLException ex) {
            Logger.getLogger(Gestor_BD.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

        return lista;
    }

    public void agregarRespuesta(DTOConsulta_Oferta consulta) {
        try {
            abrirConexion();
            PreparedStatement ps = conexion.prepareStatement("UPDATE CONSULTAS_OFERTAS SET respuesta_consulta_vecino = ? WHERE  id_consulta_oferta = ?");
            ps.setString(1, consulta.getRespuesta_consulta_vecino());
            ps.setInt(2, consulta.getId_consulta_oferta());
            ps.executeUpdate();

        } catch (Exception exc) {
            exc.printStackTrace();
        } finally {
            cerrarConexion();
        }
    }

    //------------------------------REPORTES------------------------------//
    public ArrayList<DTOReportes> getObtenerCantComentariosComercio() {
        ArrayList<DTOReportes> lista = new ArrayList<>();

        try {
            abrirConexion();
            Statement st = conexion.createStatement();
            ResultSet resultado = st.executeQuery("select c.id_comercio, c.nombre_comercio, COUNT(*) cantidad_comentarios\n"
                    + "from COMERCIOS c, COMENTARIOS_COMERCIOS cc\n"
                    + "where c.id_comercio = cc.id_comercio\n"
                    + "group by c.id_comercio, c.nombre_comercio\n"
                    + "order by 3 desc;");

            while (resultado.next()) {

                int id_comercio = resultado.getInt("id_comercio");
                String nombre_comercio = resultado.getString("nombre_comercio");
                int cantidad_comentarios = resultado.getInt("cantidad_comentarios");

                DTOReportes cant_comentarios = new DTOReportes();
                cant_comentarios.setId_comercio(id_comercio);
                cant_comentarios.setNombre_comercio(nombre_comercio);
                cant_comentarios.setCantidad_comentarios(cantidad_comentarios);
                lista.add(cant_comentarios);

            }
            st.close();

            cerrarConexion();
        } catch (SQLException ex) {
            Logger.getLogger(Gestor_BD.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

     public ArrayList<DTOReportes> getObtenerPromedioComercio() {
        ArrayList<DTOReportes> lista = new ArrayList<>();

        try {
            abrirConexion();
            Statement st = conexion.createStatement();
            ResultSet resultado = st.executeQuery("select  c.id_comercio, c.nombre_comercio, avg(cc.valoracion_comercio_comentario) promedio_valoracion\n"
                    + "from COMERCIOS c, COMENTARIOS_COMERCIOS cc\n"
                    + "where c.id_comercio = cc.id_comercio\n"
                    + "group by c.id_comercio, c.nombre_comercio;");

            while (resultado.next()) {

                int id_comercio = resultado.getInt("id_comercio");
                String nombre_comercio = resultado.getString("nombre_comercio");
                int promedio_valoracion = resultado.getInt("promedio_valoracion");

                DTOReportes promedios = new DTOReportes();
                promedios.setId_comercio(id_comercio);
                promedios.setNombre_comercio(nombre_comercio);
                promedios.setPromedio_valoracion(promedio_valoracion);
                lista.add(promedios);

            }
            st.close();

            cerrarConexion();
        } catch (SQLException ex) {
            Logger.getLogger(Gestor_BD.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    public ArrayList<DTOReportes> getObtenerCantValoracionesEstrella() {
        ArrayList<DTOReportes> lista = new ArrayList<>();

        try {
            abrirConexion();
            Statement st = conexion.createStatement();
            ResultSet resultado = st.executeQuery("select cc.valoracion_comercio_comentario, count(*) cantidad_valoraciones\n"
                    + "from COMERCIOS c, COMENTARIOS_COMERCIOS cc\n"
                    + "where c.id_comercio = cc.id_comercio\n"
                    + "group by cc.valoracion_comercio_comentario;");

            while (resultado.next()) {

                int valoracion_comercio_comentario = resultado.getInt("valoracion_comercio_comentario");
                int cantidad_valoraciones = resultado.getInt("cantidad_valoraciones");

                DTOReportes cant_valoraciones = new DTOReportes();
                cant_valoraciones.setValoracion_comercio_comentario(valoracion_comercio_comentario);
                cant_valoraciones.setCantidad_valoraciones(cantidad_valoraciones);
                lista.add(cant_valoraciones);

            }
            st.close();

            cerrarConexion();
        } catch (SQLException ex) {
            Logger.getLogger(Gestor_BD.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    public ArrayList<DTOReportes> getObtenerNoRespondidos() {
        ArrayList<DTOReportes> lista = new ArrayList<>();

        try {
            abrirConexion();
            Statement st = conexion.createStatement();
            ResultSet resultado = st.executeQuery("select o.descripcion_oferta,c.vecino_comentario, c.descripcion_consulta_oferta\n"
                    + "from CONSULTAS_OFERTAS c, OFERTAS o\n"
                    + "where  c.id_oferta = o.id_oferta\n"
                    + "and c.respuesta_consulta_vecino is null;");

            while (resultado.next()) {

               String descripcion_oferta = resultado.getString("descripcion_oferta");
                String vecino_comentario = resultado.getString("vecino_comentario");
                String descripcion_consulta_oferta = resultado.getString("descripcion_consulta_oferta");

                DTOReportes comentarios_norespondidos = new DTOReportes();
                comentarios_norespondidos.setDescripcion_oferta(descripcion_oferta);
                comentarios_norespondidos.setVecino_comentario(vecino_comentario);
                comentarios_norespondidos.setDescripcion_consulta_oferta(descripcion_consulta_oferta);
                lista.add(comentarios_norespondidos);

            }
            st.close();

            cerrarConexion();
        } catch (SQLException ex) {
            Logger.getLogger(Gestor_BD.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
}
