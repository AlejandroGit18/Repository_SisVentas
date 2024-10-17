package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.Conexion;

public class Usuario {
    private String nombreUsuario;
    private String contrasena;

    public Usuario() {
    }
   
    public Usuario(String nombreUsuario, String contrasena) {
        this.nombreUsuario = nombreUsuario;
        this.contrasena = contrasena;
    }
    
    // Getters y Setters
    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
    
    public String[] Login ()
    {
        Conexion conexionDB = new Conexion();
        conexionDB.abrir_conexion();  // Abre la conexión
        Connection conn = conexionDB.conexionBD;  // Obtiene la conexión
        String[] respuesta = new String[2];

        try {
     
            // Consulta que obtiene el ID del usuario y el rol (puesto) correspondiente
            String sql = "SELECT u.ID_USUARIO, cup.ID_PUESTO AS ROL " +
                         "FROM TBL_USUARIOS u " +
                         "JOIN TBL_CONTROL_USUARIOS_PUESTOS cup ON u.ID_USUARIO = cup.ID_USUARIO " +
                         "JOIN TBL_PUESTOS p ON cup.ID_PUESTO = p.ID_PUESTO " +
                         "WHERE u.USERNAME = ? AND u._PASSWORD = ? AND u.ESTADO = 1 AND p.ESTADO = 1 AND cup.ESTADO = 1";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, getNombreUsuario());
            ps.setString(2, getContrasena());
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                // Login exitoso
                int userId = rs.getInt("ID_USUARIO");
                String userRole = rs.getString("ROL");

                respuesta[0] = Integer.toString(userId);
                respuesta[1] = userRole;
                
            } 
            else
            {
                respuesta[0] = null;
                respuesta[1] = null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        
        return respuesta;
    }

}
