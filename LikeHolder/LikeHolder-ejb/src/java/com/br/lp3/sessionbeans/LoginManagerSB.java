package com.br.lp3.sessionbeans;

import com.br.lp3.entities.Usuario;
import com.br.lp3.DAO.GenericDAO;
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
 * @author Lucas Brasilio dos Santos
 */
@Stateful
public class LoginManagerSB implements LoginManagerSBLocal {
    @EJB
    private ProducerSB producerSB;

    @Override
    public List<Usuario> buscarUsuarios() {
        List<Usuario> usuarios = new ArrayList<>();
        try {
            Registry registro = LocateRegistry.getRegistry("localhost", 1099);
            GenericDAO servico = (GenericDAO) registro.lookup("UsuarioDAO");
            usuarios = servico.read();
        } catch (RemoteException | NotBoundException ex) {
            System.out.println(ex.getMessage());
        }
        return usuarios;
    }

    @Override
    public Usuario auth(String username, String password) {
        List<Usuario> usuarios = buscarUsuarios();
        Usuario u = null;
        for (Usuario usuario : usuarios) {
            if (usuario.getNmUsername().equals(username) && usuario.getNmPassword().equals(password)) {
                u = usuario;
                try {
                    producerSB.sendMessage("O usuário " + usuario.getNmUsuario() + " logou no sistema.");
                } catch (JMSException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        }
        return u;
    }

}
