package com.br.lp3.APIConsummer;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 31452760
 */
public class APIManager {
    private static final String pathDefault = "C:\\Temp\\json\\";
    
    public static HttpURLConnection ProxyAuth(URL url){
        HttpURLConnection conn = null; 
        try {
            //Conexão HTTP proxy
            Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("172.16.0.10", 3128));
            conn = (HttpURLConnection) url.openConnection(proxy);
            
            //Para autenticar:
            System.setProperty("http.proxyUser", "user");
            System.setProperty("http.proxyPassword", "password");
        } catch (IOException ex) {
            Logger.getLogger(APIManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conn;
    }
    
    public static void gravar(String content, String arquivo){
        FileOutputStream streamDeSaida = null;
        try {
            streamDeSaida = new FileOutputStream(pathDefault + arquivo);	
            streamDeSaida.write(content.getBytes());
            streamDeSaida.close();
        } catch (IOException ex) {
            Logger.getLogger(APIManager.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                streamDeSaida.close();
            } catch (IOException ex) {
                Logger.getLogger(APIManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public static String carregar(String arquivo){
        FileInputStream	dispositivoDeEntrada = null;
        try {
            dispositivoDeEntrada = new FileInputStream(pathDefault + arquivo);
            byte[] conteudo = new byte[dispositivoDeEntrada.available()];
            dispositivoDeEntrada.read(conteudo);
            String str = new String(conteudo, StandardCharsets.UTF_8);
            return str;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(APIManager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(APIManager.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                dispositivoDeEntrada.close();
            } catch (IOException ex) {
                Logger.getLogger(APIManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }    
}
