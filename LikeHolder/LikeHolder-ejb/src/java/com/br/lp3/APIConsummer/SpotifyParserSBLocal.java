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
public interface SpotifyParserSBLocal {

    List<Artista> ParserArtista(String content);

    List<Musica> ParseMusica(String content);

    Artista ParseGetArtista(String content);

    Musica ParseGetMusica(String content);
    
}
