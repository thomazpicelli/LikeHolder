package com.br.lp3.sessionbeans;

import com.br.lp3.DAO.GenericDAO;
import com.br.lp3.entities.Artista;
import com.br.lp3.entities.Musica;
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
public class MusicaManagerSB implements MusicaManagerSBLocal {
    /*
    @EJB
    private LoginManagerSBLocal loginManagerSB;
    @EJB
    private ProducerSBLocal producerSB;
    */

    @Override
    public List<Musica> SearchMusica(int cd_usuario) {
        List<Musica> musicas = new ArrayList<>();
        try {
            Registry registro = LocateRegistry.getRegistry("localhost", 1099);
            GenericDAO servico = (GenericDAO) registro.lookup("MusicaDAO");
            musicas = servico.readById(cd_usuario);
            /*
            List<Usuario> lista = loginManagerSB.buscarUsuarios();
            for (Usuario usuario : lista) {
                if (usuario.getCdUsuario().equals(cd_usuario)) {
                    try {
                        producerSB.sendMessage(usuario.getNmUsuario() + " fez uma busca por Música.");
                    } catch (JMSException ex) {
                        System.out.println(ex.getMessage());
                    }
                }
            }
            */
        } catch (RemoteException | NotBoundException ex) {
            System.out.println(ex.getMessage());
        }
        return musicas;
    }

    @Override
    public void saveMusica(int cdUsuario, Musica musica) {
        try {
            Registry registro = LocateRegistry.getRegistry("localhost", 1099);
            GenericDAO servico = (GenericDAO) registro.lookup("MusicaDAO");
            servico.insert(new Musica(cdUsuario, musica.getDcId(), musica.getDcUrl(), musica.getDcUri(), musica.getNmMusica(), musica.getNmArtista()));
            /*
            List<Usuario> lista = loginManagerSB.buscarUsuarios();
            for (Usuario usuario : lista) {
                if (usuario.getCdUsuario().equals(cdUsuario)) {
                    try {
                        producerSB.sendMessage(usuario.getNmUsuario() + " adicionou uma Música à sua lista de interesses.");
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
