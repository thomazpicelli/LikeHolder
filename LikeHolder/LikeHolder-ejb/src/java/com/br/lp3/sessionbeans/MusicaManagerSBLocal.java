/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp3.sessionbeans;

import com.br.lp3.entities.Musica;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Thomaz
 */
@Local
public interface MusicaManagerSBLocal {

    List<Musica> SearchMusica(int cd_usuario);

    void saveMusica(int cdUsuario, Musica musica);
    
}
