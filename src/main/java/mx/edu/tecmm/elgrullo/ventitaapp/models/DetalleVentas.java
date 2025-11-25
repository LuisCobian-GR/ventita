/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.edu.tecmm.elgrullo.ventitaapp.models;

/**
 *
 * @author coby_
 */
public class DetalleVentas {
    
    private long id; 
    private int cant; 
    private String descripcion; 
    private double price; 

    public DetalleVentas() {
    }

    public DetalleVentas(long id, String descripcion, double price) {
        this.id = id;
        this.descripcion = descripcion;
        this.price = price;
        this.cant = 1; 
    }
    
    

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getCant() {
        return cant;
    }

    public void setCant(int cant) {
        this.cant = cant;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    
    public void dumpData() {
        int random = (int)(Math.random() * 300); 
        this.descripcion = "PRODUCTO " + random; 
        this.price = random; 
    }
    
    /**
     * Metodo que permite regresar el arreglo con los datos del producto
     * @return 
     */
    public String[] toArray(){
        String[] product = new String[4];
        product[0] = "" + id; 
        product[1] = "" + cant; 
        product[2] = descripcion; 
        product[3] = String.format("%.2f", price);
        return product;
    }
    
    
}
