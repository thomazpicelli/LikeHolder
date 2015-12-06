package com.br.lp3.DAO;

import com.br.lp3.entities.Usuario;
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
public class UsuarioDAO extends UnicastRemoteObject implements GenericDAO<Usuario> {

    public UsuarioDAO() throws RemoteException {
    }

    @Override
    public Boolean insert(Usuario t) throws RemoteException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("LikeHolderServerPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(t);
        em.getTransaction().commit();        
        return Boolean.TRUE;        
    }

    @Override
    public List<Usuario> read() throws RemoteException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("LikeHolderServerPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        List<Usuario> usuarios = em.createQuery("SELECT u from Usuario u").getResultList();
        em.getTransaction().commit();
        return usuarios;
    }

    @Override
    public Boolean update(Usuario t) throws RemoteException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("LikeHolderServerPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(t);
        em.getTransaction().commit();        
        return Boolean.TRUE;
    }

    @Override
    public Boolean delete(Usuario t) throws RemoteException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("LikeHolderServerPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.remove(t);
        em.getTransaction().commit();        
        return Boolean.TRUE;
    }

    @Override
    public List<Usuario> readById(int id) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
