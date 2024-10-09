package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    public Connection conexionBD;
    private static final String PUERTO = "3306";
    private static final String BD = "sisventas";
    private static final String URL_CONEXION = String.format("jdbc:mysql://localhost:%s/%s?serverTimezone=UTC", PUERTO, BD);
    private static final String USUARIO = "root";
    private static final String CONTRA = "1234";
    private static final String JDBC = "com.mysql.cj.jdbc.Driver";
    
    // Método para abrir la conexión
    public void abrir_conexion() {
        if (conexionBD != null) {
            System.out.println("La conexión ya está abierta.");
            return;
        }
        try {
            Class.forName(JDBC);  // Carga del driver
            conexionBD = DriverManager.getConnection(URL_CONEXION, USUARIO, CONTRA);
            System.out.println("Conexión abierta exitosamente.");
        } catch (ClassNotFoundException e) {
            System.err.println("Error al cargar el driver: " + e.getMessage());
        } catch (SQLException e) {
            System.err.println("Error al abrir la conexión: " + e.getMessage());
        }
    }
    
    // Método para cerrar la conexión
    public void cerrar_conexion() {
        if (conexionBD != null) {
            try {
                conexionBD.close();
                conexionBD = null;  // Limpiar la referencia a la conexión
                System.out.println("Conexión cerrada exitosamente.");
            } catch (SQLException e) {
                System.err.println("Error al cerrar la conexión: " + e.getMessage());
            }
        } else {
            System.out.println("No hay conexión abierta para cerrar.");
        }
    }   
}
