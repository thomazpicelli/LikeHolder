package com.br.lp3.sessionbeans;

import com.br.lp3.DAO.GenericDAO;
import com.br.lp3.entities.Evento;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateful;

/**
 *
 * @author Thomaz
 */
@Stateful
public class EventoManagerSB implements EventoManagerSBLocal {
    /*
    @EJB
    private LoginManagerSBLocal loginManagerSB;
    @EJB
    private ProducerSBLocal producerSB;
    */

    @Override
    public List<Evento> SearchEvento(int cdUsuario) {
        List<Evento> eventos = new ArrayList<>();
        try {
            Registry registro = LocateRegistry.getRegistry("localhost", 1099);
            GenericDAO servico = (GenericDAO) registro.lookup("EventoDAO");
            eventos = servico.readById(cdUsuario);
            
            /*
            List<Usuario> lista = loginManagerSB.buscarUsuarios();
            for (Usuario usuario : lista) {
                if (usuario.getCdUsuario().equals(cdUsuario)) {
                    try {
                        producerSB.sendMessage(usuario.getNmUsuario() + " fez uma busca por Evento.");
                    } catch (JMSException ex) {
                        System.out.println(ex.getMessage());
                    }
                }
            }
            */
        } catch (RemoteException | NotBoundException ex) {
            System.out.println(ex.getMessage());
        }
        return eventos;
    }

    @Override
    public void SaveEvento(int cdUsuario, Evento evento) {
        try {
            Registry registro = LocateRegistry.getRegistry("localhost", 1099);
            GenericDAO servico = (GenericDAO) registro.lookup("EventoDAO");
            servico.insert(new Evento(cdUsuario, evento.getDcId(), evento.getDcUrl(), evento.getDcTicket(), evento.getDcLocal(), evento.getDcCidade()));
            /*
            List<Usuario> lista = loginManagerSB.buscarUsuarios();
            for (Usuario usuario : lista) {
                if (usuario.getCdUsuario().equals(cdUsuario)) {
                    try {
                        producerSB.sendMessage(usuario.getNmUsuario() + " adicionou um Evento à sua lista de interesses.");
                    } catch (JMSException ex) {
                        System.out.println(ex.getMessage());
                    }
                }
            }
            */
        } catch (RemoteException | NotBoundException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
