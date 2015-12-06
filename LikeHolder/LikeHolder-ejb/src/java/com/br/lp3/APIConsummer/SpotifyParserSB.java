package com.br.lp3.APIConsummer;

import com.br.lp3.entities.Artista;
import com.br.lp3.entities.Musica;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateful;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;

/**
 *
 * @author Thomaz
 */
@Stateful
public class SpotifyParserSB implements SpotifyParserSBLocal {

    @Override
    public List<Artista> ParserArtista(String content) {
        List<Artista> artistas = new ArrayList<>();

        try{
            JsonReader jsonreader = Json.createReader(new StringReader(content));
            JsonObject mainobj = jsonreader.readObject();
            jsonreader.close();
            
            JsonObject mo = mainobj.getJsonObject("artists");
            JsonArray itens = mo.getJsonArray("items");
            
            for (int i = 0; i < itens.size(); i++) {
                JsonObject item = itens.getJsonObject(i);
                
                String artistLink = item.getJsonObject("external_urls").getString("spotify");
                int follower = item.getJsonObject("followers").getInt("total");
                String id = item.getString("id");
                String name = item.getString("name");
                
                JsonObject img = item.getJsonArray("images").getJsonObject(0);
                String urlImg = img.getString("url");
                int height = img.getInt("height");
                int width = img.getInt("width");
                
                artistas.add(new Artista(id, artistLink, name, follower, urlImg, height, width));
            }
        } catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return artistas;
    }

    @Override
    public List<Musica> ParseMusica(String content) {
        List<Musica> musicas = new ArrayList<>();

        try{
            JsonReader jsonreader = Json.createReader(new StringReader(content));
            JsonObject mainobj = jsonreader.readObject();
            jsonreader.close();
            
            JsonObject mo = mainobj.getJsonObject("tracks");
            JsonArray itens = mo.getJsonArray("items");
            
            for (int i = 0; i < itens.size(); i++) {
                JsonObject item = itens.getJsonObject(i);
                
                String artistLink = item.getJsonObject("external_urls").getString("spotify");
                String id = item.getString("id");
                String name = item.getString("name");
                String uri = item.getString("uri");
            
                JsonObject art = item.getJsonArray("artists").getJsonObject(0);
                String nmArtista = art.getString("name");
                
                musicas.add(new Musica(id, artistLink, uri, name, nmArtista));
            }
        } catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return musicas;
    }

    @Override
    public Artista ParseGetArtista(String content) {
        Artista artista = null;
        try{
            JsonReader jsonreader = Json.createReader(new StringReader(content));
            JsonObject mainobj = jsonreader.readObject();
            jsonreader.close();

            String artistLink = mainobj.getJsonObject("external_urls").getString("spotify");
            int follower = mainobj.getJsonObject("followers").getInt("total");
            String id = mainobj.getString("id");
            String name = mainobj.getString("name");

            JsonObject img = mainobj.getJsonArray("images").getJsonObject(0);
            String urlImg = img.getString("url");
            int height = img.getInt("height");
            int width = img.getInt("width");

            artista = new Artista(id, artistLink, name, follower, urlImg, height, width);
        } catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return artista;
    }

    @Override
    public Musica ParseGetMusica(String content) {
        Musica musica = null;
        try{
            JsonReader jsonreader = Json.createReader(new StringReader(content));
            JsonObject mainobj = jsonreader.readObject();
            jsonreader.close();

            String artistLink = mainobj.getJsonObject("external_urls").getString("spotify");
            String id = mainobj.getString("id");
            String name = mainobj.getString("name");
            String uri = mainobj.getString("uri");

            JsonObject art = mainobj.getJsonArray("artists").getJsonObject(0);
            String nmArtista = art.getString("name");
            
            musica = new Musica(id, uri, uri, name, nmArtista);
        } catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return musica;
    }
    
    

}
