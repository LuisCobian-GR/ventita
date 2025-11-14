/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.edu.tecmm.elgrullo.ventitaapp.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author coby_
 */

@Entity
public class Producto {
    
    @Id
    @GeneratedValue
    private long id; 
    private String codebar; 
    private String descripcion; 
    private double precio;
    private boolean viable;

    public Producto() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCodebar() {
        return codebar;
    }

    public void setCodebar(String codebar) {
        this.codebar = codebar;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public boolean isViable() {
        return viable;
    }

    public void setViable(boolean viable) {
        this.viable = viable;
    }

    
    
    @Override
    public String toString() {
        return "Producto{" + "id=" + id + ", codebar=" + codebar + ", descripcion=" + descripcion + ", precio=" + precio + '}';
    }
    
    public String[] toArray(){
        String[] arreglo = new String[4]; 
        arreglo[0] = "" + id; 
        arreglo[1] = codebar; 
        arreglo[2] = descripcion; 
        arreglo[3] = String.format("%.2f", precio);
        return arreglo;
    }
    
}
