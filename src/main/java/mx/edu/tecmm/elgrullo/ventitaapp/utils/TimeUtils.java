/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.edu.tecmm.elgrullo.ventitaapp.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JLabel;

/**
 *
 * @author coby_
 */
public class TimeUtils {
    
    /**
     * Metodo para formatear el valor de la fecha
     * @param label 
     */
    public static void updateLabelFecha(JLabel label){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"); 
        String labelFecha = "El grullo, Jalisco " + LocalDateTime.now().format(formatter); 
        label.setText(labelFecha);
    }
    
    /**
     * Metodo para traer la fecha sin tiempo
     * @return 
     */
    public static String getDateTodayWithoutTime(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy"); 
        String date = LocalDateTime.now().format(formatter);
        return date;
    }
    
    /**
     * Metodo para traer la fecha de hoy
     * @return 
     */
    public static String getDateToday(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"); 
        String date = LocalDateTime.now().format(formatter);
        return date; 
    }
    
}
