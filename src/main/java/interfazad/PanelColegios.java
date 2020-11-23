/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfazad;

import java.awt.Button;
import javax.swing.JPanel;

/**
 *
 * @author artur
 */
public class PanelColegios extends JPanel{
    
    private Button boton_aceptar;
    
    private JPanel panelColegios;

    public PanelColegios() {
        this.panelColegios = new JPanel();
        panelColegios.setVisible(true);
        panelColegios.setBounds(200, 200, 400, 250);
        boton_aceptar = new Button();
        this.add(boton_aceptar);
                
    }
    
    
    
    
    
}
