package com.br.lp3.sessionbeans;

import com.br.lp3.entities.Evento;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Thomaz
 */
@Local
public interface EventoManagerSBLocal {

    List<Evento> SearchEvento(int cdUsuario);

    void SaveEvento(int cdUsuario, Evento evento);
    
}
