/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import javax.xml.parsers.ParserConfigurationException;
import modelo.Asignaturas;
import org.xml.sax.SAXException;

/**
 *
 * @author artur
 */
public class ControladorAsignaturas implements Serializable{
    
    private ArrayList<Asignaturas> array_asignatuas;

    public ControladorAsignaturas() {
        array_asignatuas = new ArrayList();
    }

    public ArrayList<Asignaturas> getArray_asignatuas() {
        return array_asignatuas;
    }
    
    public Asignaturas getAsignaturaArrayAsignaturas(int i){
        return this.array_asignatuas.get(i);
    }
    
    public void CaptarAsignaturasFichero() throws IOException, ParserConfigurationException, SAXException{
        Asignaturas asignatura = new Asignaturas();
        this.array_asignatuas = asignatura.LeerAsignaturasFichero();
    }
    
    public void GuardarAsignaturasFichero() throws IOException{
        Asignaturas asignaturas = new Asignaturas();
        asignaturas.GuardarAsignaturasFichero(this.array_asignatuas);      
    }
    
    public String[][] introducirAsignaturasEnMatriz(){
        
        String contenido_tabla[][] = new String[this.getArray_asignatuas().size()][2];
        
        for (int i = 0; i < this.getArray_asignatuas().size(); i++) {

            contenido_tabla[i][0] = String.valueOf(this.getAsignaturaArrayAsignaturas(i).getCod_asig());
            contenido_tabla[i][1] = String.valueOf(this.getAsignaturaArrayAsignaturas(i).getConvocatoria());
        }
        
        return contenido_tabla;
    }
    
    public void insertarAsignatura(Asignaturas colegio){
        
        array_asignatuas.add(colegio);
        
    }
    
    
}
