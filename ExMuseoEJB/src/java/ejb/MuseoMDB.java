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
 * @author lucae
 */
@MessageDriven(mappedName="jms/javaee7/Topic")
public class MuseoMDB implements MessageListener{
    @Inject
    private MuseoEJB museoejb;
    @Override
    public void onMessage(Message message) {
        try {
            Museo m=message.getBody(Museo.class);
            museoejb.updateMuseo(m);
            System.out.println("Messaggio ricevuto, contiene: "+m);
        }
        catch(JMSException ex) {
            Logger.getLogger(MuseoMDB.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
}
