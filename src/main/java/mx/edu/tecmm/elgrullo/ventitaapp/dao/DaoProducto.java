/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.edu.tecmm.elgrullo.ventitaapp.dao;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.TypedQuery;
import mx.edu.tecmm.elgrullo.ventitaapp.models.Producto;

/**
 *
 * @author coby_
 */
public class DaoProducto {
    
    public static boolean update(Producto producto){
        var isSuccess = false; 
        var em = ConnectionService.getEntityManager(); 
        try {
            em.getTransaction().begin();
            if(producto.getId() == 0)
                em.persist(producto);            
            else 
                em.merge(producto);
            em.getTransaction().commit();            
            isSuccess = true; 
        } catch (Exception ex) {
            System.out.println("ERROR: " + ex.getMessage());
            ex.printStackTrace();
            em.getTransaction().rollback();
            isSuccess = false; 
        } finally{
            em.close(); 
            em.getEntityManagerFactory().close();
        }
        return isSuccess;
    }
    
    public static List<Producto> findAll(){    
        var em = ConnectionService.getEntityManager(); 
        List<Producto> listaProductos; 
        try{            
            TypedQuery<Producto> query = em.createQuery("SELECT p FROM Producto p", Producto.class);
            listaProductos = query.getResultList();
        }catch(Exception ex){
            listaProductos = new ArrayList<>();
            System.out.println("ERROR: " + ex.getMessage());
            ex.printStackTrace();
        } finally{
            em.close();
            em.getEntityManagerFactory().close();
        }
       
        return listaProductos;        
    }
    
    public static String[][] toMatrixData(){
        var lista = findAll(); 
        String[][] data = new String[lista.size()][];
        int index = 0;
        for(Producto producto : lista){
            data[index] = producto.toArray();
            index++;
        }
        return data; 
    }

    public static Producto find(long id) {
        Producto producto = null;
        var em = ConnectionService.getEntityManager();

        try {
            producto = em.find(Producto.class, id);
        } catch (Exception ex) {
            System.out.println("ERROR: " + ex.getMessage());
            ex.printStackTrace();
        } finally {
            em.close();
            em.getEntityManagerFactory().close();
        }

        return producto;
    }
    
    
}
