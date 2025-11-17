
package mx.edu.tecmm.elgrullo.ventitaapp.utils;

import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.JTableHeader;
import static mx.edu.tecmm.elgrullo.ventitaapp.utils.ColorApp.BACKGROUND_COMPONENTS;
import static mx.edu.tecmm.elgrullo.ventitaapp.utils.ColorApp.PRIMARY_ACCENT;
import static mx.edu.tecmm.elgrullo.ventitaapp.utils.ColorApp.PRIMARY_COLOR;
import static mx.edu.tecmm.elgrullo.ventitaapp.utils.ColorApp.PRIMARY_LIGHT_TEXT;

/**
 * Metodo que utilizare para poder trabajar con metodos comunes de las tablas
 * @author coby_
 */
public class TableUtils {
    
    /**
     * Metodo que configura propiedades genericas de las tablas
     * @param table tabla que se configurara
     */
    public static void configTable(JTable table){
        table.setBackground(BACKGROUND_COMPONENTS);
        table.setForeground(PRIMARY_COLOR);
        table.setFont(new Font("Tahoma", Font.PLAIN, 16));
        table.setRowHeight(30);
         
        // selection 
        table.setSelectionBackground(PRIMARY_ACCENT); // azul intermedio
        table.setSelectionForeground(PRIMARY_LIGHT_TEXT);
        
        table.setShowGrid(false);
        table.setIntercellSpacing(new Dimension(0, 0));
        
        JTableHeader header = table.getTableHeader();
        header.setFont(new Font("Tahoma", Font.BOLD, 16));
        header.setBackground(PRIMARY_COLOR); // azul noche
        header.setForeground(PRIMARY_LIGHT_TEXT);
        
        header.setOpaque(true);

        
    }
}
