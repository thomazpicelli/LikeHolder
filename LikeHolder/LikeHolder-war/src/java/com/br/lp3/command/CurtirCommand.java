package com.br.lp3.command;

import com.br.lp3.APIConsummer.SpotifyManagerSBLocal;
import com.br.lp3.entities.Artista;
import com.br.lp3.entities.Evento;
import com.br.lp3.entities.Musica;
import com.br.lp3.entities.Usuario;
import com.br.lp3.sessionbeans.ArtistaManagerSBLocal;
import com.br.lp3.sessionbeans.EventoManagerSBLocal;
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
public class CurtirCommand implements Command{
    EventoManagerSBLocal eventoManagerSB = lookupEventoManagerSBLocal();
    MusicaManagerSBLocal musicaManagerSB = lookupMusicaManagerSBLocal();
    ArtistaManagerSBLocal artistaManagerSB = lookupArtistaManagerSBLocal();
    SpotifyManagerSBLocal spotifyManagerSB = lookupSpotifyManagerSBLocal();
    
    private String id;

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response, String operacao) {
        id = request.getParameter("id");
        Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");
        
        
        switch (operacao){
            case "artista":        
                Artista a = spotifyManagerSB.getArtista(id);
                artistaManagerSB.SaveArtista(usuario.getCdUsuario(), a);
                request.getSession().setAttribute("artista", artistaManagerSB.SearchArtista(usuario.getCdUsuario()));
                try {
                    response.sendRedirect("artist.jsp");
                } catch (IOException ex) {
                    Logger.getLogger(BuscaCommand.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            case "musica":
                Musica m = spotifyManagerSB.getMusica(id);
                musicaManagerSB.saveMusica(usuario.getCdUsuario(), m);
                request.getSession().setAttribute("musica", musicaManagerSB.SearchMusica(usuario.getCdUsuario()));
                try {
                    response.sendRedirect("music.jsp");
                } catch (IOException ex) {
                    Logger.getLogger(BuscaCommand.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            case "evento":
                List<Evento> ev = (List)request.getSession().getAttribute("buscaEvento");
                for (Evento ev1 : ev) {
                    if(ev1.getDcId().equals(request.getParameter("id")))
                        eventoManagerSB.SaveEvento(usuario.getCdUsuario(), ev1);
                }
                request.getSession().setAttribute("evento", eventoManagerSB.SearchEvento(usuario.getCdUsuario()));
                try {
                    response.sendRedirect("events.jsp");
                } catch (IOException ex) {
                    Logger.getLogger(BuscaCommand.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            default:
                break;
        }
    }

    private SpotifyManagerSBLocal lookupSpotifyManagerSBLocal() {
        try {
            Context c = new InitialContext();
            return (SpotifyManagerSBLocal) c.lookup("java:global/LikeHolder/LikeHolder-ejb/SpotifyManagerSB!com.br.lp3.APIConsummer.SpotifyManagerSBLocal");
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
