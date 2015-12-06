package com.br.lp3.DAO;

import com.br.lp3.entities.Evento;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Thomaz
 */
public class EventoDAO extends UnicastRemoteObject implements GenericDAO<Evento> {

    public EventoDAO() throws RemoteException {
    }

    @Override
    public Boolean insert(Evento t) throws RemoteException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("LikeHolderServerPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(t);
        em.getTransaction().commit();        
        return Boolean.TRUE;
    }

    @Override
    public List<Evento> read() throws RemoteException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("LikeHolderServerPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        List<Evento> interesses = em.createQuery("SELECT i FROM Evento i").getResultList();
        em.getTransaction().commit();
        return interesses;
    }

    @Override
    public Boolean update(Evento t) throws RemoteException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("LikeHolderServerPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(t);
        em.getTransaction().commit();        
        return Boolean.TRUE;
    }

    @Override
    public Boolean delete(Evento t) throws RemoteException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("LikeHolderServerPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.remove(t);
        em.getTransaction().commit();        
        return Boolean.TRUE;
    }

    @Override
    public List<Evento> readById(int id) throws RemoteException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("LikeHolderServerPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        List<Evento> interesses = em.createNamedQuery("Evento.findByCdUsuario").setParameter("cdUsuario", id).getResultList();
        em.getTransaction().commit();
        return interesses;
    }
    
}
