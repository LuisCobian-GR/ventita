/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.edu.tecmm.elgrullo.ventitaapp.vistas.dialogs;

import java.awt.Frame;

/**
 * Metodo que se usara para el procedimiento de la modificacion 
 * @author coby_
 */
public class DialogUpdateProduct extends DialogUpdateProducts {

    public DialogUpdateProduct(Frame parent, boolean modal, int productId) {
        super(parent, modal);
        setTitle("Modificar Producto");
        lblTitle.setText("Modificar producto: " + productId);
        
        txtCodigoBarras.setText("Prueba");
        txtDescripcion.setText("Prueba");
        txtPrecio.setText("0.00");
    }

    @Override
    protected boolean processToProductUpdate(String codebar, String description, double price) {
        System.out.println("Es solo una prueba");
        return true;
    }
    
    
    
}
