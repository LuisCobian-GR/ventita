package mx.edu.tecmm.elgrullo.ventitaapp.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author coby_
 */

@Entity
public class Venta {
    @Id
    private long id; 
    private Date fechaRegistro;
    private double total;
    
    @OneToMany(cascade = CascadeType.ALL)
    private List<DetalleVentas> detalles = new ArrayList<>();

    public Venta() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public List<DetalleVentas> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<DetalleVentas> detalles) {
        this.detalles = detalles;
    }
    
    public void addDetalle(DetalleVentas detalle) {
        this.detalles.add(detalle);
    }

    @Override
    public String toString() {
        return "Venta{" + "id=" + id + ", fechaRegistro=" + fechaRegistro + ", total=" + total + ", detalles=" + detalles + '}';
    }
    
    
    
    
}
