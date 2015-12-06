package com.br.lp3.DAO;

import com.br.lp3.entities.Artista;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Lucas Brasilio dos Santos
 */
public class ArtistaDAO extends UnicastRemoteObject implements GenericDAO<Artista> {

    public ArtistaDAO() throws RemoteException {
    }

    @Override
    public Boolean insert(Artista t) throws RemoteException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("LikeHolderServerPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(t);
        em.getTransaction().commit();        
        return Boolean.TRUE;
    }

    @Override
    public List<Artista> read() throws RemoteException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("LikeHolderServerPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        List<Artista> interesses = em.createQuery("SELECT i FROM Artista i").getResultList();
        em.getTransaction().commit();
        return interesses;
    }

    @Override
    public Boolean update(Artista t) throws RemoteException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("LikeHolderServerPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(t);
        em.getTransaction().commit();        
        return Boolean.TRUE;
    }

    @Override
    public Boolean delete(Artista t) throws RemoteException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("LikeHolderServerPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.remove(t);
        em.getTransaction().commit();        
        return Boolean.TRUE;
    }

    @Override
    public List<Artista> readById(int id) throws RemoteException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("LikeHolderServerPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        List<Artista> interesses = em.createNamedQuery("Artista.findByCdUsuario").setParameter("cdUsuario", id).getResultList();
        em.getTransaction().commit();
        return interesses;
    }
    
}
