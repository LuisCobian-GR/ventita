/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package mx.edu.tecmm.elgrullo.ventitaapp;

import javax.swing.JFrame;
import javax.swing.UIManager;
import mx.edu.tecmm.elgrullo.ventitaapp.vistas.App;

/**
 * Metodo que permite inicializar el programa 
 * @author coby_
 */
public class VentitaApp {

    public static void main(String[] args) {
        
        UIManager.put("OptionPane.yesButtonText", "Sí");
        UIManager.put("OptionPane.noButtonText", "No");
        UIManager.put("OptionPane.cancelButtonText", "Cancelar");
        UIManager.put("OptionPane.okButtonText", "Aceptar");
        
        java.awt.EventQueue.invokeLater(() -> {
            var app = new App("Luis Cobián"); 
            app.setExtendedState(JFrame.MAXIMIZED_BOTH); 
            app.setVisible(true);
            }
        );
    }
}
