/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universidadulpgrupo50;

import java.time.LocalDate;
import universidadulpgrupo50.AccesoADatos.AlumnoData;
import universidadulpgrupo50.AccesoADatos.MateriaData;
import universidadulpgrupo50.Entidades.Alumno;
import universidadulpgrupo50.Entidades.Materia;

/**
 *
 * @author Carina
 */
public class UniversidadulpGrupo50 {

   
    
    public static void main(String[] args) {
       Alumno juan = new Alumno(22360987,"Perez","Juan Pablo",LocalDate.of(1991,4,21),true);
       AlumnoData alum= new AlumnoData();
      //alum.guardarAlumno(juan);
     // Alumno alumnoEncontrado= alum.buscarAlumno(1);
      //  System.out.println("dni"+alumnoEncontrado.getDni());
      Materia m=new Materia("matematicas",2,true);
      MateriaData mat=new MateriaData();
      mat.guardarMateria(m);
      
    }
    
}
