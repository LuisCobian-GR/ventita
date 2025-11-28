/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.edu.tecmm.elgrullo.ventitaapp.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author coby_
 */
@Entity
public class DetalleVentas {
    
    @Id
    @GeneratedValue
    private long id; 
    private String codebar;
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
        product[0] = codebar; 
        product[1] = "" + cant; 
        product[2] = descripcion; 
        product[3] = String.format("%.2f", price);
        return product;
    }

    

    public String getCodebar() {
        return codebar;
    }

    public void setCodebar(String codebar) {
        this.codebar = codebar;
    }

    @Override
    public String toString() {
        return "DetalleVentas{" + "id=" + id + ", codebar=" + codebar + ", cant=" + cant + ", descripcion=" + descripcion + ", price=" + price +  '}';
    }
    
    
}
