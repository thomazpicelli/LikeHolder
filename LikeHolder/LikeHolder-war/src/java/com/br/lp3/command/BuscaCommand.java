package com.br.lp3.command;

import com.br.lp3.APIConsummer.BandsInTownManagerSBLocal;
import com.br.lp3.APIConsummer.SpotifyManagerSBLocal;
import com.br.lp3.entities.Artista;
import com.br.lp3.entities.Evento;
import com.br.lp3.entities.Musica;
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
public class BuscaCommand implements Command{
    BandsInTownManagerSBLocal bandsInTownManagerSB = lookupBandsInTownManagerSBLocal();
    SpotifyManagerSBLocal spotifyManagerSB = lookupSpotifyManagerSBLocal();
    
    private String palavraBusca;

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response, String operacao) {
        
        request.getSession().removeAttribute("buscaMusica");
        request.getSession().removeAttribute("buscaArtista");
        request.getSession().removeAttribute("buscaEvento");
        
        switch (operacao){
            case "musica":
                palavraBusca = request.getParameter("busc_musica");
                List<Musica> lm = spotifyManagerSB.SearchMusica(palavraBusca);
                request.getSession().setAttribute("buscaMusica", lm);
                request.getSession().setAttribute("bm", palavraBusca);
                try {
                    response.sendRedirect("music.jsp");
                } catch (IOException ex) {
                    Logger.getLogger(BuscaCommand.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            case "artista":
                palavraBusca = request.getParameter("busc_artista");
                List<Artista> la = spotifyManagerSB.searchArtista(palavraBusca);
                request.getSession().setAttribute("buscaArtista", la);
                request.getSession().setAttribute("ba", palavraBusca);
                try {
                    response.sendRedirect("artist.jsp");
                } catch (IOException ex) {
                    Logger.getLogger(BuscaCommand.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            case "evento":
                palavraBusca = request.getParameter("busc_evento");
                List<Evento> le = bandsInTownManagerSB.SearchEvento(palavraBusca);
                request.getSession().setAttribute("buscaEvento", le);
                request.getSession().setAttribute("be", palavraBusca);
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

    private BandsInTownManagerSBLocal lookupBandsInTownManagerSBLocal() {
        try {
            Context c = new InitialContext();
            return (BandsInTownManagerSBLocal) c.lookup("java:global/LikeHolder/LikeHolder-ejb/BandsInTownManagerSB!com.br.lp3.APIConsummer.BandsInTownManagerSBLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
}
