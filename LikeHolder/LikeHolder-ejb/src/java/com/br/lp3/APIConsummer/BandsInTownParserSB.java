package com.br.lp3.APIConsummer;

import com.br.lp3.entities.Evento;
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
public class BandsInTownParserSB implements BandsInTownParserSBLocal {

    @Override
    public List<Evento> ParserEvento(String content) {
        List<Evento> eventos = new ArrayList<>();
        try{
            JsonReader jsonReader = Json.createReader(new StringReader(content));
            JsonArray mainobj =  jsonReader.readArray();
            jsonReader.close();
            
            for (int i = 0; i < mainobj.size(); i++) {
                JsonObject main = mainobj.getJsonObject(i);
                
                int id = main.getInt("id");
                String dcId = String.valueOf(id); 
                String url = main.getString("url");
                String ticket = main.getString("ticket_url");
                
                JsonObject local = main.getJsonObject("venue");
                String nmLocal = local.getString("name");
                String city = local.getString("city");
                
                eventos.add(new Evento(dcId, url, ticket, nmLocal, city));
            }
        } catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return eventos;
    }
}
