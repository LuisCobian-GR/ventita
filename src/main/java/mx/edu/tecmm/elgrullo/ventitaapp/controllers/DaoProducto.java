package mx.edu.tecmm.elgrullo.ventitaapp.controllers;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import mx.edu.tecmm.elgrullo.ventitaapp.models.Producto;

/**
 * Tareas o transacciones con los datos 
 * @author coby_
 */
public class DaoProducto {
    
    /**
     * Metodo que permite modificar los valores del producto 
     * @param producto datos del producto
     * @return 
     */
    public static boolean update(Producto producto){
        var isSuccess = false; 
        var em = ConnectionService.getEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(producto); 
            em.getTransaction().commit();
            isSuccess = true; 
        } catch (Exception e) {
            em.getTransaction().rollback();
            isSuccess = false; 
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        } finally{
            em.close();
            em.getEntityManagerFactory().close();
        }        
        return isSuccess;
    }
    
    /**
     * Metodo que sirve para buscar un producto 
     * @param id clave del producto 
     * @return 
     */
    public static Producto find(long id){
        Producto producto = null; 
        var em = ConnectionService.getEntityManager(); 
        try {
            producto = em.find(Producto.class, id);
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        } finally{
            em.close();
            em.getEntityManagerFactory().close();
        }        
        return producto;
    }
    
    
    /**
     * Metodo para agregar un nuevo producto a la base de datos
     * @param producto es el objeto con los valores
     * @return 
     */
    public static boolean add(Producto producto){
        var isSuccess = false;         
        var em = ConnectionService.getEntityManager();
        try {           
            em.getTransaction().begin();
            em.persist(producto);
            em.getTransaction().commit();
            isSuccess = true;
        } catch (Exception e) {
            em.getTransaction().rollback();
            isSuccess = false; 
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        }finally{
            em.close();
            em.getEntityManagerFactory().close();
        }        
        
        return isSuccess;
    }
    
    /**
     * Metodo para traerme todos los productos de la base de datos 
     * @return 
     */
    public static List<Producto> findAll(){
        var em = ConnectionService.getEntityManager(); 
        List<Producto> listaProductos; 
        try {
            var query = em.createQuery("SELECT p FROM Producto p WHERE p.estaActivo", Producto.class);
            listaProductos = query.getResultList();
        } catch (Exception e) {
            listaProductos = new ArrayList<>();
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        } finally{
            em.close();
            em.getEntityManagerFactory().close();
        }        
        return listaProductos;
    }
    
    
    public static Producto getByCodigoBarras(String codigo) {
        Producto producto = null;
        var em = ConnectionService.getEntityManager();

        try {
            TypedQuery<Producto> query = em.createQuery(
                "SELECT p FROM Producto p WHERE p.codigobarras = :codigo AND p.estaActivo",
                Producto.class
            );
            query.setParameter("codigo", codigo);

            producto = query.getSingleResult(); 
        } catch (NoResultException ex) {
            producto = null; 
        } catch (Exception ex) {
            System.out.println("ERROR: " + ex.getMessage());
            ex.printStackTrace();
        } finally {
            em.close();
        }

        return producto;
    }
    
}
