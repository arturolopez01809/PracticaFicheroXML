/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.ParserConfigurationException;
import modelo.Colegio;
import org.xml.sax.SAXException;

/**
 *
 * @author artur
 */
public class ControladorColegios implements Serializable {

    private ArrayList<Colegio> array_colegio;

    public ControladorColegios() {
        this.array_colegio = new ArrayList();
    }

    public ArrayList<Colegio> getArray_colegio() {
        return array_colegio;
    }

    public Colegio getColegioDeArray(int i) {
        return array_colegio.get(i);
    }

    public String[][] introducirColegiosEnMatriz() {

        String contenido_tabla[][] = new String[this.getArray_colegio().size()][2];

        for (int i = 0; i < this.getArray_colegio().size(); i++) {

            contenido_tabla[i][0] = String.valueOf(this.getColegioDeArray(i).getCod_colegio());
            contenido_tabla[i][1] = String.valueOf(this.getColegioDeArray(i).getNombre());
        }

        return contenido_tabla;
    }

    public void insertarColegio(Colegio colegio) {

        if (!BuscarCodColegioRepetido(colegio)) {
            array_colegio.add(colegio);
        }

    }

    public boolean BuscarCodColegioRepetido(Colegio colegio) {
        boolean copia = false;

        for (int i = 0; i < array_colegio.size(); i++) {
            if (colegio.getCod_colegio() == array_colegio.get(i).getCod_colegio()) {
                copia = true;
            }
        }

        return copia;
    }

    public ArrayList CaptarCod_colegiosEnJComboBox() {
        ArrayList<String> cod_colegio = new ArrayList();
        for (int i = 0; i < getArray_colegio().size(); i++) {
            cod_colegio.add(String.valueOf(getColegioDeArray(i).getCod_colegio()));
        }
        return cod_colegio;
    }

    public String[][] almacenarColegios(Colegio colegio) {

        String contenido_tabla[][] = new String[this.getArray_colegio().size()][2];
        this.insertarColegio(colegio);

        contenido_tabla = this.introducirColegiosEnMatriz();

        try {
            this.GuardarColegiosFichero();
        } catch (IOException ex) {
            Logger.getLogger(ControladorColegios.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return contenido_tabla;
    }

    public void CaptarColegiosFichero() throws IOException, ParserConfigurationException, SAXException {
        Colegio colegio = new Colegio();
        this.setArray_colegio(colegio.LeerColegiosFichero());
    }

    public void GuardarColegiosFichero() throws IOException {
        Colegio colegio = new Colegio();
        colegio.GuardarColegiosFichero(this.array_colegio);

    }

    public void setArray_colegio(ArrayList<Colegio> array_colegio) {
        this.array_colegio = array_colegio;
    }

}
