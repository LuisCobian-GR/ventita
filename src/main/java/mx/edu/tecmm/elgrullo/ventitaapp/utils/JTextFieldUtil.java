/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.edu.tecmm.elgrullo.ventitaapp.utils;

/**
 *
 * @author coby_
 */
public class JTextFieldUtil {
    
    /**
     * Metodo comun que usara para no repetir codigo en los dos eventos de los compontes de texto
     * @param evt 
     */
    public static void convertToMayus(java.awt.event.KeyEvent evt){
        char c = evt.getKeyChar();

        if (Character.isLetter(c)) {
            evt.setKeyChar(Character.toUpperCase(c));
        }
    } 
    
}
