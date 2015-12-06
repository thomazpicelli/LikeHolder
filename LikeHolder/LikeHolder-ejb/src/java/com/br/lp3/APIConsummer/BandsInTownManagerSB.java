package com.br.lp3.APIConsummer;

import static com.br.lp3.APIConsummer.APIManager.ProxyAuth;
import com.br.lp3.entities.Evento;
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
public class BandsInTownManagerSB implements BandsInTownManagerSBLocal {
    @EJB
    private BandsInTownParserSBLocal bandsInTownParserSB;
    
    private static String myID = "LikeholderID";
    private static String urlbaseArtist = "http://api.bandsintown.com/events/search?artists[]=";
    private static String urlFinal = "&format=json&app_id=";
    
    @Override
    public List<Evento> SearchEvento(String evento) {
        URL u;
        List<Evento> eventos = new ArrayList<>();
        String ev = evento.replace(" ", "%20");
        String url = urlbaseArtist + ev + urlFinal + myID;
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
            
             eventos = bandsInTownParserSB.ParserEvento(sb.toString());
        } catch (MalformedURLException ex) {
            Logger.getLogger(BandsInTownManagerSB.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(BandsInTownManagerSB.class.getName()).log(Level.SEVERE, null, ex);
        }    
        return eventos;
    }
}