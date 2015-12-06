package com.br.lp3.DAO;

import com.br.lp3.entities.CategoriaInteresse;
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
public class CategoriaInteresseDAO extends UnicastRemoteObject implements GenericDAO<CategoriaInteresse> {

    public CategoriaInteresseDAO() throws RemoteException {
    }

    @Override
    public Boolean insert(CategoriaInteresse t) throws RemoteException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("LikeHolderServerPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(t);
        em.getTransaction().commit();        
        return Boolean.TRUE;
    }

    @Override
    public List<CategoriaInteresse> read() throws RemoteException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("LikeHolderServerPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        List<CategoriaInteresse> catInteresses = em.createQuery("SELECT c FROM CategoriaInteresse c").getResultList();
        em.getTransaction().commit();
        return catInteresses;
    }

    @Override
    public Boolean update(CategoriaInteresse t) throws RemoteException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("LikeHolderServerPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(t);
        em.getTransaction().commit();        
        return Boolean.TRUE;
    }

    @Override
    public Boolean delete(CategoriaInteresse t) throws RemoteException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("LikeHolderServerPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.remove(t);
        em.getTransaction().commit();
        return Boolean.TRUE;
    }

    @Override
    public List<CategoriaInteresse> readById(int id) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
