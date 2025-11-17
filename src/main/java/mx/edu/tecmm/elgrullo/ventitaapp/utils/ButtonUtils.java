/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.edu.tecmm.elgrullo.ventitaapp.utils;

import java.awt.Color;
import javax.swing.JButton;

/**
 *
 * @author coby_
 */
public class ButtonUtils {
    
    
    /**
     * Metodo que permite cambiar el color de un boton
     * @param button boton que cambia de color
     * @param back color del fondo del boton
     * @param fore color de texto del boton 
     */
    public static void setColorButton(JButton button, Color back, Color fore){
        button.setBackground(back);
        button.setForeground(fore);
    }
    
}
