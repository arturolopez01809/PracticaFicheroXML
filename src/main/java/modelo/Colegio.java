/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.jar.Attributes;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;

/**
 *
 * @author artur
 */
public class Colegio implements Serializable {

    private ArrayList<Colegio> array_colegio;

    private int cod_colegio;
    private String nombre;
    private String direccion;
    private boolean esPublico;
    private boolean tieneFP;

    public Colegio() {
        array_colegio = new ArrayList();

    }

    public Colegio(int cod_colegio, String nombre, String direccion, boolean esPublico, boolean tieneFP) {
        array_colegio = new ArrayList();
        this.setCod_colegio(cod_colegio);
        this.setNombre(nombre);
        this.setDireccion(direccion);
        this.setEsPublico(esPublico);
        this.setTieneFP(tieneFP);
    }

    public ArrayList LeerColegiosFichero() throws IOException, ParserConfigurationException, SAXException {

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        Document documento = builder.parse("Colegios.xml");
        

        documento.getDocumentElement().normalize();

        NodeList listaColegios = documento.getElementsByTagName("colegio");

        for (int i = 0; i < listaColegios.getLength(); i++) {
            Node nodo = listaColegios.item(i);

            if (nodo.getNodeType() == Node.ELEMENT_NODE) {
                Element e = (Element) nodo;

                String cod = e.getElementsByTagName("cod_colegio").item(0).getTextContent();
                int cod_colegio = Integer.valueOf(cod);
                String nombre = e.getElementsByTagName("nombre").item(0).getTextContent().toString();
                String direccion = e.getElementsByTagName("direccion").item(0).getTextContent().toString();

                String publico = e.getElementsByTagName("esPublico").item(0).getTextContent().toString();
                boolean espublico = Boolean.valueOf(publico);

                String fp = e.getElementsByTagName("tieneFP").item(0).getTextContent().toString();
                boolean tienefp = Boolean.valueOf(fp);

                Colegio colegio = new Colegio(cod_colegio, nombre, direccion, espublico, tienefp);

                this.array_colegio.add(colegio);
            }
        }

        return this.array_colegio;

    }

    public void GuardarColegiosFichero(ArrayList<Colegio> array_colegios) throws IOException {

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            DOMImplementation implementation = builder.getDOMImplementation();
            Document document = implementation.createDocument(null, "Colegios", null);
            document.setXmlVersion("1.0");

            for (int i = 0; i <= array_colegios.size(); i++) {
                Element raiz = document.createElement("colegio"); //nodo empleado
                document.getDocumentElement().appendChild(raiz);

                CrearElemento("cod_colegio", Integer.toString(array_colegios.get(i).getCod_colegio()), raiz, document);

                CrearElemento("nombre", array_colegios.get(i).getNombre(), raiz, document);

                CrearElemento("direccion", array_colegios.get(i).getDireccion(), raiz, document);

                CrearElemento("esPublico", String.valueOf(array_colegios.get(i).isEsPublico()), raiz, document);

                CrearElemento("tieneFP", String.valueOf(array_colegios.get(i).isTieneFP()), raiz, document);

                Source source = new DOMSource(document);
                Result result = new StreamResult(new java.io.File("Colegios.xml"));
                Transformer transformer = TransformerFactory.newInstance().newTransformer();
                //transforma el don en un fichero xml
                transformer.transform(source, result);

                XMLReader procesadorXML = XMLReaderFactory.createXMLReader();
                GestionContenido gestor = new GestionContenido();
                procesadorXML.setContentHandler(gestor);
                InputSource fileXML = new InputSource("colegios.xml");
                procesadorXML.parse(fileXML);
            }

        } catch (Exception e) {

            System.err.println("Error: " + e);
        }
    }

    static void CrearElemento(String datoEmple, String valor, Element raiz, Document document) {
        Element elem = document.createElement(datoEmple);
        Text text = document.createTextNode(valor); //damos valor
        raiz.appendChild(elem); //pegamos el elemento hijo a la raiz
        elem.appendChild(text); //pegamos el valor		 	
    }

    static class GestionContenido extends DefaultHandler {

        public GestionContenido() {
            super();
        }

        public void startDocument() {
            System.out.println("Comienzo del Documento XML");
        }

        public void endDocument() {
            System.out.println("Final del Documento XML");
        }

        public void startElement(String uri, String nombre,
                String nombreC, Attributes atts) {
            System.out.printf("\t Principio Elemento: %s %n", nombre);
        }

        public void endElement(String uri, String nombre,
                String nombreC) {
            System.out.printf("\tFin Elemento: %s %n", nombre);
        }

        public void characters(char[] ch, int inicio, int longitud)
                throws SAXException {
            String car = new String(ch, inicio, longitud);
            //quitar saltos de línea	
            car = car.replaceAll("[\t\n]", "");
            System.out.printf("\t Caracteres: %s %n", car);
        }

    }//fin GestionContenido

    public void setCod_colegio(int cod_colegio) {

        this.cod_colegio = cod_colegio;

    }

    public void setNombre(String Nombre) {
        this.nombre = Nombre;
    }

    public void setDireccion(String Direccion) {
        this.direccion = Direccion;
    }

    public void setEsPublico(boolean EsPublico) {
        this.esPublico = EsPublico;
    }

    public void setTieneFP(boolean TieneFP) {
        this.tieneFP = TieneFP;
    }

    public int getCod_colegio() {
        return this.cod_colegio;
    }

    public String getNombre() {
        return this.nombre;
    }

    public String getDireccion() {
        return this.direccion;
    }

    public boolean isEsPublico() {
        return this.esPublico;
    }

    public boolean isTieneFP() {
        return this.tieneFP;
    }
}
