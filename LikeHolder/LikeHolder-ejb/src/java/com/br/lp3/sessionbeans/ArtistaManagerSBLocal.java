package com.br.lp3.sessionbeans;

import com.br.lp3.entities.Artista;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Thomaz
 */
@Local
public interface ArtistaManagerSBLocal {

    List<Artista> SearchArtista(int id);

    void SaveArtista(int cdUsuario, Artista artista);
    
}
