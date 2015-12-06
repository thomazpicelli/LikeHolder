package com.br.lp3.sessionbeans;

import javax.ejb.Local;
import javax.jms.JMSException;

/**
 *
 * @author Lucas Brasilio dos Santos
 */
@Local
public interface ProducerSBLocal {

    void sendMessage(String message) throws JMSException;
    
}
