package mx.edu.tecmm.elgrullo.ventitaapp.controllers;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Generar el objeto que me genera las conexiones 
 * @author coby_
 */
public class ConnectionService {
    
    public static EntityManager getEntityManager(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("VentitaPU"); 
        EntityManager em = emf.createEntityManager();
        return em; 
    }
    
}
