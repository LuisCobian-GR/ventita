package mx.edu.tecmm.elgrullo.ventitaapp.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Clase que me permite mapaer los atributos o caracteristicas del objeto almacenar
 * @author coby_
 */
@Entity
public class Producto {
    
    @Id
    @GeneratedValue
    private long id; 
    private String codigobarras; 
    private String descripcion; 
    private double precio; 
    private boolean estaActivo;
    
    

    public Producto() {
    }
    
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCodigobarras() {
        return codigobarras;
    }

    public void setCodigobarras(String codigobarras) {
        this.codigobarras = codigobarras;
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

    @Override
    public String toString() {
        return "Producto{" + "id=" + id + ", codigobarras=" + codigobarras + ", descripcion=" + descripcion + ", precio=" + precio + '}';
    }

    /**
     * Este solo lo utilizo para cuando me vaya a traer elementos para mostrar en la tabla 
     * @return 
     */
    public String[] toArray(){
        String[] array = new String[4]; 
        array[0] = "" + id; 
        array[1] = codigobarras; 
        array[2] = descripcion; 
        array[3] = String.format("%.2f",precio);
        return array;
    }

    public boolean isEstaActivo() {
        return estaActivo;
    }

    public void setEstaActivo(boolean estaActivo) {
        this.estaActivo = estaActivo;
    }
    
    
}
