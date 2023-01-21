/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.MessageDriven;
import javax.inject.Inject;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

/**
 *
 * @author Eugenio
 */
@MessageDriven(mappedName = "jms/javaee7/Topic")
public class UnescoMDB implements MessageListener{
    @Inject
    UnescoEJB unescoEjb;
    @Override
    public void onMessage(Message message) {
        try {
            Unesco u = message.getBody(Unesco.class);
            unescoEjb.createSitoUnesco(u);
            System.out.println("Messaggio ricevuto è stato aggiunto il sito : "+u);
        } catch (JMSException ex) {
            Logger.getLogger(UnescoMDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
