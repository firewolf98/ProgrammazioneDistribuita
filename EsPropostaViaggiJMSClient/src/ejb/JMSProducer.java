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
public class JMSProducer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws NamingException {
        Context ctx = new InitialContext();
        ConnectionFactory cf = (ConnectionFactory) ctx.lookup("jms/javaee7/ConnectionFactory");
        Destination topic = (Destination) ctx.lookup("jms/javaee7/Topic");
        try(JMSContext jmsc = cf.createContext())
        {
            PropostaViaggio viaggio = new PropostaViaggio("", "", 0f, 50, 0);
            viaggio.setId(2);
            jmsc.createProducer().send(topic, viaggio);
        }
            
    }
    
}
