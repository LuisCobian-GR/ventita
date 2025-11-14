/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package mx.edu.tecmm.elgrullo.ventitaapp;

import javax.swing.JFrame;
import mx.edu.tecmm.elgrullo.ventitaapp.views.App;

/**
 *
 * @author coby_
 */
public class VentitaApp {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(App.class.getName());
    
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
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
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
