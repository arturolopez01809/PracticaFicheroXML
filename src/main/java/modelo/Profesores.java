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
public class Profesores implements Serializable {

    private ArrayList<Profesores> array_profesores;
    private int cod_prof;
    private String nombre;
    private String estudios;
    private String rangos;
    private String genero;
    private int Cod_colegio;

    public Profesores() {
        array_profesores = new ArrayList<>();
        this.Cod_colegio = 0;
    }

    public Profesores(int cod_prof, String nombre, String estudios, String rangos, String genero, int Cod_colegio) {
        this.cod_prof = cod_prof;
        this.nombre = nombre;
        this.estudios = estudios;
        this.rangos = rangos;
        this.genero = genero;
        this.Cod_colegio = Cod_colegio;
    }

    public ArrayList LeerProfesoresFichero() throws IOException, ParserConfigurationException, SAXException {

        //if (array_profesores.size() != 0) {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            Document documento = builder.parse("Profesores.xml");

            documento.getDocumentElement().normalize();

            NodeList listaColegios = documento.getElementsByTagName("profesor");

            for (int i = 0; i < listaColegios.getLength(); i++) {
                Node nodo = listaColegios.item(i);

                if (nodo.getNodeType() == Node.ELEMENT_NODE) {
                    Element e = (Element) nodo;

                    String cod = e.getElementsByTagName("cod_prof").item(0).getTextContent();
                    int cod_prof = Integer.valueOf(cod);
                    String nombre = e.getElementsByTagName("nombre").item(0).getTextContent().toString();
                    String estudios = e.getElementsByTagName("estudios").item(0).getTextContent().toString();

                    String rangos = e.getElementsByTagName("rangos").item(0).getTextContent().toString();
                    String genero = e.getElementsByTagName("genero").item(0).getTextContent().toString();
                    //boolean espublico = Boolean.valueOf(publico);
                    String cod_colg = e.getElementsByTagName("Cod_colegio").item(0).getTextContent();
                    int cod_colegio = Integer.valueOf(cod_colg);

                    Profesores profesor = new Profesores(cod_prof, nombre, estudios, rangos, genero, cod_colegio);

                    this.array_profesores.add(profesor);
                }
            }
       // }

        return this.array_profesores;

    }

    public void GuardarProfesoresFichero(ArrayList<Profesores> array_profesores) throws IOException {

   
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            try {
                DocumentBuilder builder = factory.newDocumentBuilder();
                DOMImplementation implementation = builder.getDOMImplementation();
                Document document = implementation.createDocument(null, "Profesores", null);
                document.setXmlVersion("1.0");

                for (int i = 0; i <= array_profesores.size(); i++) {
                    Element raiz = document.createElement("profesor"); //nodo empleado
                    document.getDocumentElement().appendChild(raiz);

                    CrearElemento("cod_prof", Integer.toString(array_profesores.get(i).getCod_colegio()), raiz, document);

                    CrearElemento("nombre", array_profesores.get(i).getNombre(), raiz, document);

                    CrearElemento("estudios", array_profesores.get(i).getEstudios(), raiz, document);

                    CrearElemento("rangos", array_profesores.get(i).getRangos(), raiz, document);

                    CrearElemento("genero", array_profesores.get(i).getGenero(), raiz, document);

                    CrearElemento("Cod_colegio", Integer.toString(array_profesores.get(i).getCod_colegio()), raiz, document);

                    Source source = new DOMSource(document);
                    Result result = new StreamResult(new java.io.File("Profesores.xml"));
                    Transformer transformer = TransformerFactory.newInstance().newTransformer();
                    //transforma el don en un fichero xml
                    transformer.transform(source, result);

                    XMLReader procesadorXML = XMLReaderFactory.createXMLReader();
                    Colegio.GestionContenido gestor = new Colegio.GestionContenido();
                    procesadorXML.setContentHandler(gestor);
                    InputSource fileXML = new InputSource("profesores.xml");
                    procesadorXML.parse(fileXML);
                }

            } catch (Exception e) {

                System.err.println("Error: " + e);
            }
        

        }

    

    public void setCod_colegio(int Cod_colegio) {
        this.Cod_colegio = Cod_colegio;
    }

    public int getCod_colegio() {
        return Cod_colegio;
    }

    public void setCod_prof(int cod_prof) {
        this.cod_prof = cod_prof;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEstudios(String estudios) {
        this.estudios = estudios;
    }

    public void setRangos(String rangos) {
        this.rangos = rangos;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getCod_prof() {
        return cod_prof;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEstudios() {
        return estudios;
    }

    public String getRangos() {
        return rangos;
    }

    public String getGenero() {
        return genero;
    }
}
