/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.util.ArrayList;
import modelo.Colegio;
import interfazad.*;
import controlador.ControladorColegios;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author artur
 */
public class NewEmptyJUnitTest {

    public ArrayList<Colegio> array_colegio = new ArrayList();
    public ControladorColegios controlador_colegios = new ControladorColegios();

    public NewEmptyJUnitTest() {
    }

    @org.junit.jupiter.api.BeforeAll
    public static void setUpClass() throws Exception {
    }

    @org.junit.jupiter.api.AfterAll
    public static void tearDownClass() throws Exception {
    }

    @org.junit.jupiter.api.BeforeEach
    public void setUp() throws Exception {
    }

    @org.junit.jupiter.api.AfterEach
    public void tearDown() throws Exception {
    }

//    @BeforeAll
//    public static void setUpClass() {
//    }
//    
//    @AfterAll
//    public static void tearDownClass() {
//    }
//    
//    @BeforeEach
//    public void setUp() {
//    }
//    
//    @AfterEach
//    public void tearDown() {
//    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test
    public void comprobar_tamanio_al_insertar_colegio_en_fichero() {

        this.array_colegio = controlador_colegios.getArray_colegio();
        int tamanio = array_colegio.size();

        Colegio colegio = new Colegio(752, "perez", "Ronda", true, true);

        controlador_colegios.almacenarColegios(colegio);

        //assertEquals(tamanio + 1, array_colegio.size());
        assertEquals(tamanio + 1, controlador_colegios.getArray_colegio().size());
    }

    @Test
    public void comprobar_tamanio_al_insertar_dos_colegios_en_array_con_misma_pk() {

        this.array_colegio = controlador_colegios.getArray_colegio();
        int tamanio = array_colegio.size();

        Colegio colegio = new Colegio(752, "Rodr", "Ronda", true, true);

        controlador_colegios.almacenarColegios(colegio);

        Colegio colegio_2 = new Colegio(752, "Rodr", "Ronda", true, true);

        controlador_colegios.almacenarColegios(colegio_2);

        //assertEquals(tamanio + 1, array_colegio.size());
        assertEquals(tamanio + 1, controlador_colegios.getArray_colegio().size());

    }

    @Test
    public void comprobar_eliminar_1_colegio() {
        this.array_colegio = controlador_colegios.getArray_colegio();
        int tamanio = array_colegio.size();

        Colegio colegio = new Colegio();

        colegio = new Colegio(045, "Rodr", "Ronda", true, true);
        controlador_colegios.almacenarColegios(colegio);
        
        controlador_colegios.getArray_colegio().remove(colegio);

        assertEquals(tamanio, controlador_colegios.getArray_colegio().size());
    }
    
    @Test
    public void comprobar_modificar_1_colegio() {
        this.array_colegio = controlador_colegios.getArray_colegio();
        int tamanio = array_colegio.size();

        Colegio colegio = new Colegio();

        colegio = new Colegio(045, "Rodr", "Ronda", true, true);
        controlador_colegios.almacenarColegios(colegio);
        
        controlador_colegios.getArray_colegio().remove(colegio);

        assertEquals(tamanio, controlador_colegios.getArray_colegio().size());
    }

}
