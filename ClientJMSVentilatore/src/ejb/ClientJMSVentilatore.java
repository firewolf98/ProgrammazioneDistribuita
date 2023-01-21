/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSContext;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author Eugenio
 */
public class ClientJMSVentilatore {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws NamingException {
        Context c = new InitialContext();
        ConnectionFactory cf = (ConnectionFactory)c.lookup("jms/javaee7/ConnectionFactory");
        Destination topic = (Destination)c.lookup("jms/javaee7/Topic");
        try(JMSContext jmsC= cf.createContext())
        {
            Ventilatore v = new Ventilatore();
            v.setId(1);
            v.setElementiVenduti(100);
            jmsC.createProducer().send(topic, v);
        }
    }
    
}
