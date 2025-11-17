/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.edu.tecmm.elgrullo.ventitaapp.vistas.dialogs;

import java.awt.Frame;

/**
 *
 * @author coby_
 */
public class DialogAddProduct extends DialogUpdateProducts {
    
    public DialogAddProduct(Frame parent, boolean modal) {
        super(parent, modal);
        setTitle("Nuevo Producto");
        lblTitle.setText("Agregar Producto");
    }

    @Override
    protected boolean processToProductUpdate(String codebar, String description, double price) {
        System.out.println("Se envio el valor");
        return true;
    }
    
    
    
}
