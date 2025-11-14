package mx.edu.tecmm.elgrullo.ventitaapp.utils;

import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *  Esta clase la utilizo para poder simplificar el codigo para el manejo y la manipulacion de las imagenes 
 * @author coby_
 */
public class ImageUtils {
    
    /**
     * Metodo que me trae el icono para poner en componentes
     * @param context clase que hace la llamada para poder encontrar los archivos
     * @param namePicture nombre del archivo con la extensión 
     * @return retorna un ImageIcon 
     */
    public static ImageIcon getImageIcon(Class<?> context,  String namePicture){
        ImageIcon icon = new ImageIcon(context.getResource("/images/" + namePicture));
        return icon; 
    } 
    
    /**
     * Metodo que me trae el icono para poner en componentes escalado 
     * @param context  clase que hace la llamada para poder encontrar los archivos
     * @param namePicture nombre del archivo con la extensión 
     * @param width anchura en la cual se dimensionara la imagen 
     * @param height altura en la cual se dimensionara la clase
     * @return 
     */
    public static ImageIcon getImageIcon(Class<?> context,  String namePicture, int width, int height){
        ImageIcon icon = getImageIcon(context, namePicture);
        Image scaledImage = icon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
        icon = new ImageIcon(scaledImage);
        return icon; 
    } 
    
    
}
