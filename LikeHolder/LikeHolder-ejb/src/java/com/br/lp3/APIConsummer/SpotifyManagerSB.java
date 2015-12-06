package com.br.lp3.APIConsummer;

import static com.br.lp3.APIConsummer.APIManager.ProxyAuth;
import static com.br.lp3.APIConsummer.APIManager.gravar;
import com.br.lp3.entities.Artista;
import com.br.lp3.entities.Musica;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Stateful;

/**
 *
 * @author Thomaz
 */
@Stateful
public class SpotifyManagerSB implements SpotifyManagerSBLocal {
    @EJB
    private SpotifyParserSBLocal spotifyParserSB;
    private static String urlBaseSearch = "https://api.spotify.com/v1/search?q=";
    private static String urlBaseGet = "https://api.spotify.com/v1";
    
    @Override
    public List<Artista> searchArtista(String artista) {
        URL u;
        List<Artista> artistas = new ArrayList<>();
        
        String art = artista.replace(" ", "%20");
        String url = urlBaseSearch + art +  "&type=artist";
        
        try {
            u = new URL(url);
            
            HttpURLConnection httpcon = ProxyAuth(u);
            //HttpURLConnection httpcon = (HttpURLConnection) u.openConnection();
            
            BufferedReader rd = new BufferedReader( new InputStreamReader(httpcon.getInputStream())) ;

            StringBuilder sb = new StringBuilder();
            String line;
            while( (line = rd.readLine()) != null ){
                sb.append(line);
            }
            String arquivo = "xpto.json";
            rd.close();
            httpcon.disconnect();
            //gravar(sb.toString(), arquivo);
            
             artistas = spotifyParserSB.ParserArtista(sb.toString());
        } catch (MalformedURLException ex) {
            Logger.getLogger(SpotifyManagerSB.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(SpotifyManagerSB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return artistas;
    }

    @Override
    public List<Musica> SearchMusica(String musica) {
        URL u;
        List<Musica> musicas = new ArrayList<>();
        
        String art = musica.replace(" ", "%20");
        String url = urlBaseSearch + art +  "&type=track";
        
        try {
            u = new URL(url);
            
            HttpURLConnection httpcon = ProxyAuth(u);
            //HttpURLConnection httpcon = (HttpURLConnection) u.openConnection();
            
            BufferedReader rd = new BufferedReader( new InputStreamReader(httpcon.getInputStream())) ;

            StringBuilder sb = new StringBuilder();
            String line;
            while( (line = rd.readLine()) != null ){
                sb.append(line);
            }
            String arquivo = "xpto.json";
            rd.close();
            httpcon.disconnect();
            //gravar(sb.toString(), arquivo);
            
             musicas = spotifyParserSB.ParseMusica(sb.toString());
        } catch (MalformedURLException ex) {
            Logger.getLogger(SpotifyManagerSB.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(SpotifyManagerSB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return musicas;
    }

    @Override
    public Artista getArtista(String id) {
        URL u;
        String url = urlBaseGet + "/artists/" +  id;
        Artista artista = null;
        try {
            u = new URL(url);
            
            HttpURLConnection httpcon = ProxyAuth(u);
            //HttpURLConnection httpcon = (HttpURLConnection) u.openConnection();
            
            BufferedReader rd = new BufferedReader( new InputStreamReader(httpcon.getInputStream())) ;

            StringBuilder sb = new StringBuilder();
            String line;
            while( (line = rd.readLine()) != null ){
                sb.append(line);
            }
            String arquivo = "xpto.json";
            rd.close();
            httpcon.disconnect();
            //gravar(sb.toString(), arquivo);
            
             artista = spotifyParserSB.ParseGetArtista(sb.toString());
        } catch (MalformedURLException ex) {
            Logger.getLogger(SpotifyManagerSB.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(SpotifyManagerSB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return artista;
    }

    @Override
    public Musica getMusica(String id) {
        URL u;
        String url = urlBaseGet + "/tracks/" +  id;
        Musica musica = null;
        try {
            u = new URL(url);
            
            HttpURLConnection httpcon = ProxyAuth(u);
            //HttpURLConnection httpcon = (HttpURLConnection) u.openConnection();
            
            BufferedReader rd = new BufferedReader( new InputStreamReader(httpcon.getInputStream())) ;

            StringBuilder sb = new StringBuilder();
            String line;
            while( (line = rd.readLine()) != null ){
                sb.append(line);
            }
            String arquivo = "xpto.json";
            rd.close();
            httpcon.disconnect();
            //gravar(sb.toString(), arquivo);
            
             musica = spotifyParserSB.ParseGetMusica(sb.toString());
        } catch (MalformedURLException ex) {
            Logger.getLogger(SpotifyManagerSB.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(SpotifyManagerSB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return musica;
    }
    
}
