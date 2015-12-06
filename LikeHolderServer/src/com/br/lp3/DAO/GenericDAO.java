package com.br.lp3.DAO;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author Lucas Brasilio dos Santos
 */
public interface GenericDAO<T> extends Remote {

    public Boolean insert(T t) throws RemoteException;

    public List<T> read() throws RemoteException;
    
    public List<T> readById(int id) throws RemoteException;
    
    public Boolean update(T t) throws RemoteException;

    public Boolean delete(T t) throws RemoteException;
}
