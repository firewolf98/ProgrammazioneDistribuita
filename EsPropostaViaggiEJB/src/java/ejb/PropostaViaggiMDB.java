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
public class PropostaViaggiMDB implements MessageListener{
    @Inject
    PropostaViaggiEJB pvejb;
    
    @Override
    public void onMessage(Message message) {
        try {
            PropostaViaggio viaggioTemp = message.getBody(PropostaViaggio.class);
            System.out.println("Messaggio ricevuto , il messaggio contiene : "+viaggioTemp);
            System.out.println("Ricerca viaggio con id : "+viaggioTemp.getId());
            PropostaViaggio v = pvejb.findViaggioById(viaggioTemp.getId());
            System.out.println("Modifica sconto del viaggio "+ v+" sconto da applicare: "+viaggioTemp.getSconto()); 
            v.setSconto(viaggioTemp.getSconto());
            System.out.println("Viaggio modificato con successo il risultato è : "+v);
        } catch (JMSException ex) {
            Logger.getLogger(PropostaViaggiMDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    

   
    
    
}
