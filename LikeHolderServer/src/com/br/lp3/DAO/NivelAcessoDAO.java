package com.br.lp3.DAO;

import com.br.lp3.entities.NivelAcesso;
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
public class NivelAcessoDAO extends UnicastRemoteObject implements GenericDAO<NivelAcesso> {

    public NivelAcessoDAO() throws RemoteException {
    }

    @Override
    public Boolean insert(NivelAcesso t) throws RemoteException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("LikeHolderServerPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(t);
        em.getTransaction().commit();        
        return Boolean.TRUE;
    }

    @Override
    public List<NivelAcesso> read() throws RemoteException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("LikeHolderServerPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        List<NivelAcesso> nivelAcesso = em.createQuery("SELECT n FROM NivelAcesso n").getResultList();
        em.getTransaction().commit();
        return nivelAcesso;
    }

    @Override
    public Boolean update(NivelAcesso t) throws RemoteException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("LikeHolderServerPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(t);
        em.getTransaction().commit();        
        return Boolean.TRUE;
    }

    @Override
    public Boolean delete(NivelAcesso t) throws RemoteException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("LikeHolderServerPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.remove(t);
        em.getTransaction().commit();        
        return Boolean.TRUE;
    }

    @Override
    public List<NivelAcesso> readById(int id) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
