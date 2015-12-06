package com.br.lp3.sessionbeans;

import com.br.lp3.entities.Usuario;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Lucas Brasilio dos Santos
 */
@Local
public interface LoginManagerSBLocal {

    public List<Usuario> buscarUsuarios();

    public Usuario auth(String username, String password);
}
