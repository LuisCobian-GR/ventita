/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.edu.tecmm.elgrullo.ventitaapp.controllers;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import mx.edu.tecmm.elgrullo.ventitaapp.models.Venta;

/**
 * 
 * @author coby_
 */
public class DaoVenta {
    
    public static boolean register(Venta venta){
         var isSuccess = false; 
        var em = ConnectionService.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(venta); 
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
     * Metodo que permita traer el ultimo Id que tiene la plataforma
     * @return ultimo Id
     */
    public static Long getLastId() {
        Long lastId = 0L;
        var em = ConnectionService.getEntityManager();

        try {
            TypedQuery<Long> query = em.createQuery("SELECT MAX(v.id) FROM Venta v",Long.class);
            Long result = query.getSingleResult();
            if(result!=null){
                lastId = result;
            }
        } catch (Exception ex) {
            System.out.println("ERROR: " + ex.getMessage());
            ex.printStackTrace();
        } finally {
            em.close();
            em.getEntityManagerFactory().close();
        }
        return lastId;  
    }
    
    /**
     * Metodo que permite traer la venta al momento de mandar su impresión 
     * @param idVenta
     * @return 
     */
    public static Venta getVentaConDetalles(long idVenta) {
        Venta venta = null;
        var em = ConnectionService.getEntityManager();

        try {
            TypedQuery<Venta> query = em.createQuery(
                "SELECT DISTINCT v FROM Venta v JOIN FETCH v.detalles WHERE v.id = :idVenta",
                Venta.class
            );
            query.setParameter("idVenta", idVenta);

            venta = query.getSingleResult();

        } catch (NoResultException ex) {
            venta = null;
        } catch (Exception ex) {
            System.out.println("ERROR: " + ex.getMessage());
            ex.printStackTrace();
        } finally {
            em.close();
        }

        return venta;
    }
    
}
