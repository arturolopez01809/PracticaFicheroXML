/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfazad;

import controlador.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

/**
 *
 * @author artur
 */
public class Vista {
    
    public static void main(String[] args) throws IOException, FileNotFoundException, ClassNotFoundException, ParserConfigurationException, SAXException{
        ApartadoGrafico apartado_grafico = new ApartadoGrafico();
        
        apartado_grafico.setVisible(true);
    }
    
    
    
    
}
