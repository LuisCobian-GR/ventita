/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.edu.tecmm.elgrullo.ventitaapp.vistas.dialogs;

import java.awt.Frame;
import mx.edu.tecmm.elgrullo.ventitaapp.controllers.DaoProducto;
import mx.edu.tecmm.elgrullo.ventitaapp.models.Producto;

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
        var producto = new Producto(); 
        producto.setCodigobarras(codebar);
        producto.setDescripcion(description);
        producto.setPrecio(price); 
        producto.setEstaActivo(true);
        System.out.println(producto);
        var res = DaoProducto.add(producto);
        return res;
    }
    
    
    
}
