package com.br.lp3.mdb;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 *
 * @author Lucas Brasilio
 */
@MessageDriven(mappedName = "jms/lucas", activationConfig = {
    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue")
})
public class ConsumerMDB implements MessageListener {
    
    public ConsumerMDB() {
    }
    
    @Override
    public void onMessage(Message message) {
        TextMessage tm = (TextMessage) message;
        String arquivo = "C:\\Temp\\LikeHolder\\log.txt";
        try {
            byte[] bt = carregar(new File(arquivo));
            
            String s = new String(bt);
            
            Calendar cal = Calendar.getInstance();
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            String dataSt = formatter.format(cal.getTime()); //horário do servidor
            String st = s + "(" + dataSt + ") " + tm.getText() + "\r\n";
            System.out.println(st);
            
            salvar(new File(arquivo), st);
        } catch (JMSException ex) {
            System.out.println(ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public static void salvar(File arquivo, String conteudo) throws IOException, Exception {
        FileOutputStream streamDeSaida = new FileOutputStream(arquivo);
        streamDeSaida.write(conteudo.getBytes());
        streamDeSaida.close();
    }
    
    public static byte[] carregar(File arquivo) throws Exception {
        FileInputStream dispositivoDeEntrada = new FileInputStream(arquivo);
        byte[] conteudo = new byte[dispositivoDeEntrada.available()];
        dispositivoDeEntrada.read(conteudo);
        return conteudo;
    }
    
}
