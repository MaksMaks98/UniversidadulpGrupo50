
package universidadulpgrupo50.AccesoADatos;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class Conexion {
    private static final String URL = "jdbc:mariadb://localhost:3306/";
    private static final String DB = "universidadulpejemp";
    private static final String USUARIO= "root";
    private static final String PASSWORD= "";
    private static Connection connection;

    public Conexion() {
    }

    
    public static Connection getConexion(){

        if (connection==null) {
           
            try {
                Class.forName("org.mariadb.jdbc.Driver");
                connection=DriverManager.getConnection(URL+DB,USUARIO,PASSWORD);
            } catch (ClassNotFoundException ex) {
               JOptionPane.showMessageDialog(null, "Error al cargar los driver"+ex.getMessage());
        }   catch (SQLException ex) {
                 JOptionPane.showMessageDialog(null, "Error al conectarse"+ex.getMessage());
            }
    

    
    }
    return connection;
    }
}
