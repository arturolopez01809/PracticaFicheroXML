/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfazad;

import javax.swing.JOptionPane;
import controlador.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.stream.StreamResult;
import modelo.*;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

/**
 *
 * @author artur
 */
public class ApartadoGrafico extends javax.swing.JFrame {

    private final ControladorColegios controlador_colegios;
    private final ControladorProfesores controlador_profesores;
    private final ControladorAsignaturas controlador_asignaturas;
    private boolean activar_ingresar;
    private boolean activar_ingresar_profesores;
    private boolean activar_ingresar_asignaturas;
    private boolean activar_modificar;
    private boolean activar_modificar_profesores;
    private boolean activar_modificar_asignaturas;
    private boolean activar_eliminar;
    private boolean activar_eliminar_profesores;
    private boolean activar_eliminar_asignaturas;

    public void setActivar_ingresar(boolean activar_ingresar) {
        this.activar_ingresar = activar_ingresar;
    }

    public void setActivar_ingresar_asignaturas(boolean activar_ingresar_asignaturas) {
        this.activar_ingresar_asignaturas = activar_ingresar_asignaturas;
    }

    public void setActivar_modificar_asignaturas(boolean activar_modificar_asignaturas) {
        this.activar_modificar_asignaturas = activar_modificar_asignaturas;
    }

    public void setActivar_eliminar_asignaturas(boolean activar_eliminar_asignaturas) {
        this.activar_eliminar_asignaturas = activar_eliminar_asignaturas;
    }

    public boolean isActivar_ingresar_asignaturas() {
        return activar_ingresar_asignaturas;
    }

    public boolean isActivar_modificar_asignaturas() {
        return activar_modificar_asignaturas;
    }

    public boolean isActivar_eliminar_asignaturas() {
        return activar_eliminar_asignaturas;
    }

    public void setActivar_modificar(boolean activar_modificar) {
        this.activar_modificar = activar_modificar;
    }

    public void setActivar_eliminar(boolean activar_cancelar) {
        this.activar_eliminar = activar_cancelar;
    }

    public boolean isActivar_eliminar() {
        return activar_eliminar;
    }

    /**
     * Creates new form ApartadoGrafico
     */
    public ApartadoGrafico() throws IOException, FileNotFoundException, ClassNotFoundException, ParserConfigurationException, SAXException {
        initComponents();
        controlador_colegios = new ControladorColegios();
        controlador_profesores = new ControladorProfesores();
        controlador_asignaturas = new ControladorAsignaturas();

        String contenido_tabla[][] = new String[controlador_colegios.getArray_colegio().size()][2];
        String contenido_tabla_profesores[][] = new String[controlador_profesores.getArray_profesores().size()][2];
        String contenido_tabla_asignaturas[][] = new String[controlador_asignaturas.getArray_asignatuas().size()][2];
        
        this.controlador_colegios.CaptarColegiosFichero();
        contenido_tabla = controlador_colegios.introducirColegiosEnMatriz();
        this.mostrarTablaColegio(contenido_tabla);

        this.controlador_profesores.CaptarProfesoresFichero();
        contenido_tabla_profesores = controlador_profesores.introducirProfesorEnMatriz();
        this.mostrarTablaProfesores(contenido_tabla_profesores);
        
        this.controlador_asignaturas.CaptarAsignaturasFichero();
        contenido_tabla_asignaturas = controlador_asignaturas.introducirAsignaturasEnMatriz();
        this.mostrarTablaAsignaturas(contenido_tabla_asignaturas);

        CaptarYActualizarComboBoxCodColegios();
        CaptarYActualizarComboBoxCod_prof();

        activarDesactivarEdicionBotones(false);
        activarDesactivarEdicionBotonesProfesores(false);
        activarDesactivarEdicionBotonesAsignaturas(false);
    }

    public void activarDesactivarEdicionBotones(Boolean activar) {

        buttonAceptar.setVisible(activar);
        buttonCancelar.setVisible(activar);

        textFieldCod_colegio.setEditable(activar);
        textFieldNombre.setEditable(activar);
        textFieldDireccion.setEditable(activar);
        textFieldEsPublico.setEditable(activar);
        textFieldTieneFP.setEditable(activar);

    }

    public void activarDesactivarEdicionBotonesProfesores(Boolean activar) {

        buttonAceptarProfesores.setVisible(activar);
        buttonCancelarProfesores.setVisible(activar);

        textFieldCod_prof.setEditable(activar);
        textFieldNombreProf.setEditable(activar);
        textFieldEstudios.setEditable(activar);
        textFieldRango.setEditable(activar);
        textFieldGenero.setEditable(activar);

    }

    public void activarDesactivarEdicionBotonesAsignaturas(Boolean activar) {

        buttonAceptarAsignatura.setVisible(activar);
        buttonCancelarAsignatura.setVisible(activar);

        textFieldCod_asig.setEditable(activar);
        textFieldNombreAsignatura.setEditable(activar);
        textFieldConvocatoria.setEditable(activar);
        textFieldTipo.setEditable(activar);
        textFieldCurso.setEditable(activar);

    }

    public void CaptarYActualizarComboBoxCodColegios() {

        ArrayList<String> cod_colegios = controlador_colegios.CaptarCod_colegiosEnJComboBox();

        for (int i = 0; i < cod_colegios.size(); i++) {
            jComboBox2.addItem(cod_colegios.get(i));
        }
    }

    public void CaptarYActualizarComboBoxCod_prof() {

        ArrayList<String> cod_prof = controlador_profesores.CaptarCod_profEnJComboBox();

        for (int i = 0; i < cod_prof.size(); i++) {
            jComboBoxAsignaturas.addItem(cod_prof.get(i));
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        labelCod_colegio = new javax.swing.JLabel();
        labelNombre = new javax.swing.JLabel();
        labelDireccion = new javax.swing.JLabel();
        labelEsPublico = new javax.swing.JLabel();
        labelTieneFP = new javax.swing.JLabel();
        textFieldCod_colegio = new javax.swing.JTextField();
        textFieldNombre = new javax.swing.JTextField();
        textFieldDireccion = new javax.swing.JTextField();
        textFieldEsPublico = new javax.swing.JTextField();
        textFieldTieneFP = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        buttonIngresar = new javax.swing.JButton();
        buttonModificar = new javax.swing.JButton();
        buttonBorrar = new javax.swing.JButton();
        buttonAceptar = new javax.swing.JButton();
        buttonCancelar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        labelEsPublico2 = new javax.swing.JLabel();
        buttonBorrarProfesores = new javax.swing.JButton();
        labelTieneFP2 = new javax.swing.JLabel();
        buttonAceptarProfesores = new javax.swing.JButton();
        textFieldCod_prof = new javax.swing.JTextField();
        buttonCancelarProfesores = new javax.swing.JButton();
        textFieldNombreProf = new javax.swing.JTextField();
        textFieldEstudios = new javax.swing.JTextField();
        textFieldRango = new javax.swing.JTextField();
        textFieldGenero = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        labelCod_colegio2 = new javax.swing.JLabel();
        labelNombre2 = new javax.swing.JLabel();
        buttonIngresarProfesores = new javax.swing.JButton();
        labelDireccion2 = new javax.swing.JLabel();
        buttonModificarProfesores = new javax.swing.JButton();
        jComboBox2 = new javax.swing.JComboBox<>();
        jTextFieldFKCod_colegio = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        labelEsPublico1 = new javax.swing.JLabel();
        buttonBorrarAsignatura = new javax.swing.JButton();
        labelTieneFP1 = new javax.swing.JLabel();
        buttonAceptarAsignatura = new javax.swing.JButton();
        textFieldConvocatoria = new javax.swing.JTextField();
        buttonCancelarAsignatura = new javax.swing.JButton();
        textFieldCod_asig = new javax.swing.JTextField();
        textFieldTipo = new javax.swing.JTextField();
        textFieldCurso = new javax.swing.JTextField();
        textFieldNombreAsignatura = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        labelCod_colegio1 = new javax.swing.JLabel();
        labelNombre1 = new javax.swing.JLabel();
        buttonIngresarAsignatura = new javax.swing.JButton();
        labelDireccion1 = new javax.swing.JLabel();
        buttonModificarAsignatura = new javax.swing.JButton();
        jComboBoxAsignaturas = new javax.swing.JComboBox<>();
        jTextFieldFKCod_prof = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTabbedPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabbedPane1MouseClicked(evt);
            }
        });

        labelCod_colegio.setText("Cod_colegio");

        labelNombre.setText("Nombre");

        labelDireccion.setText("Direccion");

        labelEsPublico.setText("Es Publico");

        labelTieneFP.setText("Tiene FP");

        textFieldCod_colegio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldCod_colegioActionPerformed(evt);
            }
        });

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Cod_colegio", "Nombre"
            }
        ));
        jTable2.setRowHeight(30);
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);

        buttonIngresar.setText("Ingresar");
        buttonIngresar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonIngresarMouseClicked(evt);
            }
        });
        buttonIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonIngresarActionPerformed(evt);
            }
        });

        buttonModificar.setText("Modificar");
        buttonModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonModificarActionPerformed(evt);
            }
        });

        buttonBorrar.setText("Borrar");
        buttonBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonBorrarActionPerformed(evt);
            }
        });

        buttonAceptar.setText("Aceptar");
        buttonAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAceptarActionPerformed(evt);
            }
        });

        buttonCancelar.setText("Cancelar");
        buttonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 490, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(205, 205, 205)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelCod_colegio)
                    .addComponent(labelNombre)
                    .addComponent(labelDireccion)
                    .addComponent(labelEsPublico)
                    .addComponent(labelTieneFP))
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(textFieldCod_colegio)
                    .addComponent(textFieldNombre)
                    .addComponent(textFieldDireccion)
                    .addComponent(textFieldEsPublico)
                    .addComponent(textFieldTieneFP, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(53, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(121, 121, 121)
                .addComponent(buttonIngresar)
                .addGap(27, 27, 27)
                .addComponent(buttonModificar)
                .addGap(37, 37, 37)
                .addComponent(buttonBorrar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(buttonAceptar)
                .addGap(18, 18, 18)
                .addComponent(buttonCancelar)
                .addGap(80, 80, 80))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelCod_colegio)
                            .addComponent(textFieldCod_colegio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelNombre)
                            .addComponent(textFieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelDireccion)
                            .addComponent(textFieldDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelEsPublico)
                            .addComponent(textFieldEsPublico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(17, 17, 17)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelTieneFP)
                            .addComponent(textFieldTieneFP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 104, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(buttonIngresar)
                        .addComponent(buttonModificar)
                        .addComponent(buttonBorrar))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(buttonAceptar)
                        .addComponent(buttonCancelar)))
                .addGap(211, 211, 211))
        );

        jTabbedPane1.addTab("Colagios", jPanel1);

        labelEsPublico2.setText("Rango");

        buttonBorrarProfesores.setText("Borrar");
        buttonBorrarProfesores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonBorrarProfesoresActionPerformed(evt);
            }
        });

        labelTieneFP2.setText("Genero");

        buttonAceptarProfesores.setText("Aceptar");
        buttonAceptarProfesores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAceptarProfesoresActionPerformed(evt);
            }
        });

        textFieldCod_prof.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldCod_profActionPerformed(evt);
            }
        });

        buttonCancelarProfesores.setText("Cancelar");
        buttonCancelarProfesores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCancelarProfesoresActionPerformed(evt);
            }
        });

        jTable4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Cod_prof", "Nombre"
            }
        ));
        jTable4.setRowHeight(30);
        jTable4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable4MouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(jTable4);

        labelCod_colegio2.setText("Cod_prof");

        labelNombre2.setText("Nombre");

        buttonIngresarProfesores.setText("Ingresar");
        buttonIngresarProfesores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonIngresarProfesoresMouseClicked(evt);
            }
        });
        buttonIngresarProfesores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonIngresarProfesoresActionPerformed(evt);
            }
        });

        labelDireccion2.setText("Estudios");

        buttonModificarProfesores.setText("Modificar");
        buttonModificarProfesores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonModificarProfesoresActionPerformed(evt);
            }
        });

        jTextFieldFKCod_colegio.setEditable(false);

        jLabel1.setText("Cod_colegio");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(121, 121, 121)
                .addComponent(buttonIngresarProfesores)
                .addGap(27, 27, 27)
                .addComponent(buttonModificarProfesores)
                .addGap(37, 37, 37)
                .addComponent(buttonBorrarProfesores)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 161, Short.MAX_VALUE)
                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53)
                .addComponent(buttonAceptarProfesores)
                .addGap(18, 18, 18)
                .addComponent(buttonCancelarProfesores)
                .addGap(80, 80, 80))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 490, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(205, 205, 205)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelCod_colegio2)
                    .addComponent(labelNombre2)
                    .addComponent(labelDireccion2)
                    .addComponent(labelEsPublico2)
                    .addComponent(labelTieneFP2)
                    .addComponent(jLabel1))
                .addGap(38, 38, 38)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextFieldFKCod_colegio)
                    .addComponent(textFieldCod_prof)
                    .addComponent(textFieldNombreProf)
                    .addComponent(textFieldEstudios)
                    .addComponent(textFieldRango)
                    .addComponent(textFieldGenero, javax.swing.GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelCod_colegio2)
                            .addComponent(textFieldCod_prof, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelNombre2)
                            .addComponent(textFieldNombreProf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelDireccion2)
                            .addComponent(textFieldEstudios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelEsPublico2)
                            .addComponent(textFieldRango, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(17, 17, 17)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelTieneFP2)
                            .addComponent(textFieldGenero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldFKCod_colegio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 102, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(buttonIngresarProfesores)
                        .addComponent(buttonModificarProfesores)
                        .addComponent(buttonBorrarProfesores))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(buttonAceptarProfesores)
                        .addComponent(buttonCancelarProfesores)
                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(211, 211, 211))
        );

        jTabbedPane1.addTab("Profesores", jPanel2);

        labelEsPublico1.setText("Curso");

        buttonBorrarAsignatura.setText("Borrar");
        buttonBorrarAsignatura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonBorrarAsignaturaActionPerformed(evt);
            }
        });

        labelTieneFP1.setText("Nombre");

        buttonAceptarAsignatura.setText("Aceptar");
        buttonAceptarAsignatura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAceptarAsignaturaActionPerformed(evt);
            }
        });

        textFieldConvocatoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldConvocatoriaActionPerformed(evt);
            }
        });

        buttonCancelarAsignatura.setText("Cancelar");
        buttonCancelarAsignatura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCancelarAsignaturaActionPerformed(evt);
            }
        });

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Cod_asig", "Convocatoria"
            }
        ));
        jTable3.setRowHeight(30);
        jTable3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable3MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTable3);

        labelCod_colegio1.setText("Convocatoria");

        labelNombre1.setText("Cod_asig");

        buttonIngresarAsignatura.setText("Ingresar");
        buttonIngresarAsignatura.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonIngresarAsignaturaMouseClicked(evt);
            }
        });
        buttonIngresarAsignatura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonIngresarAsignaturaActionPerformed(evt);
            }
        });

        labelDireccion1.setText("Tipo");

        buttonModificarAsignatura.setText("Modificar");
        buttonModificarAsignatura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonModificarAsignaturaActionPerformed(evt);
            }
        });

        jTextFieldFKCod_prof.setEditable(false);

        jLabel2.setText("Cod_prof");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 490, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(205, 205, 205)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelCod_colegio1)
                    .addComponent(labelNombre1)
                    .addComponent(labelDireccion1)
                    .addComponent(labelEsPublico1)
                    .addComponent(labelTieneFP1)
                    .addComponent(jLabel2))
                .addGap(38, 38, 38)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextFieldFKCod_prof)
                    .addComponent(textFieldConvocatoria)
                    .addComponent(textFieldCod_asig)
                    .addComponent(textFieldTipo)
                    .addComponent(textFieldCurso)
                    .addComponent(textFieldNombreAsignatura, javax.swing.GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(121, 121, 121)
                .addComponent(buttonIngresarAsignatura)
                .addGap(27, 27, 27)
                .addComponent(buttonModificarAsignatura)
                .addGap(37, 37, 37)
                .addComponent(buttonBorrarAsignatura)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 172, Short.MAX_VALUE)
                .addComponent(jComboBoxAsignaturas, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(buttonAceptarAsignatura)
                .addGap(18, 18, 18)
                .addComponent(buttonCancelarAsignatura)
                .addGap(80, 80, 80))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelCod_colegio1)
                            .addComponent(textFieldConvocatoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelNombre1)
                            .addComponent(textFieldCod_asig, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelDireccion1)
                            .addComponent(textFieldTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelEsPublico1)
                            .addComponent(textFieldCurso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(17, 17, 17)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelTieneFP1)
                            .addComponent(textFieldNombreAsignatura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldFKCod_prof, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 102, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(buttonIngresarAsignatura)
                        .addComponent(buttonModificarAsignatura)
                        .addComponent(buttonBorrarAsignatura))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(buttonAceptarAsignatura)
                        .addComponent(buttonCancelarAsignatura)
                        .addComponent(jComboBoxAsignaturas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(211, 211, 211))
        );

        jTabbedPane1.addTab("Asignaturas", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAceptarActionPerformed
        // TODO add your handling code here:

        String contenido_tabla[][] = new String[controlador_colegios.getArray_colegio().size()][2];

        if (isActivar_ingresar()) {

            Colegio colegio = new Colegio(Integer.valueOf(textFieldCod_colegio.getText()), textFieldNombre.getText(), textFieldDireccion.getText(), Boolean.valueOf(textFieldEsPublico.getText()), Boolean.valueOf(textFieldTieneFP.getText()));

            contenido_tabla = controlador_colegios.almacenarColegios(colegio);

            this.mostrarTablaColegio(contenido_tabla);

            this.setActivar_ingresar(false);

            this.borrarTextFieldColegio();

            this.activarDesactivarEdicionBotones(false);

        } else if (isActivar_modificar()) {

            int i = jTable2.getSelectedRow();

            this.controlador_colegios.getColegioDeArray(i).setCod_colegio(Integer.valueOf(textFieldCod_colegio.getText()));
            this.controlador_colegios.getColegioDeArray(i).setNombre(textFieldNombre.getText());
            this.controlador_colegios.getColegioDeArray(i).setDireccion(textFieldDireccion.getText());
            this.controlador_colegios.getColegioDeArray(i).setEsPublico(Boolean.valueOf(textFieldEsPublico.getText()));
            this.controlador_colegios.getColegioDeArray(i).setTieneFP(Boolean.valueOf(textFieldTieneFP.getText()));

            contenido_tabla = controlador_colegios.introducirColegiosEnMatriz();

            try {
                controlador_colegios.GuardarColegiosFichero();
            } catch (IOException ex) {
                Logger.getLogger(ApartadoGrafico.class.getName()).log(Level.SEVERE, null, ex);
            }

            this.mostrarTablaColegio(contenido_tabla);

            this.setActivar_modificar(false);

            this.borrarTextFieldColegio();

            this.activarDesactivarEdicionBotones(false);
        } else if (isActivar_eliminar()) {

            int i = jTable2.getSelectedRow();

            boolean aux = this.buscarFKEnProfesores(i);

            if (aux == false) {

                this.controlador_colegios.getArray_colegio().remove(i);

                try {
                    controlador_colegios.GuardarColegiosFichero();
                } catch (IOException ex) {
                    Logger.getLogger(ApartadoGrafico.class.getName()).log(Level.SEVERE, null, ex);
                }

                
            } else {
                JOptionPane.showMessageDialog(this, "Lo sentimos...No puedes eliminar un colegio con profesores previamente asignados");
            }
            
            contenido_tabla = controlador_colegios.introducirColegiosEnMatriz();
            this.mostrarTablaColegio(contenido_tabla);

            this.setActivar_eliminar(false);

            this.borrarTextFieldColegio();

            this.activarDesactivarEdicionBotones(false);
        }

        jComboBox2.removeAllItems();

        CaptarYActualizarComboBoxCodColegios();
    }//GEN-LAST:event_buttonAceptarActionPerformed

    public boolean buscarFKEnProfesores(int aux) {

        boolean encontrado = false;

        for (int i = 0; i < this.controlador_profesores.getArray_profesores().size(); i++) {

            if (controlador_profesores.getProfesoresDeArray(i).getCod_colegio() == this.controlador_colegios.getColegioDeArray(aux).getCod_colegio()) {
                encontrado = true;
            }

        }

        return encontrado;

    }

    public boolean buscarFKEnAsignaturas(int aux) {

        boolean encontrado = false;

        for (int i = 0; (i < this.controlador_asignaturas.getArray_asignatuas().size()) && (encontrado == false); i++) {

            if (controlador_asignaturas.getAsignaturaArrayAsignaturas(i).getCod_prof() == this.controlador_profesores.getProfesoresDeArray(aux).getCod_prof()) {
                encontrado = true;
            }

        }

        return encontrado;

    }

    private void borrarTextFieldColegio() {

        textFieldCod_colegio.setText("");
        textFieldNombre.setText("");
        textFieldDireccion.setText("");
        textFieldEsPublico.setText("");
        textFieldTieneFP.setText("");

    }

    private void borrarTextFieldProfesores() {

        textFieldCod_prof.setText("");
        textFieldNombreProf.setText("");
        textFieldEstudios.setText("");
        textFieldRango.setText("");
        textFieldGenero.setText("");
    }

    private void borrarTextFieldAsignaturas() {

        textFieldCod_asig.setText("");
        textFieldConvocatoria.setText("");
        textFieldTipo.setText("");
        textFieldCurso.setText("");
        textFieldNombreAsignatura.setText("");

    }

    private void mostrarAtributosColegio(int i) {

        textFieldCod_colegio.setText(String.valueOf(this.controlador_colegios.getColegioDeArray(i).getCod_colegio()));
        textFieldNombre.setText(this.controlador_colegios.getColegioDeArray(i).getNombre());
        textFieldDireccion.setText(this.controlador_colegios.getColegioDeArray(i).getDireccion());
        textFieldEsPublico.setText(String.valueOf(this.controlador_colegios.getColegioDeArray(i).isEsPublico()));
        textFieldTieneFP.setText(String.valueOf(this.controlador_colegios.getColegioDeArray(i).isTieneFP()));
    }

    private void mostrarAtributosProfesores(int i) {

        textFieldCod_prof.setText(String.valueOf(this.controlador_profesores.getProfesoresDeArray(i).getCod_prof()));
        textFieldNombreProf.setText(this.controlador_profesores.getProfesoresDeArray(i).getNombre());
        textFieldEstudios.setText(this.controlador_profesores.getProfesoresDeArray(i).getEstudios());
        textFieldRango.setText(this.controlador_profesores.getProfesoresDeArray(i).getRangos());
        textFieldGenero.setText(this.controlador_profesores.getProfesoresDeArray(i).getGenero());
        jTextFieldFKCod_colegio.setText(String.valueOf(this.controlador_profesores.getProfesoresDeArray(i).getCod_colegio()));

    }

    private void mostrarAtributosAsignatura(int i) {

        textFieldCod_asig.setText(String.valueOf(this.controlador_asignaturas.getAsignaturaArrayAsignaturas(i).getCod_asig()));
        textFieldNombreAsignatura.setText(this.controlador_asignaturas.getAsignaturaArrayAsignaturas(i).getNombre());
        textFieldTipo.setText(this.controlador_asignaturas.getAsignaturaArrayAsignaturas(i).getTipo());
        textFieldCurso.setText(String.valueOf(this.controlador_asignaturas.getAsignaturaArrayAsignaturas(i).getCurso()));
        textFieldConvocatoria.setText(String.valueOf(this.controlador_asignaturas.getAsignaturaArrayAsignaturas(i).getConvocatoria()));
        jTextFieldFKCod_prof.setText(String.valueOf(this.controlador_asignaturas.getAsignaturaArrayAsignaturas(i).getCod_prof()));
    }

    private void buttonModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonModificarActionPerformed

        this.activarDesactivarEdicionBotones(true);

        this.setActivar_modificar(true);
    }//GEN-LAST:event_buttonModificarActionPerformed

    private void buttonIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonIngresarActionPerformed

        this.activarDesactivarEdicionBotones(true);

        this.setActivar_ingresar(true);
    }//GEN-LAST:event_buttonIngresarActionPerformed

    private void buttonIngresarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonIngresarMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonIngresarMouseClicked

    private void textFieldCod_colegioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldCod_colegioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldCod_colegioActionPerformed

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked

        int i = jTable2.getSelectedRow();

        if (i >= 0) {
            mostrarAtributosColegio(i);
        }

    }//GEN-LAST:event_jTable2MouseClicked

    private void buttonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCancelarActionPerformed
        // TODO add your handling code here:

        this.activarDesactivarEdicionBotones(false);

        this.borrarTextFieldColegio();

    }//GEN-LAST:event_buttonCancelarActionPerformed

    private void buttonBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonBorrarActionPerformed
        // TODO add your handling code here:
        this.activarDesactivarEdicionBotones(true);

        this.activar_eliminar = true;

    }//GEN-LAST:event_buttonBorrarActionPerformed

    private void buttonBorrarAsignaturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonBorrarAsignaturaActionPerformed
        // TODO add your handling code here:

        this.activarDesactivarEdicionBotonesAsignaturas(true);

        this.activar_eliminar_asignaturas = true;

    }//GEN-LAST:event_buttonBorrarAsignaturaActionPerformed

    private void buttonAceptarAsignaturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAceptarAsignaturaActionPerformed
        // TODO add your handling code here:

        String contenido_tabla[][] = new String[controlador_asignaturas.getArray_asignatuas().size()][2];

        if (isActivar_ingresar_asignaturas()) {

            Asignaturas asignatura = new Asignaturas(Integer.valueOf(textFieldCod_asig.getText()), textFieldTipo.getText(), Integer.valueOf(textFieldCurso.getText()), textFieldNombreAsignatura.getText(), Integer.valueOf(textFieldConvocatoria.getText()), Integer.valueOf((String) jComboBoxAsignaturas.getSelectedItem()));

            controlador_asignaturas.insertarAsignatura(asignatura);

            contenido_tabla = controlador_asignaturas.introducirAsignaturasEnMatriz();

            try {
                controlador_asignaturas.GuardarAsignaturasFichero();
            } catch (IOException ex) {
                Logger.getLogger(ApartadoGrafico.class.getName()).log(Level.SEVERE, null, ex);
            }

            this.mostrarTablaAsignaturas(contenido_tabla);

            this.setActivar_ingresar_asignaturas(false);

            this.borrarTextFieldAsignaturas();

            this.activarDesactivarEdicionBotonesAsignaturas(false);

        } else if (isActivar_modificar_asignaturas()) {

            int i = jTable3.getSelectedRow();

            this.controlador_asignaturas.getAsignaturaArrayAsignaturas(i).setCod_asig(Integer.valueOf(textFieldCod_asig.getText()));
            this.controlador_asignaturas.getAsignaturaArrayAsignaturas(i).setConvocatoria(Integer.valueOf(textFieldConvocatoria.getText()));
            this.controlador_asignaturas.getAsignaturaArrayAsignaturas(i).setTipo(textFieldTipo.getText());
            this.controlador_asignaturas.getAsignaturaArrayAsignaturas(i).setCurso(Integer.valueOf(textFieldCurso.getText()));
            this.controlador_asignaturas.getAsignaturaArrayAsignaturas(i).setNombre(textFieldNombreAsignatura.getText());
            this.controlador_asignaturas.getAsignaturaArrayAsignaturas(i).setCod_prof(Integer.valueOf((String) jComboBoxAsignaturas.getSelectedItem()));

            contenido_tabla = controlador_asignaturas.introducirAsignaturasEnMatriz();

            try {
                controlador_asignaturas.GuardarAsignaturasFichero();
            } catch (IOException ex) {
                Logger.getLogger(ApartadoGrafico.class.getName()).log(Level.SEVERE, null, ex);
            }

            this.mostrarTablaAsignaturas(contenido_tabla);

            this.setActivar_modificar_asignaturas(false);

            this.borrarTextFieldAsignaturas();

            this.activarDesactivarEdicionBotonesAsignaturas(false);
        } else if (isActivar_eliminar_asignaturas()) {
            int i = jTable3.getSelectedRow();

            this.controlador_asignaturas.getArray_asignatuas().remove(i);

            contenido_tabla = controlador_asignaturas.introducirAsignaturasEnMatriz();

            try {
                controlador_asignaturas.GuardarAsignaturasFichero();
            } catch (IOException ex) {
                Logger.getLogger(ApartadoGrafico.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            contenido_tabla = controlador_asignaturas.introducirAsignaturasEnMatriz();
            this.mostrarTablaAsignaturas(contenido_tabla);

            this.setActivar_eliminar_asignaturas(false);

            this.borrarTextFieldAsignaturas();

            this.activarDesactivarEdicionBotonesAsignaturas(false);
        }

    }//GEN-LAST:event_buttonAceptarAsignaturaActionPerformed

    private void textFieldConvocatoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldConvocatoriaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldConvocatoriaActionPerformed

    private void buttonCancelarAsignaturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCancelarAsignaturaActionPerformed
        // TODO add your handling code here:

        this.activarDesactivarEdicionBotonesAsignaturas(false);

        this.borrarTextFieldAsignaturas();

    }//GEN-LAST:event_buttonCancelarAsignaturaActionPerformed

    private void jTable3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable3MouseClicked
        // TODO add your handling code here:

        int i = jTable3.getSelectedRow();

        if (i >= 0) {
            mostrarAtributosAsignatura(i);
        }

    }//GEN-LAST:event_jTable3MouseClicked

    private void buttonIngresarAsignaturaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonIngresarAsignaturaMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonIngresarAsignaturaMouseClicked

    private void buttonIngresarAsignaturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonIngresarAsignaturaActionPerformed
        // TODO add your handling code here:

        this.activarDesactivarEdicionBotonesAsignaturas(true);

        this.setActivar_ingresar_asignaturas(true);

    }//GEN-LAST:event_buttonIngresarAsignaturaActionPerformed

    private void buttonModificarAsignaturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonModificarAsignaturaActionPerformed
        // TODO add your handling code here:

        this.activarDesactivarEdicionBotonesAsignaturas(true);

        this.setActivar_modificar_asignaturas(true);

    }//GEN-LAST:event_buttonModificarAsignaturaActionPerformed

    private void buttonBorrarProfesoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonBorrarProfesoresActionPerformed
        // TODO add your handling code here:

        this.setActivar_eliminar_profesores(true);

        this.activarDesactivarEdicionBotonesProfesores(true);

    }//GEN-LAST:event_buttonBorrarProfesoresActionPerformed

    private void buttonAceptarProfesoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAceptarProfesoresActionPerformed
        // TODO add your handling code here:

        String contenido_tabla[][] = new String[controlador_profesores.getArray_profesores().size()][5];

        if (isActivar_ingresar_profesores()) {

            Profesores profesor = new Profesores(Integer.valueOf(textFieldCod_prof.getText()), textFieldNombreProf.getText(), textFieldEstudios.getText(), textFieldRango.getText(), textFieldGenero.getText(), Integer.valueOf((String) jComboBox2.getSelectedItem()));

            controlador_profesores.insertarProfesor(profesor);

            contenido_tabla = controlador_profesores.introducirProfesorEnMatriz();

            try {
                controlador_profesores.GuardarProfesoresFichero();
            } catch (IOException ex) {
                Logger.getLogger(ApartadoGrafico.class.getName()).log(Level.SEVERE, null, ex);
            }

            this.mostrarTablaProfesores(contenido_tabla);

            this.setActivar_ingresar_profesores(false);

            this.borrarTextFieldProfesores();

            this.activarDesactivarEdicionBotonesProfesores(false);

        } else if (isActivar_modificar_profesores()) {

            int i = jTable4.getSelectedRow();

            this.controlador_profesores.getProfesoresDeArray(i).setCod_prof(Integer.valueOf(textFieldCod_prof.getText()));
            this.controlador_profesores.getProfesoresDeArray(i).setNombre(textFieldNombreProf.getText());
            this.controlador_profesores.getProfesoresDeArray(i).setEstudios(textFieldEstudios.getText());
            this.controlador_profesores.getProfesoresDeArray(i).setRangos(textFieldRango.getText());
            this.controlador_profesores.getProfesoresDeArray(i).setGenero(textFieldGenero.getText());
            this.controlador_profesores.getProfesoresDeArray(i).setCod_colegio(Integer.valueOf((String) jComboBox2.getSelectedItem()));

            contenido_tabla = controlador_profesores.introducirProfesorEnMatriz();

            try {
                controlador_profesores.GuardarProfesoresFichero();
            } catch (IOException ex) {
                Logger.getLogger(ApartadoGrafico.class.getName()).log(Level.SEVERE, null, ex);
            }

            this.mostrarTablaProfesores(contenido_tabla);

            this.setActivar_modificar_profesores(false);

            this.borrarTextFieldProfesores();

            this.activarDesactivarEdicionBotonesProfesores(false);
        } else if (isActivar_eliminar_profesores()) {

            int i = jTable4.getSelectedRow();

            boolean aux = this.buscarFKEnAsignaturas(i);

            if (aux == false) {

                
                this.controlador_profesores.getArray_profesores().remove(i);
                
                    
                

                try {
                    controlador_profesores.GuardarProfesoresFichero();
                } catch (IOException ex) {
                    Logger.getLogger(ApartadoGrafico.class.getName()).log(Level.SEVERE, null, ex);
                }

                
            } else {
                JOptionPane.showMessageDialog(this, "Lo sentimos...No puedes eliminar un profesor con asignaturas previamente asignadas");
            }
            
            contenido_tabla = controlador_profesores.introducirProfesorEnMatriz();
            this.mostrarTablaProfesores(contenido_tabla);

            this.mostrarTablaProfesores(contenido_tabla);

            this.setActivar_eliminar_profesores(false);

            this.borrarTextFieldProfesores();

            this.activarDesactivarEdicionBotonesProfesores(false);
        }

        jComboBoxAsignaturas.removeAllItems();

        CaptarYActualizarComboBoxCod_prof();

    }//GEN-LAST:event_buttonAceptarProfesoresActionPerformed

    private void textFieldCod_profActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldCod_profActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldCod_profActionPerformed

    private void buttonCancelarProfesoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCancelarProfesoresActionPerformed
        // TODO add your handling code here:

        this.activarDesactivarEdicionBotonesProfesores(false);

        this.borrarTextFieldProfesores();

    }//GEN-LAST:event_buttonCancelarProfesoresActionPerformed

    private void jTable4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable4MouseClicked
        // TODO add your handling code here:

        int i = jTable4.getSelectedRow();

        if (i >= 0) {
            mostrarAtributosProfesores(i);
        }

    }//GEN-LAST:event_jTable4MouseClicked

    private void buttonIngresarProfesoresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonIngresarProfesoresMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonIngresarProfesoresMouseClicked


    private void buttonIngresarProfesoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonIngresarProfesoresActionPerformed
        // TODO add your handling code here:
        this.setActivar_ingresar_profesores(true);

        this.activarDesactivarEdicionBotonesProfesores(true);
    }//GEN-LAST:event_buttonIngresarProfesoresActionPerformed

    private void buttonModificarProfesoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonModificarProfesoresActionPerformed
        // TODO add your handling code here:

        this.setActivar_modificar_profesores(true);

        this.activarDesactivarEdicionBotonesProfesores(true);

    }//GEN-LAST:event_buttonModificarProfesoresActionPerformed

    private void jTabbedPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTabbedPane1MouseClicked

    public void mostrarTablaColegio(String contenido_tabla[][]) {

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
                contenido_tabla,
                new String[]{
                    "Cod_colegios", "Nombre"
                }
        ));
    }

    public void mostrarTablaProfesores(String contenido_tabla[][]) {

        jTable4.setModel(new javax.swing.table.DefaultTableModel(
                contenido_tabla,
                new String[]{
                    "Cod_prof", "Nombre"
                }
        ));
    }

    public void mostrarTablaAsignaturas(String contenido_tabla[][]) {

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
                contenido_tabla,
                new String[]{
                    "Cod_asig", "Convocatoria"
                }
        ));
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ApartadoGrafico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ApartadoGrafico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ApartadoGrafico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ApartadoGrafico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new ApartadoGrafico().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(ApartadoGrafico.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(ApartadoGrafico.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ParserConfigurationException ex) {
                    Logger.getLogger(ApartadoGrafico.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SAXException ex) {
                    Logger.getLogger(ApartadoGrafico.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonAceptar;
    private javax.swing.JButton buttonAceptarAsignatura;
    private javax.swing.JButton buttonAceptarProfesores;
    private javax.swing.JButton buttonBorrar;
    private javax.swing.JButton buttonBorrarAsignatura;
    private javax.swing.JButton buttonBorrarProfesores;
    private javax.swing.JButton buttonCancelar;
    private javax.swing.JButton buttonCancelarAsignatura;
    private javax.swing.JButton buttonCancelarProfesores;
    private javax.swing.JButton buttonIngresar;
    private javax.swing.JButton buttonIngresarAsignatura;
    private javax.swing.JButton buttonIngresarProfesores;
    private javax.swing.JButton buttonModificar;
    private javax.swing.JButton buttonModificarAsignatura;
    private javax.swing.JButton buttonModificarProfesores;
    public javax.swing.JComboBox<String> jComboBox2;
    public javax.swing.JComboBox<String> jComboBoxAsignaturas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTable jTable4;
    private javax.swing.JTextField jTextFieldFKCod_colegio;
    private javax.swing.JTextField jTextFieldFKCod_prof;
    private javax.swing.JLabel labelCod_colegio;
    private javax.swing.JLabel labelCod_colegio1;
    private javax.swing.JLabel labelCod_colegio2;
    private javax.swing.JLabel labelDireccion;
    private javax.swing.JLabel labelDireccion1;
    private javax.swing.JLabel labelDireccion2;
    private javax.swing.JLabel labelEsPublico;
    private javax.swing.JLabel labelEsPublico1;
    private javax.swing.JLabel labelEsPublico2;
    private javax.swing.JLabel labelNombre;
    private javax.swing.JLabel labelNombre1;
    private javax.swing.JLabel labelNombre2;
    private javax.swing.JLabel labelTieneFP;
    private javax.swing.JLabel labelTieneFP1;
    private javax.swing.JLabel labelTieneFP2;
    private javax.swing.JTextField textFieldCod_asig;
    private javax.swing.JTextField textFieldCod_colegio;
    private javax.swing.JTextField textFieldCod_prof;
    private javax.swing.JTextField textFieldConvocatoria;
    private javax.swing.JTextField textFieldCurso;
    private javax.swing.JTextField textFieldDireccion;
    private javax.swing.JTextField textFieldEsPublico;
    private javax.swing.JTextField textFieldEstudios;
    private javax.swing.JTextField textFieldGenero;
    private javax.swing.JTextField textFieldNombre;
    private javax.swing.JTextField textFieldNombreAsignatura;
    private javax.swing.JTextField textFieldNombreProf;
    private javax.swing.JTextField textFieldRango;
    private javax.swing.JTextField textFieldTieneFP;
    private javax.swing.JTextField textFieldTipo;
    // End of variables declaration//GEN-END:variables

    public boolean isActivar_ingresar() {
        return activar_ingresar;
    }

    public boolean isActivar_modificar() {
        return activar_modificar;
    }

    public void setActivar_ingresar_profesores(boolean activar_ingresar_profesores) {
        this.activar_ingresar_profesores = activar_ingresar_profesores;
    }

    public void setActivar_modificar_profesores(boolean activar_modificar_profesores) {
        this.activar_modificar_profesores = activar_modificar_profesores;
    }

    public void setActivar_eliminar_profesores(boolean activar_eliminar_profesores) {
        this.activar_eliminar_profesores = activar_eliminar_profesores;
    }

    public boolean isActivar_ingresar_profesores() {
        return activar_ingresar_profesores;
    }

    public boolean isActivar_modificar_profesores() {
        return activar_modificar_profesores;
    }

    public boolean isActivar_eliminar_profesores() {
        return activar_eliminar_profesores;
    }
}
