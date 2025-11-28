/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.edu.tecmm.elgrullo.ventitaapp.vistas.dialogs;

import java.awt.Frame;
import mx.edu.tecmm.elgrullo.ventitaapp.controllers.DaoProducto;
import mx.edu.tecmm.elgrullo.ventitaapp.models.Producto;

/**
 * Metodo que se usara para el procedimiento de la modificacion 
 * @author coby_
 */
public class DialogUpdateProduct extends DialogUpdateProducts {

    Producto producto;
    
    public DialogUpdateProduct(Frame parent, boolean modal, long productId) {
        super(parent, modal);
        setTitle("Modificar Producto");
        lblTitle.setText("Modificar producto: " + productId);
        
        var producto = DaoProducto.find(productId);
        
        txtCodigoBarras.setText(producto.getCodigobarras());
        txtDescripcion.setText(producto.getDescripcion());
        txtPrecio.setText(String.format("%.2f", producto.getPrecio()));
        this.producto = producto;
    }

    @Override
    protected boolean processToProductUpdate(String codebar, String description, double price) {
        producto.setCodigobarras(codebar);
        producto.setDescripcion(description);
        producto.setPrecio(price);        
        var res = DaoProducto.update(producto);         
        return res;
    }
    
    
    
}
