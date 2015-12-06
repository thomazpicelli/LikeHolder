package com.br.lp3.DAO;

import com.br.lp3.entities.Musica;
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
public class MusicaDAO extends UnicastRemoteObject implements GenericDAO<Musica> {

    public MusicaDAO() throws RemoteException {
    }

    @Override
    public Boolean insert(Musica t) throws RemoteException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("LikeHolderServerPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(t);
        em.getTransaction().commit();        
        return Boolean.TRUE;
    }

    @Override
    public List<Musica> read() throws RemoteException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("LikeHolderServerPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        List<Musica> interesses = em.createQuery("SELECT i FROM Musica i").getResultList();
        em.getTransaction().commit();
        return interesses;
    }

    @Override
    public Boolean update(Musica t) throws RemoteException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("LikeHolderServerPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(t);
        em.getTransaction().commit();        
        return Boolean.TRUE;
    }

    @Override
    public Boolean delete(Musica t) throws RemoteException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("LikeHolderServerPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.remove(t);
        em.getTransaction().commit();        
        return Boolean.TRUE;
    }

    @Override
    public List<Musica> readById(int id) throws RemoteException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("LikeHolderServerPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        List<Musica> interesses = em.createNamedQuery("Musica.findByCdUsuario").setParameter("cdUsuario", id).getResultList();
        em.getTransaction().commit();
        return interesses;
    }
    
}
