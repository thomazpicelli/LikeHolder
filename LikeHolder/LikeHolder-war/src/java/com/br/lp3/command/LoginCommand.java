package com.br.lp3.command;

import com.br.lp3.entities.Artista;
import com.br.lp3.entities.Evento;
import com.br.lp3.entities.Musica;
import com.br.lp3.entities.Usuario;
import com.br.lp3.sessionbeans.ArtistaManagerSBLocal;
import com.br.lp3.sessionbeans.EventoManagerSBLocal;
import com.br.lp3.sessionbeans.LoginManagerSBLocal;
import com.br.lp3.sessionbeans.MusicaManagerSBLocal;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Thomaz
 */
public class LoginCommand implements Command{
    EventoManagerSBLocal eventoManagerSB = lookupEventoManagerSBLocal();
    MusicaManagerSBLocal musicaManagerSB = lookupMusicaManagerSBLocal();
    ArtistaManagerSBLocal artistaManagerSB = lookupArtistaManagerSBLocal();
    LoginManagerSBLocal loginManagerSB = lookupLoginManagerSBLocal();
    
    private String username;
    private String password;

    
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response, String operacao) {
        username = request.getParameter("username");
        password = request.getParameter("password");
        Usuario u = loginManagerSB.auth(username, password);
        try{
            if(u != null){
                request.getSession().setAttribute("usuario", u);
                request.getSession().setAttribute("artista", CarregarArtistas(u.getCdUsuario()));
                request.getSession().setAttribute("musica", CarregarMusicas(u.getCdUsuario()));
                request.getSession().setAttribute("evento", CarregarEventos(u.getCdUsuario()));
                response.sendRedirect("home.jsp");
            }
            else
                response.sendRedirect("index.jsp");
        }catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }
    
    private List<Artista> CarregarArtistas(int cd_usuario){
        List<Artista> artistas = artistaManagerSB.SearchArtista(cd_usuario);
        return artistas;
    }
    
    private List<Musica> CarregarMusicas(int cd_usuario){
        List<Musica> musicas = musicaManagerSB.SearchMusica(cd_usuario);
        return musicas;
    }
    
    private List<Evento> CarregarEventos(int cd_usuario){
        List<Evento> eventos = eventoManagerSB.SearchEvento(cd_usuario);
        for (Evento evento : eventos) {
            System.out.println(evento.getDcCidade());
        }
        return eventos;
    }


    private LoginManagerSBLocal lookupLoginManagerSBLocal() {
        try {
            Context c = new InitialContext();
            return (LoginManagerSBLocal) c.lookup("java:global/LikeHolder/LikeHolder-ejb/LoginManagerSB!com.br.lp3.sessionbeans.LoginManagerSBLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    private ArtistaManagerSBLocal lookupArtistaManagerSBLocal() {
        try {
            Context c = new InitialContext();
            return (ArtistaManagerSBLocal) c.lookup("java:global/LikeHolder/LikeHolder-ejb/ArtistaManagerSB!com.br.lp3.sessionbeans.ArtistaManagerSBLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    private MusicaManagerSBLocal lookupMusicaManagerSBLocal() {
        try {
            Context c = new InitialContext();
            return (MusicaManagerSBLocal) c.lookup("java:global/LikeHolder/LikeHolder-ejb/MusicaManagerSB!com.br.lp3.sessionbeans.MusicaManagerSBLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    private EventoManagerSBLocal lookupEventoManagerSBLocal() {
        try {
            Context c = new InitialContext();
            return (EventoManagerSBLocal) c.lookup("java:global/LikeHolder/LikeHolder-ejb/EventoManagerSB!com.br.lp3.sessionbeans.EventoManagerSBLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
  
}
