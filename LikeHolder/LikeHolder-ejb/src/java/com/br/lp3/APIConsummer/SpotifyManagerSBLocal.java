package com.br.lp3.APIConsummer;

import com.br.lp3.entities.Artista;
import com.br.lp3.entities.Musica;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Thomaz
 */
@Local
public interface SpotifyManagerSBLocal {

    List<Artista> searchArtista(String artista);

    List<Musica> SearchMusica(String musica);

    Artista getArtista(String id);

    Musica getMusica(String id);
    
}
