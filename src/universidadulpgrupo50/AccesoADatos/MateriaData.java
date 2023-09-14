
package universidadulpgrupo50.AccesoADatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import universidadulpgrupo50.Entidades.Materia;

public class MateriaData {
    private Connection con=null;

    public MateriaData() {
        con=Conexion.getConexion();
    }
    
    public void guardarMateria(Materia materia){
        
        String sql="INSERT INTO materia(nombre,anio,estado) VALUES(?,?,?)";
        try {
            PreparedStatement ps=con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, materia.getNombre());
            ps.setInt(2, materia.getAnio());
            ps.setBoolean(3, materia.isEstado());
            ps.executeUpdate();
            ResultSet rs=ps.getGeneratedKeys();
            
            if (rs.next()) {
                materia.setIdMateria(rs.getInt("idMateria"));
                
                JOptionPane.showMessageDialog(null,"Materia cargada con Exito");
                
                
            }
            
            ps.close();
            
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null,"Error al acceder a la tabla materia");
        }
}
    public Materia buscarMateria(int id){
        Materia materia=null;
        
        String sql="SELECT nombre,anio,estado FROM materia WHERE idMateria=? AND estado=1";
        PreparedStatement ps=null;
        
        try {
        ps=con.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs=ps.executeQuery();
        
            if (rs.next()) {
                
                materia=new Materia();
                materia.setIdMateria(id);
                materia.setNombre(rs.getString("nombre"));
                materia.setAnio(rs.getInt("anio"));
                materia.setEstado(true);
                
            }else{
                JOptionPane.showMessageDialog(null,"No existe la materia");
                ps.close();
        }

           } catch (SQLException ex) {
               JOptionPane.showMessageDialog(null,"Error al acceder a la tabla materia"+ ex.getMessage());
        }
               
          return materia;
    }
}