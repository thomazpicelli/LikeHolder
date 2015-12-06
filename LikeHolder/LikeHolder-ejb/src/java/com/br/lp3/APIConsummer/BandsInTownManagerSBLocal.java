package com.br.lp3.APIConsummer;

import com.br.lp3.entities.Evento;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Thomaz
 */
@Local
public interface BandsInTownManagerSBLocal {

    List<Evento> SearchEvento(String evento);
    
}
