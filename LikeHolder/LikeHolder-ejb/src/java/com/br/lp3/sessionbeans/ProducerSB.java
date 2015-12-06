package com.br.lp3.sessionbeans;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.Stateful;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

/**
 *
 * @author Lucas Brasilio
 */
@Stateful
public class ProducerSB implements ProducerSBLocal {
    @Resource(mappedName = "jms/lucas")
    private Queue lucas;
    @Resource(mappedName = "jms/lucasFactory")
    private ConnectionFactory lucasFactory;

    @Override
    public void sendMessage(String message) throws JMSException {
        sendJMSMessageToLucas(message);
    }

    private Message createJMSMessageForjmsLucas(Session session, Object messageData) throws JMSException {
        // TODO create and populate message to send
        TextMessage tm = session.createTextMessage();
        tm.setText(messageData.toString());
        return tm;
    }

    private void sendJMSMessageToLucas(Object messageData) throws JMSException {
        Connection connection = null;
        Session session = null;
        try {
            connection = lucasFactory.createConnection();
            session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            MessageProducer messageProducer = session.createProducer(lucas);
            messageProducer.send(createJMSMessageForjmsLucas(session, messageData));
        } finally {
            if (session != null) {
                try {
                    session.close();
                } catch (JMSException e) {
                    Logger.getLogger(this.getClass().getName()).log(Level.WARNING, "Cannot close session", e);
                }
            }
            if (connection != null) {
                connection.close();
            }
        }
    }
}
