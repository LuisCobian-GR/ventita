/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package mx.edu.tecmm.elgrullo.ventitaapp;

import javax.swing.JFrame;
import mx.edu.tecmm.elgrullo.ventitaapp.vistas.App;

/**
 *
 * @author coby_
 */
public class VentitaApp {

    public static void main(String[] args) {
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
//            
//        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            var app = new App("Luis Cobián"); 
            app.setExtendedState(JFrame.MAXIMIZED_BOTH); 
            app.setVisible(true);
            }
        );
    }
}
