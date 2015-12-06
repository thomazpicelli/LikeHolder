package com.br.lp3.sessionbeans;

import com.br.lp3.DAO.GenericDAO;
import com.br.lp3.entities.Artista;
import com.br.lp3.entities.Usuario;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateful;
import javax.jms.JMSException;

/**
 *
 * @author Thomaz
 */
@Stateful
public class ArtistaManagerSB implements ArtistaManagerSBLocal {
    /*
    @EJB
    private LoginManagerSBLocal loginManagerSB;
    @EJB
    private ProducerSBLocal producerSB;
    */

    @Override
    public List<Artista> SearchArtista(int cd_usuario) {
        List<Artista> artistas = new ArrayList<>();
        try {
            Registry registro = LocateRegistry.getRegistry("localhost", 1099);
            GenericDAO servico = (GenericDAO) registro.lookup("ArtistaDAO");
            artistas = servico.readById(cd_usuario);
            
            /*
            List<Usuario> lista = loginManagerSB.buscarUsuarios();
            for (Usuario usuario : lista) {
                if (usuario.getCdUsuario().equals(cd_usuario)) {
                    try {
                        producerSB.sendMessage(usuario.getNmUsuario() + " fez uma busca por Artista.");
                    } catch (JMSException ex) {
                        System.out.println(ex.getMessage());
                    }
                }
            }
            */
        } catch (RemoteException | NotBoundException ex) {
            System.out.println(ex.getMessage());
        }
        return artistas;
    }

    @Override
    public void SaveArtista(int cdUsuario, Artista artista) {
        try {
            Registry registro = LocateRegistry.getRegistry("localhost", 1099);
            GenericDAO servico = (GenericDAO) registro.lookup("ArtistaDAO");
            servico.insert(new Artista(cdUsuario, artista.getDcId(), artista.getDcUrl(), artista.getNmArtista(), artista.getCdFollower(), artista.getDcImg(), artista.getCdHeight(), artista.getCdWidth()));
            
            /*
            List<Usuario> lista = loginManagerSB.buscarUsuarios();
            for (Usuario usuario : lista) {
                if (usuario.getCdUsuario().equals(cdUsuario)) {
                    try {
                        producerSB.sendMessage(usuario.getNmUsuario() + " adicionou um Artista à sua lista de interesses.");
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
