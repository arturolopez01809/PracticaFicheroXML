/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import static modelo.Colegio.CrearElemento;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

/**
 *
 * @author artur
 */
public class Asignaturas implements Serializable{
    
    private ArrayList<Asignaturas> array_asignaturas;
    
    private int cod_asig;
    private String tipo;
    private int curso;
    private String nombre;
    private int convocatoria;
    private int cod_prof;

    public Asignaturas() {
        array_asignaturas = new ArrayList<>();
        this.cod_prof = 0;
    }

    public ArrayList LeerAsignaturasFichero() throws IOException, ParserConfigurationException, SAXException {

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        
        Document documento = builder.parse("Asignaturas.xml");
       
        documento.getDocumentElement().normalize();
        
        NodeList listaColegios = documento.getElementsByTagName("asignatura");
        
        for(int i = 0; i < listaColegios.getLength(); i++){
            Node nodo = listaColegios.item(i);
            
            if(nodo.getNodeType() == Node.ELEMENT_NODE){
                Element e  = (Element) nodo;
                
                String cod = e.getElementsByTagName("cod_asig").item(0).getTextContent();
                int cod_asig = Integer.valueOf(cod);
                
                String tipo = e.getElementsByTagName("tipo").item(0).getTextContent().toString();
                
                String curs = e.getElementsByTagName("curso").item(0).getTextContent().toString();
                int curso = Integer.valueOf(curs);
                
                String nombre = e.getElementsByTagName("nombre").item(0).getTextContent().toString();
                
                
                String fp = e.getElementsByTagName("convocatoria").item(0).getTextContent().toString();
                int convocatoria = Integer.valueOf(fp);
                
                String cod_p = e.getElementsByTagName("Cod_prof").item(0).getTextContent().toString();
                int cod_prof = Integer.valueOf(fp);
                
                Asignaturas asignatura = new Asignaturas(cod_asig, tipo, curso, nombre, convocatoria, cod_prof);
                
                this.array_asignaturas.add(asignatura);
            }
        }
        
        return this.array_asignaturas;

    }
    
    public void GuardarAsignaturasFichero(ArrayList<Asignaturas> array_asignaturas) throws IOException{
        
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            DOMImplementation implementation = builder.getDOMImplementation();
            Document document = implementation.createDocument(null, "Asignaturas", null);
            document.setXmlVersion("1.0");

            for (int i = 0; i <= array_asignaturas.size(); i++) {
                Element raiz = document.createElement("asignatura"); //nodo empleado
                document.getDocumentElement().appendChild(raiz);

                                     
                CrearElemento("cod_asig", Integer.toString(array_asignaturas.get(i).getCod_asig()), raiz, document);
                
                CrearElemento("tipo", array_asignaturas.get(i).getTipo(), raiz, document);
                
                CrearElemento("curso", Integer.toString(array_asignaturas.get(i).getCurso()), raiz, document);
                
                CrearElemento("nombre", array_asignaturas.get(i).getNombre(), raiz, document);
                
                CrearElemento("convocatoria", Integer.toString(array_asignaturas.get(i).getConvocatoria()), raiz, document);
                
                CrearElemento("Cod_prof", Integer.toString(array_asignaturas.get(i).getCod_prof()), raiz, document);

                Source source = new DOMSource(document);
                Result result = new StreamResult(new java.io.File("Asignaturas.xml"));
                Transformer transformer = TransformerFactory.newInstance().newTransformer();
                //transforma el don en un fichero xml
                transformer.transform(source, result);

                XMLReader procesadorXML = XMLReaderFactory.createXMLReader();
                Colegio.GestionContenido gestor = new Colegio.GestionContenido();
                procesadorXML.setContentHandler(gestor);
                InputSource fileXML = new InputSource("asignaturas.xml");
                procesadorXML.parse(fileXML);
            }

        } catch (Exception e) {

            System.err.println("Error: " + e);
        }
    }
    
    public Asignaturas(int cod_asig, String tipo, int curso, String nombre, int convocatoria, int cod_prof) {
        this.cod_asig = cod_asig;
        this.tipo = tipo;
        this.curso = curso;
        this.nombre = nombre;
        this.convocatoria = convocatoria;
        this.cod_prof = cod_prof;
    }

    
    
    public void setCod_asig(int cod_asig) {
        this.cod_asig = cod_asig;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setCurso(int curso) {
        this.curso = curso;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setConvocatoria(int convocatoria) {
        this.convocatoria = convocatoria;
    }

    public int getCod_asig() {
        return cod_asig;
    }

    public String getTipo() {
        return tipo;
    }

    public int getCurso() {
        return curso;
    }

    public String getNombre() {
        return nombre;
    }

    public int getConvocatoria() {
        return convocatoria;
    }

    public void setCod_prof(int cod_prof) {
        this.cod_prof = cod_prof;
    }

    public int getCod_prof() {
        return cod_prof;
    }
    
    
}
